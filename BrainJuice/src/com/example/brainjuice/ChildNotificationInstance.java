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


public class ChildNotificationInstance extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	ImageButton asking;
	//ImageButton notification;
	ImageButton qnbank;
	ImageButton setting;
	ImageButton tick;
	ImageButton cross;
	TextView ansBody;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationinstance_child);
       
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
        
        tick = (ImageButton)findViewById(R.id.tick);
        tick.setOnClickListener(this);
        
        cross = (ImageButton)findViewById(R.id.cross);
        cross.setOnClickListener(this);
        
        ansBody = (TextView) this.findViewById(R.id.AnswerBody);
        ansBody.setText(Html.fromHtml("Replied by MelissaTan<br /><br />Radius of the earth is 6,371km. The surface are is 510,072,000km2."));
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
         case R.id.Asking: 
        	 Intent intent = new Intent(context, AnswerQuestion.class);
             startActivity(intent);
             
             break;
             
         case R.id.widget43:
        	 Intent intentSetting = new Intent (context, ChildSetting.class);
        	 startActivity(intentSetting);
        	 break;
             
         case R.id.tick:
        	 LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
         	 View popupView = layoutInflater.inflate(R.layout.activity_noti_likeanswer_child, null);
             final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
             popupWindow.setOutsideTouchable(false);
             popupWindow.setFocusable(true);
             
             try {
             	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                 layoutParams.screenBrightness = curBrightnessValue/500.0f;
                 getWindow().setAttributes(layoutParams);
             } catch (SettingNotFoundException e) {
                 e.printStackTrace();
             }
             
             
             Button btnDismiss = (Button)popupView.findViewById(R.id.Cancel);
             btnDismiss.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
       		    	 popupWindow.dismiss();
       		      
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
             
             Button btnProceed = (Button)popupView.findViewById(R.id.Proceed);
             btnProceed.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
             		Intent intent = new Intent(context, ChildNotification.class);
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
             popupWindow.showAsDropDown(tick, 150, -350);
        	 
        	 break;
        	 
         case R.id.cross:
        	 LayoutInflater layoutInflaterCross = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
         	 View popupViewCross = layoutInflaterCross.inflate(R.layout.activity_noti_dislikeanswer_child, null);
             final PopupWindow popupWindowCross = new PopupWindow(popupViewCross, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
             popupWindowCross.setOutsideTouchable(false);
             popupWindowCross.setFocusable(true);
             
             try {
             	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                 layoutParams.screenBrightness = curBrightnessValue/500.0f;
                 getWindow().setAttributes(layoutParams);
             } catch (SettingNotFoundException e) {
                 e.printStackTrace();
             }
             
             
             Button btnDismissCross = (Button)popupViewCross.findViewById(R.id.Cancel);
             btnDismissCross.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
       		    	 popupWindowCross.dismiss();
       		      
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
             
             Button btnProceedCross = (Button)popupViewCross.findViewById(R.id.Proceed);
             btnProceedCross.setOnClickListener(new Button.OnClickListener(){
             	public void onClick(View v) {
       		      // TODO Auto-generated method stub
             		Intent intent = new Intent(context, ChildNotification.class);
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
             popupWindowCross.showAsDropDown(tick, 150, -350);
        	 
        	 break;
      }
    	
    }
    
}
