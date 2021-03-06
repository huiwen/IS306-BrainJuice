package com.example.brainjuice;

import java.util.ArrayList;

import com.example.brainjuice.entity.*;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class ChildFaq extends Activity implements OnClickListener {

	TextView textView;
	TextView notificationCount; 
	ImageButton faq;
	ImageButton logout;
	TextView q1;
	TextView q2;
	TextView q3;
	TextView q4;
	TextView q5;
	ImageButton asking;
	ImageButton notification;
	ImageButton questionbank;
	ImageButton setting;
	
	String loginUser;
	ImageView icon;
	TextView welcomeMsg;
	UserMgr userMgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_child);
       
    	checkChildNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        asking = (ImageButton)this.findViewById(R.id.Asking);
        asking.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        questionbank = (ImageButton)this.findViewById(R.id.QuestionBank);
        questionbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.Setting);
        setting.setOnClickListener(this);
        
        q1 = (TextView)this.findViewById(R.id.Q1);
        q1.setText(Html.fromHtml("<font color='blue'><u>How do I ask a question?</u></font><br />"));
        q1.setClickable(true);
        q1.setOnClickListener(this);
        
        q2 = (TextView)this.findViewById(R.id.Q2);
        q2.setText(Html.fromHtml("<font color='blue'><u>How do I know if my question has been answered?</u></font><br />"));
        q2.setClickable(true);
        q2.setOnClickListener(this);
        
        
        q3 = (TextView)this.findViewById(R.id.Q3);
        q3.setText(Html.fromHtml("<font color='blue'><u>Where are my answered questions located?</u></font><br />"));
        q3.setClickable(true);
        q3.setOnClickListener(this);
        
               
        q4 = (TextView)this.findViewById(R.id.Q4);
        q4.setText(Html.fromHtml("<font color='blue'><u>Where can I edit my profile?</u></font><br />"));
        q4.setClickable(true);
        q4.setOnClickListener(this);
        
        q5 = (TextView)this.findViewById(R.id.Q5);
        q5.setText(Html.fromHtml("<font color='blue'><u>Where can I change my password?</u></font><br />"));
        q5.setClickable(true);
        q5.setOnClickListener(this);
        
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
	    		 Intent intentAsking = new Intent(context, HomePage.class);
	    		 startActivity(intentAsking);
	    		 break;
	    	 
	    	 case R.id.notification:
	    		 Intent intent = new Intent(context, ChildNotification.class);
	         	 startActivity(intent);
	         	 break;
	         
	    	 case R.id.QuestionBank:
	    		 Intent intentQnBank = new Intent(context, ChildrenQuestionBank.class);
	    		 startActivity(intentQnBank);
	    		 break;
	    	 
	    	 case R.id.Setting:
	    		 Intent intentSetting = new Intent(context, ChildSetting.class);
	         	 startActivity(intentSetting);
	    		 break;
	    		 
	    	 case R.id.Q1:
	    		 setContentView(R.layout.activity_faqinstance_child);
	    		 
	    		 	loginUser = BrainJuice.retrieveLoginUser();
	    	        userMgr = BrainJuice.retrieveUserMgr();
	    	        
	    	        
	    	        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
	    	        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
	    	        icon.setImageResource(j);
	    	        checkChildNotification();
	    	        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
	    	        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
	    		 
	    		 TextView title = (TextView)this.findViewById(R.id.FAQTitle);
	    		 title.setText(Html.fromHtml("How do I ask a question?<br />"));
	    		 
	    		 TextView body = (TextView)this.findViewById(R.id.FAQBody);
	    		 body.setText(Html.fromHtml("<b>Step 1</b> When you have a question, simply tap on the �Ask Question� navigation tab.<br /><br />" 
	    				 + "<b>Step 2</b> At the �Ask Question� page, you can key your question into the textbox area.<br /><br />"
	    				 + "<b>Step 3</b> Tap the �Ask� button, and your question will be answered shortly by an adult.<br /><br />"));
	    		 
	    		
	    		 
	    		 ImageButton faq = (ImageButton)this.findViewById(R.id.FAQ);
	    		 faq.setOnClickListener(new Button.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildFaq.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton asking = (ImageButton)this.findViewById(R.id.Asking);
	    		 asking.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, HomePage.class);
		              		startActivity(intent);
		              	}});
	    		 ImageButton notification = (ImageButton)this.findViewById(R.id.notification);
	    		 notification.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildNotification.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton qnBank = (ImageButton)this.findViewById(R.id.QuestionBank);
	    		 qnBank.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildrenQuestionBank.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton setting = (ImageButton)this.findViewById(R.id.Setting);
	    		 setting.setOnClickListener(new ImageButton.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		Intent intent = new Intent(context, ChildSetting.class);
		              		startActivity(intent);
	    			 	}
	    		 });
	    		 
	    		 final ImageButton logoutQ1 = (ImageButton)this.findViewById(R.id.Logout);
	    		 logoutQ1.setOnClickListener(new Button.OnClickListener(){
	    			 	public void onClick(View v){
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
	    		             popupWindowLogout.showAsDropDown(logoutQ1, 150, 50);
	    			 		
	    			 	}});
	    		 
	    		 break;
	    	 
	    	 
	    	 
	    	 
	    	 case R.id.Q2:
	    		 setContentView(R.layout.activity_faqinstance_child);
	    		 
	    		 	loginUser = BrainJuice.retrieveLoginUser();
	    	        userMgr = BrainJuice.retrieveUserMgr();
	    	        
	    	        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
	    	        int jQ2 = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
	    	        icon.setImageResource(jQ2);
	    	        
	    	        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
	    	        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
	    		 
	    		 TextView titleQ2 = (TextView)this.findViewById(R.id.FAQTitle);
	    		 titleQ2.setText(Html.fromHtml("How do I know if my question has been answered?<br />"));
	    		 checkChildNotification();
	    		 TextView bodyQ2 = (TextView)this.findViewById(R.id.FAQBody);
	    		 bodyQ2.setText(Html.fromHtml("<b>Step 1</b> When you have a notification, one of your questions has been answered by an adult.<br /><br />"
	    				 + "<b>Step 2</b> To check your notification, tap on the �Notifications� navigation tab.<br /><br />"
	    				 + "<b>Step 3</b> All notifications will be populated. Select the notification you would like to view.<br /><br />"
	    				 + "<b>Step 4</b> You will see your question, and an answer provided by an adult.<br /><br />"
	    				 + "<b>Step 5</b> You can choose to accept or reject the answer by liking or not liking it. If you choose to reject the answer, your question will be sent for a new answer again. If you choose to accept the answer, your question and the answer will be stored in your �Question Bank�. Once accepted or rejected, the notification will be removed.<br /><br />"));
	    		 
	    		
	    		 
	    		 ImageButton faqQ2 = (ImageButton)this.findViewById(R.id.FAQ);
	    		 faqQ2.setOnClickListener(new Button.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildFaq.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton askingQ2 = (ImageButton)this.findViewById(R.id.Asking);
	    		 askingQ2.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, HomePage.class);
		              		startActivity(intent);
		              	}});
	    		 ImageButton notificationQ2 = (ImageButton)this.findViewById(R.id.notification);
	    		 notificationQ2.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildNotification.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton qnBankQ2 = (ImageButton)this.findViewById(R.id.QuestionBank);
	    		 qnBankQ2.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildrenQuestionBank.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton settingQ2 = (ImageButton)this.findViewById(R.id.Setting);
	    		 settingQ2.setOnClickListener(new ImageButton.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		Intent intent = new Intent(context, ChildSetting.class);
		              		startActivity(intent);
	    			 	}
	    		 });
	    		 
	    		 final ImageButton logoutQ2 = (ImageButton)this.findViewById(R.id.Logout);
	    		 logoutQ2.setOnClickListener(new Button.OnClickListener(){
	    			 	public void onClick(View v){
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
	    		             popupWindowLogout.showAsDropDown(logoutQ2, 150, 50);
	    			 		
	    			 	}});
	    		 
	    		 break;
	    		 
	    		 
	    		 
	    		 
	    		 
	    	 case R.id.Q3:
	    		 setContentView(R.layout.activity_faqinstance_child);
	    		 
	    		 	loginUser = BrainJuice.retrieveLoginUser();
	    	        userMgr = BrainJuice.retrieveUserMgr();
	    	        
	    	        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
	    	        int jQ3 = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
	    	        icon.setImageResource(jQ3);
	    	        
	    	        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
	    	        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
	    	        checkChildNotification();
	    		 TextView titleQ3 = (TextView)this.findViewById(R.id.FAQTitle);
	    		 titleQ3.setText(Html.fromHtml("Where are my answered questions located?<br />"));
	    		 
	    		 TextView bodyQ3 = (TextView)this.findViewById(R.id.FAQBody);
	    		 bodyQ3.setText(Html.fromHtml("<b>Step 1</b> Tap on the �Question Bank� navigation tab.<br /><br />"
	    				 + "<b>Step 2</b> Select the �Answered� tab to look at your questions that were answered. Select the �Pending Answer� tab to look at questions that are yet to be answered. There is a �search� textbox where you can search for a question with keywords entered.<br /><br />"));
	    		 
	    		
	    		 
	    		 ImageButton faqQ3 = (ImageButton)this.findViewById(R.id.FAQ);
	    		 faqQ3.setOnClickListener(new Button.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildFaq.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton askingQ3 = (ImageButton)this.findViewById(R.id.Asking);
	    		 askingQ3.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, HomePage.class);
		              		startActivity(intent);
		              	}});
	    		 ImageButton notificationQ3 = (ImageButton)this.findViewById(R.id.notification);
	    		 notificationQ3.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildNotification.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton qnBankQ3 = (ImageButton)this.findViewById(R.id.QuestionBank);
	    		 qnBankQ3.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildrenQuestionBank.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton settingQ3 = (ImageButton)this.findViewById(R.id.Setting);
	    		 settingQ3.setOnClickListener(new ImageButton.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		Intent intent = new Intent(context, ChildSetting.class);
		              		startActivity(intent);
	    			 	}
	    		 });
	    		 
	    		 final ImageButton logoutQ3 = (ImageButton)this.findViewById(R.id.Logout);
	    		 logoutQ3.setOnClickListener(new Button.OnClickListener(){
	    			 	public void onClick(View v){
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
	    		             popupWindowLogout.showAsDropDown(logoutQ3, 150, 50);
	    			 		
	    			 	}});
	    		 
	    		 break;
	    		 
	    		 
	    		 
	    		 
	    	 case R.id.Q4:
	    		 setContentView(R.layout.activity_faqinstance_child);
	    		 
	    		 	loginUser = BrainJuice.retrieveLoginUser();
	    	        userMgr = BrainJuice.retrieveUserMgr();
	    	        
	    	        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
	    	        int jQ4 = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
	    	        icon.setImageResource(jQ4);
	    	        
	    	        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
	    	        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
	    	        checkChildNotification();
	    		 TextView titleQ4 = (TextView)this.findViewById(R.id.FAQTitle);
	    		 titleQ4.setText(Html.fromHtml("Where can I edit my profile?<br />"));
	    		 
	    		 TextView bodyQ4 = (TextView)this.findViewById(R.id.FAQBody);
	    		 bodyQ4.setText(Html.fromHtml("<b>Step 1</b> Tap on the �Settings� navigation tab.<br /><br />"
	    				 + "<b>Step 2</b> Tap on the �Edit Profile� hyperlink.<br /><br />"
	    				 + "<b>Step 3</b> You can change your profile picture by tapping on the icon. You can select a new profile picture from your mobile device.<br /><br />"
	    				 + "<b>Step 4</b> Tap the �Confirm� button."));
	    		 
	    		
	    		 ImageButton faqQ4 = (ImageButton)this.findViewById(R.id.FAQ);
	    		 faqQ4.setOnClickListener(new Button.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildFaq.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton askingQ4 = (ImageButton)this.findViewById(R.id.Asking);
	    		 askingQ4.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, HomePage.class);
		              		startActivity(intent);
		              	}});
	    		 ImageButton notificationQ4 = (ImageButton)this.findViewById(R.id.notification);
	    		 notificationQ4.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildNotification.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton qnBankQ4 = (ImageButton)this.findViewById(R.id.QuestionBank);
	    		 qnBankQ4.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildrenQuestionBank.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton settingQ4 = (ImageButton)this.findViewById(R.id.Setting);
	    		 settingQ4.setOnClickListener(new ImageButton.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		Intent intent = new Intent(context, ChildSetting.class);
		              		startActivity(intent);
	    			 	}
	    		 });
	    		 
	    		 final ImageButton logoutQ4 = (ImageButton)this.findViewById(R.id.Logout);
	    		 logoutQ4.setOnClickListener(new Button.OnClickListener(){
	    			 	public void onClick(View v){
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
	    		             popupWindowLogout.showAsDropDown(logoutQ4, 150, 50);
	    			 		
	    			 	}});
	    		 
	    		 break;
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    	 case R.id.Q5:
	    		 setContentView(R.layout.activity_faqinstance_child);
	    		 
	    		    loginUser = BrainJuice.retrieveLoginUser();
	    	        userMgr = BrainJuice.retrieveUserMgr();
	    	        
	    	        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
	    	        int jQ5 = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
	    	        icon.setImageResource(jQ5);
	    	        
	    	        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
	    	        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
	    	        checkChildNotification();
	    		 TextView titleQ5 = (TextView)this.findViewById(R.id.FAQTitle);
	    		 titleQ5.setText(Html.fromHtml("Where can I change my password?<br />"));
	    		 
	    		 TextView bodyQ5 = (TextView)this.findViewById(R.id.FAQBody);
	    		 bodyQ5.setText(Html.fromHtml("<b>Step 1</b> Tap on the �Settings� navigation tab.<br /><br />"
	    				 + "<b>Step 2</b> Tap on the �Change Password� hyperlink.<br /><br />"
	    				 + "<b>Step 3</b> You can change your password by entering the current password, new password and confirm password.<br /><br />"
	    				 + "<b>Step 4</b> Tap the �Confirm� button.<br /><br />"));
	    		 
	    		
	    		 
	    		 ImageButton faqQ5 = (ImageButton)this.findViewById(R.id.FAQ);
	    		 faqQ5.setOnClickListener(new Button.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildFaq.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton askingQ5 = (ImageButton)this.findViewById(R.id.Asking);
	    		 askingQ5.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, HomePage.class);
		              		startActivity(intent);
		              	}});
	    		 ImageButton notificationQ5 = (ImageButton)this.findViewById(R.id.notification);
	    		 notificationQ5.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildNotification.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton qnBankQ5 = (ImageButton)this.findViewById(R.id.QuestionBank);
	    		 qnBankQ5.setOnClickListener(new ImageButton.OnClickListener(){
		              	public void onClick(View v) {
		              		Intent intent = new Intent(context, ChildrenQuestionBank.class);
		              		startActivity(intent);
		              	}});
	    		 
	    		 ImageButton settingQ5 = (ImageButton)this.findViewById(R.id.Setting);
	    		 settingQ5.setOnClickListener(new ImageButton.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		Intent intent = new Intent(context, ChildSetting.class);
		              		startActivity(intent);
	    			 	}
	    		 });
	    		 
	    		 final ImageButton logoutQ5 = (ImageButton)this.findViewById(R.id.Logout);
	    		 logoutQ5.setOnClickListener(new Button.OnClickListener(){
	    			 	public void onClick(View v){
	    			 		LayoutInflater layoutInflaterLogout = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
	    		         	 View popupViewLogout = layoutInflaterLogout.inflate(R.layout.activity_logout, null);
	    		             final PopupWindow popupWindowLogout = new PopupWindow(popupViewLogout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
	    		             popupWindowLogout.setOutsideTouchable(false);
	    		             popupWindowLogout.setFocusable(true);
	    		             
	    		             try {
	    		             	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
	    		                 WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
	    		                 layoutParams.screenBrightness = curBrightnessValue;
	    		                 getWindow().setAttributes(layoutParams);
	    		             } catch (SettingNotFoundException e) {
	    		                 e.printStackTrace();
	    		             }
	    		             
	    		             
	    		             ImageButton btnDismissLogout = (ImageButton)popupViewLogout.findViewById(R.id.Cancel);
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
	    		             
	    		             ImageButton btnProceedLogout = (ImageButton)popupViewLogout.findViewById(R.id.Proceed);
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
	    		             popupWindowLogout.showAsDropDown(logoutQ5, 150, 50);
	    			 		
	    			 	}});
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
	                 layoutParams.screenBrightness = curBrightnessValue;
	                 getWindow().setAttributes(layoutParams);
	             } catch (SettingNotFoundException e) {
	                 e.printStackTrace();
	             }
	             
	             
	             ImageButton btnDismissLogout = (ImageButton)popupViewLogout.findViewById(R.id.Cancel);
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
	             
	             ImageButton btnProceedLogout = (ImageButton)popupViewLogout.findViewById(R.id.Proceed);
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
	        	 
	    	 
    	 }
    	
    }
    
}
