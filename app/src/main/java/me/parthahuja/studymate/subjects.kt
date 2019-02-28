package me.parthahuja.studymate

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import android.widget.TextView

class subjects : AppCompatActivity() {
    var image_uri = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    /**
     * Layout Setup: Recycler view with default LinearLayoutManager
     * Setting up listener for the + Fab here, Probably not the best practice
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjects)

        //Layout Setup -- TESTING RECYCLE VIEW
        //Reference: https://developer.android.com/guide/topics/ui/layout/recyclerview

        viewManager = LinearLayoutManager(this)

        /*
        + ViewAdapter manages all the view holder i.e each card
        + constructor has all the flood data
        */
        var myDataset: Array<String> = arrayOf("green", "red", "blue")
        viewAdapter = CardsAdapter(myDataset)


        recyclerView = findViewById<RecyclerView>(R.id.recycle_main_view).apply {
            // configure this later
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }

        //Fab + Setup
        var add_card = findViewById<FloatingActionButton>(R.id.add_button)

        //Listener for Fab
        add_card.setOnClickListener {
            dialogview()
        }

    }

    /**
     * Method Runs when + Fab clicked to open inflated dialog 🤟
     *                                              |
     *                                              |-- Inflated Dialog currently allows user to add new ｓｕｂｊｅｃｔ
     *                                              |-- TODO: Implement XML addition of new card with automation
     */
    fun dialogview(){

        print("Opening Dialog")

        //importing and inflating custom layout add_dialog
        val dialog = layoutInflater.inflate(R.layout.add_dialog, null)

        //Accessing attributes inside dialog_layout
        var textView = dialog.findViewById<TextView>(R.id.textView3)
        var cancel = dialog.findViewById<Button>(R.id.button_cancel)
        var add_image_button = dialog.findViewById<Button>(R.id.add_image)

        //Using Alert Builder with custom layout (dialog) inflated
        val builder = AlertDialog.Builder(this)
        builder.setView(dialog)
        val window = builder.create()
        window.show()

        //cancel button listener
        cancel.setOnClickListener {
            window.dismiss()
        }

        //add_image button opens the gallery
        add_image_button.setOnClickListener {
            getUserImage()
        }
    }

    /**
     * -- Opens gallery and allows user to select images
     * -- TODO: Allow user to crop images, Add retrieval of the image
     */
    fun getUserImage(){
        Log.d("IMAGE", "Image picked!")
        var load_result = 1
        val open_gallery = Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        open_gallery.setType("image/*")
        startActivityForResult(open_gallery, load_result)

        //when image is selected onActivityResult should be triggered
    }

    /**
     * Triggered once image is selected form the user gallery
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Activity.RESULT_OK){
            //selection complete request uri

        }
    }
}
