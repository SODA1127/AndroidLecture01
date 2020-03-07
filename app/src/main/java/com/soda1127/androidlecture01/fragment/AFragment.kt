package com.soda1127.androidlecture01.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.soda1127.androidlecture01.R
import com.soda1127.androidlecture01.model.Human

class AFragment : Fragment() {

    private lateinit var aText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_a, container, false)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        aText = view.findViewById(R.id.a_text)

        val human = arguments?.getParcelable<Human>("human")

        human?.let {
            aText.text = "name : ${human.name} | age : ${human.age} | gender : ${human.gender.type}"
        }
    }

    companion object {
        fun newInstance() = AFragment()
    }
}

