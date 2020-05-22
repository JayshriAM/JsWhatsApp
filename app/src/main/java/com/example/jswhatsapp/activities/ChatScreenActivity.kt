package com.example.jswhatsapp.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jswhatsapp.R
import com.example.jswhatsapp.adapters.ChatContactsAdapter
import com.example.jswhatsapp.adapters.ChatsAdapter
import com.example.jswhatsapp.models.Chat
import com.example.jswhatsapp.models.ChatContact
import kotlinx.android.synthetic.main.activity_chat_screen.*
import kotlinx.android.synthetic.main.activity_chats.*
import kotlinx.android.synthetic.main.reciever_chat_ticket.view.*
import kotlinx.android.synthetic.main.sender_chat_ticket.view.*

class ChatScreenActivity : AppCompatActivity() {

    var myChatsList = ArrayList<Chat>()
    var adapter: MyChatAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_screen)

//        var myChatsList = ArrayList<Chat>()
//        myChatsList.add(Chat(0, "Hi", "5:00 am", "a","a",true,false))
//        myChatsList.add(Chat(1, "Hi", "5:00 am", "a","a", false, true))
//        myChatsList.add(Chat(2, "William Henry Gates III is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation", "5:00 am", "a","a",true,false))
//        myChatsList.add(Chat(3, "Steven Paul Jobs was an American business magnate, industrial designer, investor, and media proprietor.", "5:00 am", "a","a",false, true))
//        myChatsList.add(Chat(4, "World", "5:00 am", "a","a",true,false))
//
//        var rvAdapter = ChatsAdapter(this@ChatScreenActivity, myChatsList)
//        chatsListView.layoutManager = LinearLayoutManager(this@ChatScreenActivity)
//        chatsListView.adapter = rvAdapter

        myChatsList.add(Chat(0, "Hi", "5:00 am", "a","a",true,false))
        myChatsList.add(Chat(1, "Hi", "5:00 am", "a","a", false, true))
        myChatsList.add(Chat(2, "William Henry Gates III is an American business magnate, software developer, investor, and philanthropist. He is best known as the co-founder of Microsoft Corporation", "5:00 am", "a","a",true,false))
        myChatsList.add(Chat(3, "Steven Paul Jobs was an American business magnate, industrial designer, investor, and media proprietor.", "5:00 am", "a","a",false, true))
        myChatsList.add(Chat(4, "World", "5:00 am", "a","a",true,false))

        adapter = MyChatAdapter(this,myChatsList)
        chatsListView.adapter = adapter
        adapter!!.notifyDataSetChanged()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_chat_screen, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    inner class MyChatAdapter: BaseAdapter{
        var listChatsAdapter = ArrayList<Chat>()
        var context:Context?= null
        constructor(context: Context, listChatsAdapter:ArrayList<Chat>):super(){
            this.listChatsAdapter = listChatsAdapter
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var myChat = listChatsAdapter[position]
            if (myChat.sender==true){
                var myView = layoutInflater.inflate(R.layout.sender_chat_ticket,null)
                myView.sender_message_text.text = myChat.message
                myView.sender_time_text.text = myChat.time
                return myView
            }else{
                var myView = layoutInflater.inflate(R.layout.reciever_chat_ticket,null)
                myView.receiver_message_text.text = myChat.message
                myView.receiver_time_text.text = myChat.time
                return myView
            }
        }

        override fun getItem(position: Int): Any {
            return listChatsAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listChatsAdapter.size
        }
    }
}
