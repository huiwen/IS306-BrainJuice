package com.example.brainjuice;

import com.example.brainjuice.entity.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
 
public class ChildrenQuestionBank extends Activity implements OnClickListener {
	
	Button faq;
	Button logout;
	ImageButton ask;
	ImageButton notification;
	ImageButton setting;
	
	String loginUser;
	UserMgr userMgr;
	ImageView icon;
	TextView welcomeMsg;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_childrenquestionbank);
		
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		
		tabHost.setup();
		TextView txtTab = new TextView(this);
		txtTab.setTextSize(14);
		
		
		TabSpec spec1=tabHost.newTabSpec("Answered");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("Answered");
		
		
		

		TabSpec spec2=tabHost.newTabSpec("Pending Answer");
		spec2.setIndicator("Pending Answer");
		spec2.setContent(R.id.tab2);

		

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		
		faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        ask = (ImageButton)this.findViewById(R.id.Asking);
        ask.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        //questionbank = (ImageButton)this.findViewById(R.id.widget42);
        //questionbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.Setting);
        setting.setOnClickListener(this);
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
		
		}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		final Context context = this;
        
        
    	
   	 switch (v.getId()) {
   	 
   	case R.id.Asking:  
      	 Intent intentAsking = new Intent(context, HomePage.class);
           startActivity(intentAsking);    
           break;
   	 
   	 case R.id.FAQ:  
       	 Intent intentFaq = new Intent(context, ChildFaq.class);
            startActivity(intentFaq);    
            break;
            
   	 case R.id.notification:
   		 Intent intent = new Intent(context, ChildNotification.class);
        	 startActivity(intent);
        	 break;
        	 
   	 case R.id.Setting:
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