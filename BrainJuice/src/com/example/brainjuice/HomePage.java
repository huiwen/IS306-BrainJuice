package com.example.brainjuice;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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


public class HomePage extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	Button ask;
	ImageButton notification;
	ImageButton questionbank;
	ImageButton setting;
	Button btnOpenPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
       
        faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
       
        
        
        ask = (Button)this.findViewById(R.id.Ask);
        ask.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        questionbank = (ImageButton)this.findViewById(R.id.widget42);
        questionbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        	
        //btnOpenPopup = (Button)findViewById(R.id.Ask);
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
                
    	
    	 switch (v.getId()) {
    	 case R.id.notification:
    		 Intent intent = new Intent(context, ChildNotification.class);
         	 startActivity(intent);
         	 break;
         	 
    	 case R.id.widget43:
    		 Intent intentSetting = new Intent(context, ChildSetting.class);
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
    	 
    	 case R.id.Ask: 
        	 
        	 //btnOpenPopup.setOnClickListener(new Button.OnClickListener(){
        		 
        		  // @Override
        		   //public void onClick(View arg0) {
        			  
        			/*   WindowManager.LayoutParams windowManager = getWindow().getAttributes();
  		             windowManager.dimAmount = 5.75f;
  		             getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
  		             */
        			   
  		             
        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
        View popupView = layoutInflater.inflate(R.layout.activity_askquestionpopup, null);  
        final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        
        try {
        	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.screenBrightness = curBrightnessValue/500.0f;
            getWindow().setAttributes(layoutParams);
        } catch (SettingNotFoundException e) {
             		            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        		             /*
        		            
        		             Window window = popupView.getWindow();
        		             WindowManager.LayoutParams wlp = window.getAttributes();
        		             wlp.gravity = Gravity.CENTER_VERTICAL;
        		             wlp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        		             wlp.dimAmount = (float) 1.0;
        		             window.setAttributes(wlp);
        		             */
        Button btnDismiss = (Button)popupView.findViewById(R.id.button2);
        btnDismiss.setOnClickListener(new Button.OnClickListener(){
        		            	 	
        		     @Override
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
        Button btnProceed = (Button)popupView.findViewById(R.id.button1);
        btnProceed.setOnClickListener(new Button.OnClickListener(){	  		
        	
        	
        	
        	public void onClick(View arg0){
        		popupWindow.dismiss();
        		
        		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
                View popupView = layoutInflater.inflate(R.layout.activity_askquestionpopupinstance, null);  
        		final PopupWindow popupWindowS = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
                popupWindowS.setOutsideTouchable(false);
                popupWindowS.setFocusable(true);
                
                
                Button btnClose = (Button)popupView.findViewById(R.id.Close);
                btnClose.setOnClickListener(new Button.OnClickListener(){
                	public void onClick(View v) {
                		//popupWindowS.dismiss();
                		Intent intent = new Intent(context, HomePage.class);
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
                
                popupWindowS.showAsDropDown(ask, 150, 50);
        	}});
        
        		            // popupWindow.showAsDropDown(btnOpenPopup, 150, 50);
       popupWindow.showAsDropDown(ask, 150, 50);
        		         
        		 
       break;
        // case R.id.buttonB:
          // do something else
          //break;
      }
  
        /*
    	if(username.equals("JonathanTan") && password.equals("123456789")){
    		
			Intent intent = new Intent(context, QuestionPage.class);
            startActivity(intent);   
    		
    	}else if(username.equals("MelissaTan") && password.equals("123456789")){
    	
    		
    	}else{
    		   
    		//Toast.makeText(this, "Username/Password is wrong!", 0 ).show();
    	}
    	
    */	
    	
    }
    
}
