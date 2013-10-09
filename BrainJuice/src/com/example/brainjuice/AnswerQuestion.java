package com.example.brainjuice;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
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
        	
        case R.id.Answer:
        	
        	
        	 
        break;
      }
    	
    }
    
}

