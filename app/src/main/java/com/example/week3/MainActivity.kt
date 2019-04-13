package com.example.week3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btntitle(view: View){
        val intent = Intent(this,Title_screen::class.java);
        intent.putExtra("EditTextValue",text.getText())
        startActivityForResult(intent,999);
    }

    private var receive:String ?= "image"
    fun btnbackground(view: View){
        val intent = Intent(this,background::class.java);
        intent.putExtra("mainImage",receive)
        startActivityForResult(intent,1000);
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 999 && resultCode == Activity.RESULT_OK){
            val Text = data?.getStringExtra("Text")
            val Color = data?.getStringExtra("Color")
            text.setText(Text)
            val myColor = android.graphics.Color.parseColor(Color)
            text.setTextColor(myColor)
        }
        if(requestCode == 1000 && resultCode == Activity.RESULT_OK){
            val sourceImage = data?.getStringExtra("source")
            val image = sourceImage
            receive = image
            val resID = resources.getIdentifier(image, "drawable", packageName)
            imageView.setImageResource(resID)
        }
    }

}
