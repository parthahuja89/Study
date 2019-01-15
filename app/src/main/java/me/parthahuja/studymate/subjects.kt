package me.parthahuja.studymate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.widget.Button
import android.widget.TextView

class subjects : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        //Add card Fab Id
        var add_card = findViewById<FloatingActionButton>(R.id.add_button)

        //Listener for Fab
        add_card.setOnClickListener {
            dialogview()
        }

    }

    /*
     * Method Runs when + Fab clicked to open inflated dialog
     */
    fun dialogview(){

        print("Opening Dialog")

        //importing and inflating custom layout add_dialog
        val dialog = layoutInflater.inflate(R.layout.add_dialog, null)

        //Accessing attributes inside dialog_layout
        var textView = dialog.findViewById<TextView>(R.id.textView3)
        var cancel = dialog.findViewById<Button>(R.id.button_cancel)

        //Using Alert Builder with custom layout (dialog) inflated
        val builder = AlertDialog.Builder(this)
        builder.setView(dialog)
        val window = builder.create()
        window.show()

        //cancel button listener
        cancel.setOnClickListener {
            window.dismiss()
        }
    }
}
