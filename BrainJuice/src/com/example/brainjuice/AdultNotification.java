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
	//TableRow notiBody;
	TextView qnBody;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn_request_homepage);
       
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
        
        //LayoutInflater layoutInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
    	//View layout = layoutInflater.inflate(R.layout.activity_notification_adult, null);
        //TableLayout table = (TableLayout)findViewById(R.id.table);
        //table.setVisibility(View.VISIBLE);
        /*notiBody = (TableRow)findViewById(R.id.tableRow1);
        notiBody.setClickable(true);
        notiBody.setOnClickListener(this);*/
        
        //qnBody = (TextView)this.findViewById(R.id.textView1);
        //qnBody.setText(Html.fromHtml("<b>Question:</b> How big is the earth?"));
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
         case R.id.Answering: 
        	 Intent intent = new Intent(context, AnswerQuestion.class);
             startActivity(intent);
             
             break;
             
         /*case R.id.tableRow1:
        	 Intent intentNotification = new Intent (context, AdultHomePage.class);
        	 startActivity(intentNotification);
        	 
        	 break;*/
      }
    	
    }
    
}
