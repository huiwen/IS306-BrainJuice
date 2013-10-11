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


public class BrainJuice extends Activity implements OnClickListener {

	
	TextView username;
	TextView password;
	TextView createAccount;
	TextView forgetPassword;
	Button Login;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_juice);
        
        username = (TextView)this.findViewById(R.id.username);
        password = (TextView)this.findViewById(R.id.password);
        Login = (Button)this.findViewById(R.id.Login);
        
        Login = (Button)this.findViewById(R.id.Login);
        Login.setOnClickListener(this);
        
        createAccount = (TextView)this.findViewById(R.id.CreateAccount);
        createAccount.setText(Html.fromHtml("<font color='blue'>Create Account</font>"));
        createAccount.setClickable(true);
        createAccount.setOnClickListener(this);
        		
        forgetPassword = (TextView)this.findViewById(R.id.ForgetPassword);
        forgetPassword.setText(Html.fromHtml("<font color='blue'>Forget Password</font>"));
        forgetPassword.setClickable(true);
        forgetPassword.setOnClickListener(this);
        
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
	        	 if(username.getText().toString().equals("J")){
		        	 Intent intent = new Intent(context, HomePage.class);
		             startActivity(intent);
	        	 } else {
	        		 Intent intent = new Intent(context, AdultHomePage.class);
		             startActivity(intent);
	        	 }
	          // do something
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
    
}
