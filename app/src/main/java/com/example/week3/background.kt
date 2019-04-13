package com.example.week3

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_background.*


class background : AppCompatActivity() {
    private var sourceImage: String? = "cry"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)
        val background_data :Bundle ? = intent.extras
        if (background_data != null ){
            val background_data_name = background_data.getString("mainImage")
            val reID = resources.getIdentifier(background_data_name, "drawable", packageName)
            img_view.setImageResource(reID)
        }
    }

    fun btnHeart(view: View) {
        changeBackground("heart" )
    }
    fun btnGlad(view: View) {
        changeBackground("glad" )
    }
    fun btnMyhouse(view: View) {
        changeBackground("myhouse" )
    }
    fun btnCry(view: View) {
        changeBackground("cry" )
    }
    fun btnApple(view: View) {
        changeBackground("apple" )
    }
    fun btnFeet(view: View) {
        changeBackground("feet" )
    }

    private fun changeBackground(sor  : String){
        val mDrawableName:String? = sor
        sourceImage = sor
        val resID = resources.getIdentifier(mDrawableName, "drawable", packageName)
        img_view.setImageResource(resID)
    }

    fun btnSave(view: View){
        intent.putExtra("source", sourceImage)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}