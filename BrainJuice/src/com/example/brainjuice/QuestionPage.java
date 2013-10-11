package com.example.brainjuice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class QuestionPage extends Activity implements OnClickListener {

	
	Button faq;
	Button logout;
	Button ask;
	Button notification;
	Button questionbank;
	Button setting;
	
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
        
        notification = (Button)this.findViewById(R.id.widget41);
        notification.setOnClickListener(this);
        
        questionbank = (Button)this.findViewById(R.id.widget42);
        questionbank.setOnClickListener(this);
        
        setting = (Button)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        
        
       
        
        		
        
        
    }


 
    
    public void onClick(View v){
   	 final Context context = this;
    	 
    	 final int id = v.getId();
         switch (id) {
         case R.id.FAQ:  
        	 Intent intent = new Intent(context, ChildFaq.class);
             startActivity(intent);    
             break;
         case R.id.widget42:       
        	 Intent intentChild = new Intent(context, ChildrenQuestionBank.class);
             startActivity(intentChild);    
             break;   
            
         case R.id.Ask:     
             //button3.setText("You clicked on Button 3");
             break;
         case R.id.widget41:         
             //button4.setText("You clicked on Button 4");
             break;
        
         case R.id.widget43:
             //button5.setText("You clicked on Button 5");
             break;
             
         }
    	
    
    	
    }
    
}
