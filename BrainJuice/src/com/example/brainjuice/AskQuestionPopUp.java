package com.example.brainjuice;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.*;


public class AskQuestionPopUp extends Activity implements OnClickListener {
	
	Button faq;
	Button logout;
	Button ask;
	ImageButton notification;
	ImageButton questionbank;
	ImageButton setting;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	
    	
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_question_page);
        
         faq = (Button)this.findViewById(R.id.FAQ);
         faq.setOnClickListener(this);
         
         
         logout = (Button)this.findViewById(R.id.Logout);
         logout.setOnClickListener(this);
         
         ask = (Button)this.findViewById(R.id.Ask);
         ask.setOnClickListener(this);
         
         notification = (ImageButton)this.findViewById(R.id.Asking);
         notification.setOnClickListener(this);
         
         questionbank = (ImageButton)this.findViewById(R.id.widget42);
         questionbank.setOnClickListener(this);
         
         setting = (ImageButton)this.findViewById(R.id.widget43);
         setting.setOnClickListener(this);
         		
        
        final Button btnOpenPopup = (Button)findViewById(R.id.Ask);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

   @Override
   public void onClick(View v){
  	 final Context context = AskQuestionPopUp.this;
	   
	   
    LayoutInflater layoutInflater 
     = (LayoutInflater)getBaseContext()
      .getSystemService(LAYOUT_INFLATER_SERVICE);  
    View popupView = layoutInflater.inflate(R.layout.activity_askquestionpopup, null);  
             final PopupWindow popupWindow = new PopupWindow(
               popupView, 
               LayoutParams.WRAP_CONTENT,  
                     LayoutParams.WRAP_CONTENT);  
             
            
        	 
        	 final int id = v.getId();
             switch (id) {
             case R.id.FAQ:  
            	 Intent intent = new Intent(context, ChildFaq.class);
                 startActivity(intent);    
                 break;
             case R.id.Logout:       
                // button2.setText("You clicked on Button 2");   
                 break;
             
             }
             final Button btnDismiss = (Button)popupView.findViewById(R.id.button2);
             btnDismiss.setOnClickListener(new Button.OnClickListener(){



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 // TODO Auto-generated method stub
	      Toast.makeText(AskQuestionPopUp.this, 
	        "Dismiss", Toast.LENGTH_LONG).show();
	      popupWindow.dismiss();
	     }});
	               
	             popupWindow.showAsDropDown(btnOpenPopup, 50, -30);
	             
	             //---
	             
	             popupWindow.setFocusable(true);
	             popupWindow.update();
	             
	             //---
	         
	   }});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	
}