package me.parthahuja.studymate

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text

/**
 * Adapter for The Recycle View which uses the generic view (custom_card_adapter_layout) and floods it with each
 * entry point provided in the DataSet
 *
 * Note: cardView is the generic layout, SingleView is to parse views
 * CardsAdapter class is consumed on the front-page RecycleView (See: subjects.kt)
 */

class CardsAdapter(private val Dataset: Array<String>) :
    RecyclerView.Adapter<CardsAdapter.SingleView>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SingleView {
        val cardView = LayoutInflater.from(p0.context)
            .inflate(R.layout.custom_card_adapter_layout, p0, false)
        return SingleView(cardView)

    }

    //total number of cards on screen
    override fun getItemCount() = Dataset.size

    override fun onBindViewHolder(p0: SingleView, p1: Int) {
        //flooding data into the layout
        val title = p0.cardView.findViewById<TextView>(R.id.subject_ID)

        title.text = Dataset[p1]
        //TODO: Assign course description
    }

    //each data point is a card
    //setting up generic CardView object

    class SingleView(val cardView: View) : RecyclerView.ViewHolder(cardView)

    }