package com.example.brainjuice;

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

	
	Button faq;
	Button logout;
	Button confirm;
	Button cancel;
	ImageButton upload;
	ImageButton answering;
	ImageButton notification;
	ImageButton answerbank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile_adult);
       
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
        
        confirm = (Button)this.findViewById(R.id.Confirm);
        confirm.setOnClickListener(this);
        
        cancel = (Button)this.findViewById(R.id.Cancel);
        cancel.setOnClickListener(this);
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
	    	 case R.id.Answering:
	    		 Intent intentAsking = new Intent(context, AdultHomePage.class);
	    		 startActivity(intentAsking);
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