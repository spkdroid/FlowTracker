package ca.rovbot.flowtracker.fragment

import android.arch.lifecycle.ViewModelProviders
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ca.rovbot.flowtracker.R
import ca.rovbot.flowtracker.model.User
import ca.rovbot.flowtracker.viewmodel.ChatBotViewModel
import com.github.bassaer.chatmessageview.model.Message
import com.github.bassaer.chatmessageview.util.ChatBot
import com.github.bassaer.chatmessageview.view.ChatView
import kotlinx.android.synthetic.main.chat_bot_fragment.*
import java.util.*


class ChatBotFragment : Fragment(), View.OnClickListener {

    override fun onClick(p0: View?) {

        val myId = 0
        val myIcon = BitmapFactory.decodeResource(resources, R.drawable.ldroid)
        val myName = "Michael"

        val yourId = 1
        val yourIcon = BitmapFactory.decodeResource(resources, R.drawable.ldroid)
        val yourName = "Emily"

        val me = User(myId, myName, myIcon)
        val you = User(yourId, yourName, yourIcon)

        val message: Message = Message.Builder().setUser(me).setText(chatView.inputText).hideIcon(true).build()

        chatView.send(message)
        //Reset edit text
        chatView.inputText = "";
        //Receive message
        val receivedMessage = Message.Builder()
            .setUser(you)
            .setRight(false)
            .setText(ChatBot.talk(me.getName(), message.toString()))
            .build()

       // val sendDelay = (Random().nextInt(4) + 1) * 1000;
         chatView.receive(receivedMessage)
   //        Handler().postDelayed({
     //       @Override
       //     fun run() {
         //       chatView.receive(receivedMessage);
         //   }
       // }, sendDelay.toLong());


    }

    companion object {
        fun newInstance() = ChatBotFragment()
    }

    private lateinit var viewModel: ChatBotViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_bot_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChatBotViewModel::class.java)
        // TODO: Use the ViewModel




        chatView.setRightBubbleColor(ContextCompat.getColor(this.context!!, R.color.green500));
        chatView.setLeftBubbleColor(Color.WHITE);
        chatView.setBackgroundColor(ContextCompat.getColor(this.context!!, R.color.blueGray500));
        chatView.setSendButtonColor(ContextCompat.getColor(this.context!!, R.color.cyan900));
        chatView.setSendIcon(R.drawable.ic_action_send);
        chatView.setOnClickSendButtonListener(this)
        chatView.setRightMessageTextColor(Color.WHITE);
        chatView.setLeftMessageTextColor(Color.BLACK);
        chatView.setUsernameTextColor(Color.WHITE);
        chatView.setSendTimeTextColor(Color.WHITE);
        chatView.setDateSeparatorColor(Color.WHITE);
        chatView.setInputTextHint("new message...");
        chatView.setMessageMarginTop(5);
        chatView.setMessageMarginBottom(5);


    }
}

