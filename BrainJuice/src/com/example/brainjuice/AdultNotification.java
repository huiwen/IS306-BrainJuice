package com.example.brainjuice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class AdultNotification extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	ImageButton answering;
	ImageButton notification;
	ImageButton answerbank;
	ImageButton setting;
	TableRow notiBody;
	TextView qnBody;
	TextView ansBody;
	TextView msg;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_adult);
       
        faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        answering = (ImageButton)this.findViewById(R.id.Answering);
        answering.setOnClickListener(this);
        
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        answerbank = (ImageButton)this.findViewById(R.id.AnswerBank);
        answerbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        notiBody = (TableRow)findViewById(R.id.tableRow1);
        notiBody.setClickable(true);
        notiBody.setOnClickListener(this);
        
        qnBody = (TextView) this.findViewById(R.id.textView1);
        qnBody.setText(Html.fromHtml("<strong>Question:</strong> How big is the earth?"));
        
        ansBody = (TextView) this.findViewById(R.id.textView2);
        ansBody.setText(Html.fromHtml("<strong>You Answer:</strong> Radius of the earth is 6,371km. The suerface area is 510,072,000km2."));
        
        msg = (TextView) this.findViewById(R.id.textView3);
        msg.setText(Html.fromHtml("<strong>Message:</strong> JonathanTan likes your answer!"));
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
         case R.id.Answering: 
        	 Intent intent = new Intent(context, AnswerQuestion.class);
             startActivity(intent);
             
             break;
             
         case R.id.tableRow1:
        	 Intent intentNotification = new Intent (context, AdultNotificationInstance.class);
        	 startActivity(intentNotification);
        	 
        	 break;
        	 
         case R.id.AnswerBank:
        	 Intent intentAnswerBankAccepted = new Intent (context, AnswerBankAccepted.class);
        	 startActivity(intentAnswerBankAccepted);
        	 
        	 break;        	 
      }
    	
    }
    
}
