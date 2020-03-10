package jp.techacademy.shohei.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_calc_out.*
import kotlinx.android.synthetic.main.activity_main.*

class CalcOut : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_out)

        val value1=intent.getStringExtra("VALUE1")
        textView.text=value1
    }
}