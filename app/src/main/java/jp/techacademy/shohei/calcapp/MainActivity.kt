package jp.techacademy.shohei.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.support.design.widget.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_plus.setOnClickListener(this)
        button_minus.setOnClickListener(this)
        button_time.setOnClickListener(this)
        button_div.setOnClickListener(this)

    }

    override fun onClick(v:View){
        if(editText1.text.toString().length!=0&&editText2.text.toString().length!=0
            &&editText1.text.toString()!="."&&editText2.text.toString()!=".") {

            val intent = Intent(this, CalcOut::class.java)
            var val1: Float = editText1.text.toString().toFloat()
            var val2: Float = editText2.text.toString().toFloat()
            var send: String

            if (v.id == R.id.button_plus) {
                send = (val1 + val2).toString()
            } else if (v.id == R.id.button_minus) {
                send = (val1 - val2).toString()
            } else if (v.id == R.id.button_time) {
                send = (val1 * val2).toString()
            } else {
                if(val2!=0F) {
                    send = (val1 / val2).toString()
                }else{
                    Snackbar.make(v, "0での割り算はできません", Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show()
                    return
                }
            }

            intent.putExtra("VALUE1", send)
            startActivity(intent)

        }else{

            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
        }
    }
}
