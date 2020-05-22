package com.example.jswhatsapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jswhatsapp.R
import com.example.jswhatsapp.activities.ChatScreenActivity
import com.example.jswhatsapp.activities.ChatsActivity
import com.example.jswhatsapp.models.Chat
import com.example.jswhatsapp.models.ChatContact

class ChatsAdapter (var context: Context, var arrayList: ArrayList<Chat>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var Chat = LayoutInflater.from(context).inflate(R.layout.sender_chat_ticket, parent, false)
        return ChatContactViewHolder(Chat)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ChatContactViewHolder).initializeUIComponent(
            arrayList[position].message,
            arrayList[position].time)

    }

    inner class ChatContactViewHolder(myView: View)
        : RecyclerView.ViewHolder(myView){

        var cMessage = myView.findViewById<TextView>(R.id.sender_message_text)
        var cTime = myView.findViewById<TextView>(R.id.sender_time_text)

        fun initializeUIComponent(Message: String, Time: String){
            cMessage.text = Message
            cTime.text = Time
        }


    }
}