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


public class ChildSetting extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	TextView editProfile;
	TextView changePwd;
	ImageButton asking;
	ImageButton notification;
	ImageButton questionbank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_child);
       
        faq = (Button)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (Button)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        asking = (ImageButton)this.findViewById(R.id.Asking);
        asking.setOnClickListener(this);
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        questionbank = (ImageButton)this.findViewById(R.id.QuestionBank);
        questionbank.setOnClickListener(this);
        
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
	    	 
	    	 case R.id.EditProfile:
	    		 Intent intentEditProfile = new Intent(context, HomePage.class);
	         	 startActivity(intentEditProfile);
	         	 break;
	         	 
	    	 case R.id.ChangePwd:
	    		 Intent intentChangePwd = new Intent(context, ChildChangePassword.class);
	         	 startActivity(intentChangePwd);
	         	 break;
        	 
        
    	 }
    	
    }
    
}
