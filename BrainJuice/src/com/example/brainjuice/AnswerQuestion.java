package com.example.brainjuice;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class AnswerQuestion extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	Button anotherQuestion;
	Button answer;
	ImageButton notification;
	ImageButton answerbank;
	ImageButton setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qn_request);
       
        faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        anotherQuestion = (Button)this.findViewById(R.id.AnotherQuestion);
        anotherQuestion.setOnClickListener(this);
        
        answer = (Button)this.findViewById(R.id.Answer);
        answer.setOnClickListener(this);
        
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        answerbank = (ImageButton)this.findViewById(R.id.AnswerBank);
        answerbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
    }

    
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
    	   	
    	switch (v.getId()) {
        case R.id.AnotherQuestion: 
        	Intent intent = new Intent(context, AnswerQuestion.class);
        	startActivity(intent);
        	break;
        	
        case R.id.Answer:
        	LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        	View popupView = layoutInflater.inflate(R.layout.activity_answerquestionconfirmation, null);
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
            	public void onClick(View arg0){
            		popupWindow.dismiss();
            		
            		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);  
                    View popupView = layoutInflater.inflate(R.layout.activity_answerquestionsuccessful, null);  
            		final PopupWindow popupWindowS = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
                    popupWindowS.setOutsideTouchable(false);
                    popupWindowS.setFocusable(true);
                    
                    
                    Button btnClose = (Button)popupView.findViewById(R.id.Close);
                    btnClose.setOnClickListener(new Button.OnClickListener(){
                    	public void onClick(View v) {
                    		//popupWindowS.dismiss();
                    		Intent intent = new Intent(context, AnswerQuestion.class);
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
                    
                    popupWindowS.showAsDropDown(answer, 150, 50);
            	}});
            
            popupWindow.showAsDropDown(answer, 150, 50);
            
        	 
            break;
            
        case R.id.notification:
       	 Intent intentBack = new Intent (context, AdultNotification.class);
       	 startActivity(intentBack);
       	 
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

