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


public class AdultEditProfile extends Activity implements OnClickListener {

	TextView textView;
	TextView notificationCount; 
	ImageButton faq;
	ImageButton logout;
	ImageButton confirm;
	ImageButton cancel;
	ImageButton upload;
	ImageButton answering;
	ImageButton notification;
	ImageButton answerbank;
	ImageButton setting;
	
	String loginUser;
	UserMgr userMgr;
	ImageView icon;
	TextView welcomeMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile_adult);
       

    	checkNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        answering = (ImageButton)this.findViewById(R.id.Answering);
        answering.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.Setting);
        setting.setOnClickListener(this);
        
        answerbank = (ImageButton)this.findViewById(R.id.AnswerBank);
        answerbank.setOnClickListener(this);
        
        confirm = (ImageButton)this.findViewById(R.id.Confirm);
        confirm.setOnClickListener(this);
        
        cancel = (ImageButton)this.findViewById(R.id.Cancel);
        cancel.setOnClickListener(this);
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
        
    }

    public void checkNotification(){
	    int countNumberOfNotifications = 0;
	    String numToString = "";
	    String user = BrainJuice.retrieveLoginUser();
    	BrainJuice.retrieveANMgr().retrieveAdultNotification(user);
    	ArrayList<com.example.brainjuice.entity.AdultNotification> adultNotificationList;
    	adultNotificationList = BrainJuice.retrieveANMgr().retrieveAdultNotification(user);
    	for( com.example.brainjuice.entity.AdultNotification counter : adultNotificationList){
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
	    	 case R.id.Answering:
	    		 Intent intentAsking = new Intent(context, AdultHomePage.class);
	    		 startActivity(intentAsking);
	    		 break;
	    		 
	    	 case R.id.Setting:
	    		 Intent intentSetting = new Intent(context, AdultSetting.class);
	    		 startActivity(intentSetting);
	    		 break;
	    	 
	    	 case R.id.notification:
	    		 Intent intent = new Intent(context, AdultNotification.class);
	         	 startActivity(intent);
	         	 break;
	         	 
	    	 case R.id.AnswerBank:
	      		 Intent intentQnBank = new Intent(context, AnswerBankAccepted.class);
	           	 startActivity(intentQnBank);
	           	 break;
	         	 
	    	 case R.id.FAQ:
	      		 Intent intentFAQ = new Intent(context, AdultFaq.class);
	           	 startActivity(intentFAQ);
	           	 break;
	    	 
	    	 case R.id.Confirm:
	    		 LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
	         	 View popupView = layoutInflater.inflate(R.layout.activity_editprofile_confirmation, null);
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
	             		popupWindow.dismiss();
	            		
	            		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
	                    View popupView = layoutInflater.inflate(R.layout.activity_editprofile_successful, null);  
	            		final PopupWindow popupWindowS = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
	                    popupWindowS.setOutsideTouchable(false);
	                    popupWindowS.setFocusable(true);
	                    
	                    
	                    Button btnClose = (Button)popupView.findViewById(R.id.Close);
	                    btnClose.setOnClickListener(new Button.OnClickListener(){
	                    	public void onClick(View v) {
	                    		//popupWindowS.dismiss();
	                    		Intent intent = new Intent(context, AdultSetting.class);
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
	                    popupWindowS.showAsDropDown(confirm, 150, -300);
	             	}});
	             popupWindow.showAsDropDown(confirm, 150, -300);
	        	 
	        	 break;
	         	 
	    	 case R.id.Cancel:
	    		 Intent intentChangePwd = new Intent(context, AdultSetting.class);
	         	 startActivity(intentChangePwd);
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
