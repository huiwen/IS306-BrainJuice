package com.example.brainjuice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import com.example.brainjuice.entity.*;


public class BrainJuice extends Activity implements OnClickListener {

	public static UserMgr userMgr = new UserMgr();
	public static PendingAnswerMgr paMgr = new PendingAnswerMgr();
	public static PendingAcceptanceMgr pAcMgr = new PendingAcceptanceMgr();
	public static AnsweredQnMgr aqMgr = new AnsweredQnMgr();
	public static AdultNotificationMgr anMgr = new AdultNotificationMgr();
	public static ChildNotificationMgr cnMgr = new ChildNotificationMgr();
	public static String loginUser = null;
	
	TextView username;
	TextView password;
	TextView createAccount;
	TextView forgetPassword;
	TextView errorMsg;
	ImageButton Login;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_juice);
        
        username = (TextView)this.findViewById(R.id.username);
        password = (TextView)this.findViewById(R.id.password);
        Login = (ImageButton)this.findViewById(R.id.Login);
        
        Login = (ImageButton)this.findViewById(R.id.Login);
        Login.setOnClickListener(this);
        
        createAccount = (TextView)this.findViewById(R.id.CreateAccount);
        createAccount.setText(Html.fromHtml("<font color='blue'>Create Account</font>"));
        createAccount.setClickable(true);
        createAccount.setOnClickListener(this);
        		
        forgetPassword = (TextView)this.findViewById(R.id.ForgetPassword);
        forgetPassword.setText(Html.fromHtml("<font color='blue'>Forget Password</font>"));
        forgetPassword.setClickable(true);
        forgetPassword.setOnClickListener(this);
        
        if(getIntent().getStringExtra("errorMsg") != null){
        	errorMsg = (TextView)this.findViewById(R.id.ErrorMsg);
        	errorMsg.setText(Html.fromHtml("<font color='red' size='1'>" + getIntent().getStringExtra("errorMsg") + "</font>"));
        	username.setText(getIntent().getStringExtra("username"));
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.brain_juice, menu);
        return true;
    }
    
    
    
    public void onClick(View v){
    	final Context context = this;
    	
    	 switch (v.getId()) {
	         case R.id.Login: 
	        	 String inputUsername = username.getText().toString();
	        	 String inputPassword = password.getText().toString();
	        	 
	        	 String userType = userMgr.login(inputUsername, inputPassword);
	        	 
	        	 if(userType == null){
	        		 Intent intent = new Intent(context, BrainJuice.class);
	        		 intent.putExtra("errorMsg", "Your username and password could not match!");
	        		 intent.putExtra("username", inputUsername);
	        		 startActivity(intent);
	        	 }else{
	        		 loginUser = inputUsername;
	        		 
	        		 if(userType.equals("child")){
	        	 
			        	 Intent intent = new Intent(context, HomePage.class);
			             startActivity(intent);
		        	 } else if(userType.equals("adult")){
		        		 Intent intent = new Intent(context, AdultHomePage.class);
			             startActivity(intent);
		        	 }
	        	 }
	          break;
	         
	         case R.id.CreateAccount:
	        	 Intent intent = new Intent(context, CreateAccount.class);
	             startActivity(intent);
	         break;
	         
	         case R.id.ForgetPassword:
	        	 Intent intentForgetPassword = new Intent(context, ForgetPassword.class);
	             startActivity(intentForgetPassword);
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
    
    public static String retrieveLoginUser(){
    	return loginUser;
    }
    
    public static UserMgr retrieveUserMgr(){
    	return userMgr;
    }
    
    public static PendingAnswerMgr retrievePAMgr(){
    	return paMgr;
    }
    
    public static PendingAcceptanceMgr retrievePAcMgr(){
    	return pAcMgr;
    }
    
    public static AnsweredQnMgr retrieveAQMgr(){
    	return aqMgr;
    }
    
    public static ChildNotificationMgr retrieveCNMgr(){
    	return cnMgr;
    }
    
    public static AdultNotificationMgr retrieveANMgr(){
    	return anMgr;
    }
    
    public static void removeLoginUser(){
    	loginUser = null;
    }
}
