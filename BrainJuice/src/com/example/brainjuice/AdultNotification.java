package com.example.brainjuice;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class AdultNotification extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	ImageButton answering;
	//ImageButton notification;
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
        
        
        //notification = (ImageButton)this.findViewById(R.id.notification);
        //notification.setOnClickListener(this);
        
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
        	 Intent intent = new Intent(context, AdultHomePage.class);
             startActivity(intent);
             
             break;
             
         case R.id.tableRow1:
        	 Intent intentNotificationInstance = new Intent (context, AdultNotificationInstance.class);
        	 startActivity(intentNotificationInstance);
        	 
        	 break;
        	 
         
         case R.id.AnswerBank:
        	 Intent intentAnswerBankAccepted = new Intent (context, AnswerBankAccepted.class);
        	 startActivity(intentAnswerBankAccepted);
        	 
        	 break;
        	 
         case R.id.widget43:
        	 Intent intentSetting = new Intent (context, AdultSetting.class);
        	 startActivity(intentSetting);
        	 
        	 break;
        	 
         case R.id.FAQ:
        	 Intent intentFaq = new Intent (context, AdultFaq.class);
        	 startActivity(intentFaq);
        	 
        	 break;
        	 
         case R.id.Logout:
    		 LayoutInflater layoutInflaterLogout = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
         	 View popupViewLogout = layoutInflaterLogout.inflate(R.layout.activity_logout, null);
             final PopupWindow popupWindowLogout = new PopupWindow(popupViewLogout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
             popupWindowLogout.setOutsideTouchable(false);
             popupWindowLogout.setFocusable(true);
             
             try {
             	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                 layoutParams.screenBrightness = curBrightnessValue/500.0f;
                 getWindow().setAttributes(layoutParams);
             } catch (SettingNotFoundException e) {
                 e.printStackTrace();
             }
             
             
             Button btnDismissLogout = (Button)popupViewLogout.findViewById(R.id.Cancel);
             btnDismissLogout.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
       		    	 popupWindowLogout.dismiss();
       		      
       		    	 try {
       		    		 int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
       		    		 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
       		    		 layoutParams.screenBrightness = curBrightnessValue;
       		    		 getWindow().setAttributes(layoutParams);
       		    	 } catch (SettingNotFoundException e) {
      		            // TODO Auto-generated catch block
       		    		 e.printStackTrace();
       		    	 }
       		     }});
             
             Button btnProceedLogout = (Button)popupViewLogout.findViewById(R.id.Proceed);
             btnProceedLogout.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
             		Intent intent = new Intent(context, BrainJuice.class);
                    startActivity(intent);
       		      
       		    	 try {
       		    		 int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
       		    		 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
       		    		 layoutParams.screenBrightness = curBrightnessValue;
       		    		 getWindow().setAttributes(layoutParams);
       		    	 } catch (SettingNotFoundException e) {
      		            // TODO Auto-generated catch block
       		    		 e.printStackTrace();
       		    	 }
       		     }});
             popupWindowLogout.showAsDropDown(logout, 150, 50);

        	 
        	 break;
      }
    	
    }
    
}
