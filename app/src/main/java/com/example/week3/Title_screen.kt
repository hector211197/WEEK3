package com.example.week3

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_title_screen.*

class Title_screen : AppCompatActivity() {
    private var dfText: String? = "K15 FETEL"
    private var dfColor = "#CC00CC"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_title_screen)
        Edit1.setText(dfText)
        val title_data: Bundle? = intent.extras
        if (title_data != null) {
            val title_content = title_data.getString("EditTextValue")
            Edit1.setText(title_content)
        }
    }

    fun btnTim(view: View) {
        changeColor("#CC00CC", "btn1")
    }
    fun btnXanhLa(view: View) {
        changeColor("#339900", "btn2")
    }
    fun btnVang(view: View) {
        changeColor("#FDD109", "btn3")
    }
    fun btnDuong(view: View) {
        changeColor("#0000FF", "btn4")
    }
    fun btnKem(view: View) {
        changeColor("#FFCCFF", "btn5")
    }
    fun btnNau(view: View) {
        changeColor("#990000", "btn6")
    }

    private fun changeColor(a: String, b: String) {
        dfColor = a;
        val mDrawableName: String? = b
        val resID = resources.getIdentifier(mDrawableName, "drawable", packageName)
        btn0.setBackgroundResource(resID)
    }

    fun btnSAVE(view: View) {
        dfText = Edit1.text.toString()
        intent.putExtra("Color", dfColor)
        intent.putExtra("Text", dfText)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
