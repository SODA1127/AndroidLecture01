package com.soda1127.androidlecture01

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.soda1127.androidlecture01.model.Human

class NextActivity : AppCompatActivity() {

    private lateinit var nextText: TextView
    private lateinit var finishButton: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        nextText = findViewById(R.id.next_text)
        finishButton = findViewById(R.id.finish_button)

        //val extraData: String? = intent.getStringExtra("extra")
        val extraData: Human? = intent.getParcelableExtra("human")

        extraData?.let { human ->
            //finishButton.text = it
            nextText.text = "name : ${human.name} | age : ${human.age} | gender : ${human.gender.type}"
        }

        finishButton.setOnClickListener {
            finish()
        }
    }
}

