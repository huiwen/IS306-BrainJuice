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


public class ChildNotification extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	ImageButton asking;
	//ImageButton notification;
	ImageButton qnbank;
	ImageButton setting;
	TableRow notiBody;
	TextView qnBody;
	TextView ansBody;
	TextView repliedBy;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_child);
       
        faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        asking = (ImageButton)this.findViewById(R.id.Asking);
        asking.setOnClickListener(this);
        
        
        //notification = (ImageButton)this.findViewById(R.id.notification);
        //notification.setOnClickListener(this);
        
        qnbank = (ImageButton)this.findViewById(R.id.QuestionBank);
        qnbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        notiBody = (TableRow)findViewById(R.id.tableRow1);
        notiBody.setClickable(true);
        notiBody.setOnClickListener(this);
        
        qnBody = (TextView) this.findViewById(R.id.textView1);
        qnBody.setText(Html.fromHtml("<strong>Your Question:</strong> How big is the earth?"));
        
        ansBody = (TextView) this.findViewById(R.id.textView2);
        ansBody.setText(Html.fromHtml("<strong>Answer:</strong> Radius of the earth is 6,371km. The suerface area is 510,072,000km2."));
        
        repliedBy = (TextView) this.findViewById(R.id.textView3);
        repliedBy.setText(Html.fromHtml("<strong>Replied By:</strong> MelissaTan!"));
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
         case R.id.Asking: 
        	 Intent intent = new Intent(context, HomePage.class);
             startActivity(intent);
             
             break;
             
         case R.id.tableRow1:
        	 Intent intentNotification = new Intent (context, ChildNotificationInstance.class);
        	 startActivity(intentNotification);
        	 
        	 break;
        	 
         case R.id.widget43:
        	 Intent intentSetting = new Intent (context, ChildSetting.class);
        	 startActivity(intentSetting);
      }
    	
    }
    
}
