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
import com.example.jswhatsapp.models.ChatContact

class ChatContactsAdapter (var context: Context, var arrayList: ArrayList<ChatContact>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var ChatContact = LayoutInflater.from(context).inflate(R.layout.chat_contacts_ticket, parent, false)
        return ChatContactViewHolder(ChatContact)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as ChatContactViewHolder).initializeUIComponent(
            arrayList[position].id,
            arrayList[position].name,
            arrayList[position].description,
            arrayList[position].time,
            arrayList[position].profileImage)

    }

    inner class ChatContactViewHolder(myView: View)
        : RecyclerView.ViewHolder(myView){

        var cNameTextView = myView.findViewById<TextView>(R.id.cct_name)
        var cDescriptionTextView = myView.findViewById<TextView>(R.id.cct_description)
        var cTimeTextView = myView.findViewById<TextView>(R.id.cct_time)
        var cProfileImageTextView = myView.findViewById<ImageView>(R.id.cct_profile_image)

        fun initializeUIComponent(cID: Int, cName: String, cDescription: String, cTime: String, cProfileImage: Int){
            cNameTextView.text = cName
            cDescriptionTextView.text = cDescription
            cTimeTextView.text = cTime
            cProfileImageTextView.setImageResource(cProfileImage)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ChatScreenActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }


    }
}