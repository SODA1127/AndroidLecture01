package com.soda1127.androidlecture01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.soda1127.androidlecture01.fragment.AFragment
import com.soda1127.androidlecture01.fragment.BFragment
import com.soda1127.androidlecture01.fragment.ResultListener
import com.soda1127.androidlecture01.model.Gender
import com.soda1127.androidlecture01.model.Human


class MainActivity : AppCompatActivity(), ResultListener {

    private lateinit var switchButton: Button
    private lateinit var messageText: TextView
    private lateinit var actionButton: Button

    private val fm: FragmentManager by lazy { supportFragmentManager }

    enum class FragmentState { A, B }

    private var nowFragment = FragmentState.A

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // A / B 프래그먼트 초기화
        initFragment()

        // 뷰 초기화
        switchButton = findViewById(R.id.switch_button)
        messageText = findViewById(R.id.message_text)
        actionButton = findViewById(R.id.action_button)

        switchButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                switchFragment(nowFragment)
            }
        })

        // 액션 버튼 리스너 등록
        actionButton.setOnClickListener(object : View.OnClickListener {
            @SuppressLint("SetTextI18n")
            override fun onClick(view: View?) {
                messageText.text = "Action Done"

                val intent = Intent(this@MainActivity, NextActivity::class.java)
                intent.putExtra("extra", "data")
                intent.putExtra("human", Human("soda", 23, Gender.MAN))
                startActivity(intent)
            }
        })
    }

    private fun initFragment() {
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        val aFragment = AFragment()
        aFragment.arguments = Bundle().apply {
            putParcelable("human", Human("soda", 23, Gender.MAN))
        }
        fragmentTransaction.add(R.id.fragment_a_b_layout, aFragment)
        fragmentTransaction.commit()
    }

    private fun switchFragment(state: FragmentState) {
        val fragmentTransaction: FragmentTransaction = fm.beginTransaction()
        nowFragment = when(state) {
            FragmentState.A -> {
                fragmentTransaction.replace(R.id.fragment_a_b_layout, BFragment(this))
                FragmentState.B
            }
            FragmentState.B -> {
                fragmentTransaction.replace(R.id.fragment_a_b_layout, AFragment())
                FragmentState.A
            }
        }
        fragmentTransaction.commit()
    }

    @SuppressLint("SetTextI18n")
    override fun humanReceived(human: Human) {
        human.let {
            messageText.text = "name : ${human.name} | age : ${human.age} | gender : ${human.gender.type}"
        }
    }
}

