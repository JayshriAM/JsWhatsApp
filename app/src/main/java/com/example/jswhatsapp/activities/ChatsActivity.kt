package com.example.jswhatsapp.activities

import android.os.Bundle
import android.view.Gravity
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jswhatsapp.R
import com.example.jswhatsapp.adapters.ChatContactsAdapter
import com.example.jswhatsapp.models.ChatContact
import kotlinx.android.synthetic.main.activity_chats.*


class ChatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chats)

        var myChatContactsList = ArrayList<ChatContact>()
        myChatContactsList.add(ChatContact(0, "Berlin", "La casa de papel", "5:00 am", R.drawable.berlin))
        myChatContactsList.add(ChatContact(0, "Cincinatti", "La casa de papel", "5:00 am", R.drawable.cincinnati))
        myChatContactsList.add(ChatContact(0, "Denver", "La casa de papel", "5:00 am", R.drawable.denver))
        myChatContactsList.add(ChatContact(0, "Lisbon", "La casa de papel", "5:00 am", R.drawable.lisbon))
        myChatContactsList.add(ChatContact(0, "Monica", "La casa de papel", "5:00 am", R.drawable.monica))
        myChatContactsList.add(ChatContact(0, "Nairobi", "La casa de papel", "5:00 am", R.drawable.nairobi))
        myChatContactsList.add(ChatContact(0, "Professor", "La casa de papel", "5:00 am", R.drawable.professor))
        myChatContactsList.add(ChatContact(0, "Rio", "La casa de papel", "5:00 am", R.drawable.rio))
        myChatContactsList.add(ChatContact(0, "Tokyo", "La casa de papel", "5:00 am", R.drawable.tokyo))

        var rvAdapter = ChatContactsAdapter(this@ChatsActivity, myChatContactsList)
        chat_contacts_recyclerView.layoutManager = LinearLayoutManager(this@ChatsActivity)
        chat_contacts_recyclerView.adapter = rvAdapter
    }
}
