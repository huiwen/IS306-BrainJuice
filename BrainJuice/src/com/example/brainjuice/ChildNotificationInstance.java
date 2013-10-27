package com.example.brainjuice;

import java.util.ArrayList;

import com.example.brainjuice.entity.*;

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

	TextView textView;
	TextView notificationCount; 
	ImageButton faq;
	ImageButton logout;
	ImageButton asking;
	ImageButton notification;
	ImageButton qnbank;
	ImageButton setting;
	ImageButton tick;
	ImageButton cross;
	TextView ansBody;
	TextView qnBody;
	
	ImageView icon;
	TextView welcomeMsg;
	String loginUser;
	UserMgr userMgr;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationinstance_child);
       

    	checkChildNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        asking = (ImageButton)this.findViewById(R.id.Asking);
        asking.setOnClickListener(this);
        
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        qnbank = (ImageButton)this.findViewById(R.id.QuestionBank);
        qnbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        tick = (ImageButton)findViewById(R.id.tick);
        tick.setOnClickListener(this);
        
        cross = (ImageButton)findViewById(R.id.cross);
        cross.setOnClickListener(this);
        
        ansBody = (TextView) this.findViewById(R.id.AnswerBody);
        ansBody.setText(Html.fromHtml("Replied by " + getIntent().getStringExtra("userReplied") + "<br /><br />" + getIntent().getStringExtra("answer")));
        
        qnBody = (TextView)this.findViewById(R.id.QuestionBody);
        qnBody.setText(getIntent().getStringExtra("qn"));
        
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
    }

    public void checkChildNotification(){
   	    int countNumberOfNotifications = 0;
   	    String numToString = "";
   	    String user = BrainJuice.retrieveLoginUser();
       	BrainJuice.retrieveCNMgr().retrieveChildNotification(user);
       	ArrayList<com.example.brainjuice.entity.ChildNotification> childNotificationList;
       	childNotificationList = BrainJuice.retrieveCNMgr().retrieveChildNotification(user);
       	for( com.example.brainjuice.entity.ChildNotification counter : childNotificationList){
       		countNumberOfNotifications++;
       		
       	}
       	numToString = Integer.toString(countNumberOfNotifications);
       	
       	if(countNumberOfNotifications <= 0){
       		textView = (TextView)findViewById(R.id.count);
               textView.setBackgroundResource(R.drawable.blank);
       		notificationCount = (TextView) this.findViewById(R.id.count);
       		notificationCount.setText("");
       	}else{
       		textView = (TextView)findViewById(R.id.count);
       		textView.setBackgroundResource(R.drawable.notificationred);
       		notificationCount = (TextView) this.findViewById(R.id.count);
       		notificationCount.setText(numToString);
       	}
       	
       
         }
    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
         case R.id.Asking: 
        	 Intent intent = new Intent(context, HomePage.class);
             startActivity(intent);
             
             break;
             
         case R.id.notification: 
        	 Intent intentnoti = new Intent(context, ChildNotification.class);
             startActivity(intentnoti);
             
             break;
             
         case R.id.QuestionBank:
      		 Intent intentQnBank = new Intent(context, ChildrenQuestionBank.class);
           	 startActivity(intentQnBank);
           	 break;
         	 
    	 case R.id.FAQ:
      		 Intent intentFAQ = new Intent(context, ChildFaq.class);
           	 startActivity(intentFAQ);
           	 break;
             
         case R.id.widget43:
        	 Intent intentSetting = new Intent (context, ChildSetting.class);
        	 startActivity(intentSetting);
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
             		BrainJuice.removeLoginUser();
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
                    
                    PendingAcceptanceMgr pacMgr = BrainJuice.retrievePAcMgr();
                    pacMgr.delete(loginUser, getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"));
                    
                    AnsweredQnMgr aqMgr = BrainJuice.retrieveAQMgr();
                    aqMgr.add(loginUser, getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"), true);
                    
                    ChildNotificationMgr cnMgr = BrainJuice.retrieveCNMgr();
                    cnMgr.delete(loginUser,getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"));
       		      
                    AdultNotificationMgr adMgr = BrainJuice.retrieveANMgr();
                    adMgr.add(loginUser, getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"));
                    
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
                    
                    PendingAcceptanceMgr pacMgr = BrainJuice.retrievePAcMgr();
                    pacMgr.delete(loginUser, getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"));
                    
                    AnsweredQnMgr aqMgr = BrainJuice.retrieveAQMgr();
                    aqMgr.add(loginUser, getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"), false);
                    
                    PendingAnswerMgr paMgr = BrainJuice.retrievePAMgr();
                    paMgr.addNew(loginUser, getIntent().getStringExtra("qn"));
                    
                    ChildNotificationMgr cnMgr = BrainJuice.retrieveCNMgr();
                    cnMgr.delete(loginUser,getIntent().getStringExtra("qn"), getIntent().getStringExtra("userReplied"), getIntent().getStringExtra("answer"));

       		      
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
