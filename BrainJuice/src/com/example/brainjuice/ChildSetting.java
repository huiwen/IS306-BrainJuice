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


public class ChildSetting extends Activity implements OnClickListener {

	TextView textView;
	TextView notificationCount;
	ImageButton faq;
	ImageButton logout;
	TextView editProfile;
	TextView changePwd;
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
        setContentView(R.layout.activity_setting_child);
       
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
        
        editProfile = (TextView)this.findViewById(R.id.EditProfile);
        editProfile.setText(Html.fromHtml("<font color='blue'><u>Edit Profile</u></font>"));
        editProfile.setClickable(true);
        //editProfile.setMovementMethod(LinkMovementMethod.getInstance());
        editProfile.setOnClickListener(this);
        
        changePwd = (TextView)this.findViewById(R.id.ChangePwd);
        changePwd.setText(Html.fromHtml("<font color='blue'><u>Change Password</u></font>"));
        changePwd.setClickable(true);
        changePwd.setMovementMethod(LinkMovementMethod.getInstance());
        changePwd.setOnClickListener(this);
        
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
	    	 
	    	 case R.id.Setting:
	    		 Intent intentSetting = new Intent(context, ChildSetting.class);
	    		 startActivity(intentSetting);
	    		 break;
	    		 
	    	 case R.id.notification:
	    		 Intent intent = new Intent(context, ChildNotification.class);
	         	 startActivity(intent);
	         	 break;
	         	 
	    	 case R.id.QuestionBank:
	      		 Intent intentQnBank = new Intent(context, ChildrenQuestionBank.class);
	           	 startActivity(intentQnBank);
	           	 break;
	         	 
	    	 case R.id.FAQ:
	      		 Intent intentFAQ = new Intent(context, ChildFaq.class);
	           	 startActivity(intentFAQ);
	           	 break;
	    	 
	    	 case R.id.EditProfile:
	    		 Intent intentEditProfile = new Intent(context, ChildEditProfile.class);
	         	 startActivity(intentEditProfile);
	         	 break;
	         	 
	    	 case R.id.ChangePwd:
	    		 Intent intentChangePwd = new Intent(context, ChildChangePassword.class);
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
        
    	 }
    	
    }
    
}
