package com.soda1127.androidlecture01.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.soda1127.androidlecture01.R
import com.soda1127.androidlecture01.model.Gender
import com.soda1127.androidlecture01.model.Human

interface ResultListener {
    fun humanReceived(human: Human)
}

class BFragment() : Fragment() {

    private lateinit var listener: ResultListener

    constructor(listener: ResultListener) : this() {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_b, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener.humanReceived(Human("soda", 23, Gender.MAN))
    }

    companion object {
        fun newInstance() = BFragment()
    }
}

