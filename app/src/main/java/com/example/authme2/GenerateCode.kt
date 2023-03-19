package com.example.authme2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class GenerateCode : Fragment() {

    lateinit var mNewCode: TextView
    lateinit var mTimer: TextView
    lateinit var mTimerCounter: CountDownTimer

    companion object {

        fun newInstance(): GenerateCode {
            return GenerateCode()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.activity_generate_code, container, false)


        mNewCode = view.findViewById(R.id.new_code)
        mTimer = view.findViewById(R.id.timer)

        mTimerCounter = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimer.setText((millisUntilFinished / 1000).toString())
                // logic to set the EditText could go here
            }

            override fun onFinish() {
                getNewCode()
            }
        }.start()

        return view
    }

    private fun getNewCode() {
        mTimerCounter.start()
    }
}
