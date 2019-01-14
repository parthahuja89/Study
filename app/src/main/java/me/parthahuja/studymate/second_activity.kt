package me.parthahuja.studymate

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.widget.Button

import kotlinx.android.synthetic.main.activity_second_activity.*

class second_activity : AppCompatActivity() {

    /*
     * Method Runs when onCreate View
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activity)
        setSupportActionBar(toolbar)

        //Add card Fab Id
        var add_card = findViewById<FloatingActionButton>(R.id.add_button)

        //Listener for Fab
        add_card.setOnClickListener {
            dialogview()
        }

     }

    /*
     * Method Runs when + Fab clicked
     */
    fun dialogview(){

         print("Opening Dialog")


     }

}
