package com.example.brainjuice;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
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
import android.graphics.Color;

import com.example.brainjuice.entity.*;


public class HomePage extends Activity implements OnClickListener{
    
	//AbsoluteLayout layout_MainMenu;
	RelativeLayout back_dim_layout;
	TextView textView;
	TextView notificationCount; 
	ImageButton faq;
	ImageButton logout;
	ImageButton ask;
	ImageButton notification;
	ImageButton questionbank;
	ImageButton setting;
	EditText askQn;
	
	ImageView icon;
	TextView welcomeMsg;
	
	String loginUser;
	UserMgr userMgr;
	
	//Button btnOpenPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);
        //layout_MainMenu = (AbsoluteLayout) findViewById(R.id.widget0);
        
        //layout_MainMenu.getBackground().setAlpha( 0);

    	checkChildNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
       
        
        
        ask = (ImageButton)this.findViewById(R.id.Ask);
        ask.setEnabled(false);
        ask.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        questionbank = (ImageButton)this.findViewById(R.id.widget42);
        questionbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        icon.setBackgroundColor(0xFFFFFFFF);

        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
        
        askQn = (EditText)this.findViewById(R.id.editText1);
        askQn.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				ask.setEnabled(askQn.getText().length() != 0);
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        
        
        
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
    	 
    	 case R.id.FAQ:  
        	 Intent intentFaq = new Intent(context, ChildFaq.class);
             startActivity(intentFaq);    
             break;
             
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
                 layoutParams.screenBrightness = curBrightnessValue;///500.0f;
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
    	 
    	 case R.id.Asking:
    		 Intent intentAsking = new Intent(context, HomePage.class);
         	 startActivity(intentAsking);
    		 break;
        
    	 case R.id.Ask: 
        	 
    		
        	 //btnOpenPopup.setOnClickListener(new Button.OnClickListener(){
        		 
        		  // @Override
        		   //public void onClick(View arg0) {
        			  
        			/*   WindowManager.LayoutParams windowManager = getWindow().getAttributes();
  		             windowManager.dimAmount = 5.75f;
  		             getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
  		  
  		             */
    		    
    		    
    		 //layout_MainMenu = (AbsoluteLayout) findViewById(R.id.widget0);
    		 
    		 //back_dim_layout = (RelativeLayout) findViewById(R.id.bac_dim_layout);
    		 
    		// back_dim_layout.setVisibility(View.VISIBLE);
    		
        LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
        View popupView = layoutInflater.inflate(R.layout.activity_askquestionpopup, null);  
        final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(true);
        
       // layout_MainMenu.getBackground().setAlpha( 220);
       // icon.getBackground().setAlpha( 220);
        //back_dim_layout.setVisibility(View.VISIBLE);
		//back_dim_layout.setVisibility(View.GONE);
       
        try {
        	
        	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
            WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
            layoutParams.screenBrightness = curBrightnessValue;//500.0f;
            getWindow().setAttributes(layoutParams);
            
        } catch (SettingNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       	             
        		            
       	    
       // back_dim_layout.setVisibility(View.GONE);		
        ImageButton btnDismiss = (ImageButton)popupView.findViewById(R.id.button2);
       
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
	        ImageButton btnProceed = (ImageButton)popupView.findViewById(R.id.button1);
	        btnProceed.setOnClickListener(new Button.OnClickListener(){	  		
        	
        	
        	
        	public void onClick(View arg0){
        		popupWindow.dismiss();
        		
        		/*LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
                View popupView = layoutInflater.inflate(R.layout.activity_askquestionpopupinstance, null);  
        		final PopupWindow popupWindowS = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
                popupWindowS.setOutsideTouchable(false);
                popupWindowS.setFocusable(true);*/
                
                //ask qn logic
                BrainJuice.retrievePAMgr().addNew(loginUser, askQn.getText().toString());
                
                /*Button btnClose = (Button)popupView.findViewById(R.id.Close);
                btnClose.setOnClickListener(new Button.OnClickListener(){
                	public void onClick(View v) {
                		//popupWindowS.dismiss();*/
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
          		     //}});
                
                //popupWindowS.showAsDropDown(ask, 150, 50);
        	}});
        
        		            // popupWindow.showAsDropDown(btnOpenPopup, 150, 50);
       //popupWindow.showAsDropDown(ask, 150, 50);
	        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
        		         
        		 
       break;
        // case R.id.buttonB:
          // do something else
          //break;
       
         case R.id.widget42:       
        	 Intent intentChild = new Intent(context, ChildrenQuestionBank.class);
             startActivity(intentChild);    
             break;   
             
             
             
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
