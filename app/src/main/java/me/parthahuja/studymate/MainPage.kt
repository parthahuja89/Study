package me.parthahuja.studymate

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main_page.*
import java.util.*

class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)


        val button_element = findViewById<Button>(R.id.roll)

        //listening for button_element click
        button_element.setOnClickListener {
            routeSecond()
        }
    }
    /*
    Routing to different activity page
     */
    fun routeSecond(){
        val route = Intent(this, subjects::class.java)
        startActivity(route)
    }
}
