package com.example.brainjuice;

import java.util.ArrayList;

import com.example.brainjuice.entity.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.text.Html;
import android.util.Log;
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
 
public class AnswerBankAccepted extends Activity implements OnClickListener {
	
	TextView textView;
	TextView notificationCount; 
	ImageButton logout;
	ImageButton faq;
	ImageButton answering;
	ImageButton notification;
	ImageButton setting;
	ImageButton answerBank;
	
	ImageView icon;
	TextView welcomeMsg;
	UserMgr userMgr;
	String loginUser;
	
	AnsweredQnMgr aqMgr;
	PendingAcceptanceMgr pacMgr;
	ArrayList<AnsweredQn> accept;
	ArrayList<AnsweredQn> reject;
	ArrayList<PendingAcceptance> pac;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answerbank_adult);
		
		checkNotification();
		
		loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
		
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		
		tabHost.setup();
		TextView txtTab = new TextView(this);
		txtTab.setTextSize(14);
		
		
		aqMgr = BrainJuice.retrieveAQMgr();
		accept = aqMgr.retrieveAcceptedAnswerBank(loginUser);
		
		LinearLayout myLayout = (LinearLayout) findViewById(R.id.ly1);
		TextView[] myTextViews;
		
		if(accept.size() != 0){
			myTextViews = new TextView[accept.size()]; // create an empty array;
	
			for (int i = 0; i < accept.size(); i++) {
			    // create a new textview
			    final TextView rowTextView = new TextView(this);
	
			    // set some properties of rowTextView or something
			    rowTextView.setText(Html.fromHtml("<font color='blue'><u>" + accept.get(i).getQn() + "</u></font>"));
	
			    // add the textview to the linearlayout
			    myLayout.addView(rowTextView);
	
			    // save a reference to the textview for later
			    myTextViews[i] = rowTextView;
			    
			    myTextViews[i].setClickable(true);
		        myTextViews[i].setOnClickListener(this);
		        myTextViews[i].setId(i);
					
			}
		} else {
			myTextViews = new TextView[1];
			final TextView rowTextView = new TextView(this);
			rowTextView.setText("You don't have any answer that is accepted!");
			myLayout.addView(rowTextView);
			myTextViews[0] = rowTextView;
		}
		
		TabSpec spec1=tabHost.newTabSpec("Accepted");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("Accepted");
		tabHost.addTab(spec1);
		
		reject = aqMgr.retrieveRejectAnswerBank(loginUser);
		
		LinearLayout myLayout2 = (LinearLayout) findViewById(R.id.ly2);
		TextView[] myTextViews2; 
		
		if(reject.size() != 0){
		
			myTextViews2 = new TextView[reject.size()]; // create an empty array;
	
			for (int i = 0; i < reject.size(); i++) {
			    // create a new textview
			    final TextView rowTextView = new TextView(this);
	
			    // set some properties of rowTextView or something
			    rowTextView.setText(Html.fromHtml("<font color='blue'><u>" + reject.get(i).getQn() + "</u></font>"));
	
			    // add the textview to the linearlayout
			    myLayout2.addView(rowTextView);
	
			    // save a reference to the textview for later
			    myTextViews2[i] = rowTextView;
			    
			    myTextViews2[i].setClickable(true);
		        myTextViews2[i].setOnClickListener(this);
		        myTextViews2[i].setId(accept.size() + i);
					
			}
		} else {
			myTextViews2 = new TextView[1];
			final TextView rowTextView = new TextView(this);
			rowTextView.setText("You don't have any answer that is rejected!");
			myLayout2.addView(rowTextView);
			myTextViews2[0] = rowTextView;
		}
		
		TabSpec spec2=tabHost.newTabSpec("Rejected");
		spec2.setIndicator("Rejected");
		spec2.setContent(R.id.tab2);
		
		tabHost.addTab(spec2);
		
		
		pacMgr = BrainJuice.retrievePAcMgr();
		pac = pacMgr.retrievePAcListAdult(loginUser);
		
		LinearLayout myLayout3 = (LinearLayout) findViewById(R.id.ly3);
		TextView[] myTextViews3;
		
		if(pac.size() != 0){
		
			myTextViews3 = new TextView[pac.size()]; // create an empty array;
	
			for (int i = 0; i < pac.size(); i++) {
			    // create a new textview
			    final TextView rowTextView = new TextView(this);
	
			    // set some properties of rowTextView or something
			    rowTextView.setText(Html.fromHtml("<font color='blue'><u>" + pac.get(i).getQn() + "</u></font>"));
	
			    // add the textview to the linearlayout
			    myLayout3.addView(rowTextView);
	
			    // save a reference to the textview for later
			    myTextViews3[i] = rowTextView;
			    
			    myTextViews3[i].setClickable(true);
		        myTextViews3[i].setOnClickListener(this);
		        myTextViews3[i].setId(accept.size() + reject.size() + i);
					
			}
		} else {
			myTextViews3 = new TextView[1];
			final TextView rowTextView = new TextView(this);
			rowTextView.setText("You don't have any answer that is pending acceptance!");
			myLayout3.addView(rowTextView);
			myTextViews3[0] = rowTextView;
		}
		
		TabSpec spec3=tabHost.newTabSpec("Pending Acceptance");
		spec3.setIndicator("Pending Acceptance");
		spec3.setContent(R.id.tab3);

		tabHost.addTab(spec3);
		
		logout = (ImageButton)this.findViewById(R.id.Logout);
		logout.setOnClickListener(this);
		
		faq = (ImageButton)this.findViewById(R.id.FAQ);
		faq.setOnClickListener(this);
		
		answerBank = (ImageButton)this.findViewById(R.id.AnswerBank);
		answerBank.setOnClickListener(this);
		
		answering = (ImageButton)this.findViewById(R.id.Answering);
		answering.setOnClickListener(this);
		
		notification = (ImageButton)this.findViewById(R.id.notification);
		notification.setOnClickListener(this);
		
		setting = (ImageButton)this.findViewById(R.id.widget43);
		setting.setOnClickListener(this);
		
		}


	 public void checkNotification(){
		    int countNumberOfNotifications = 0;
		    String numToString = "";
		    String user = BrainJuice.retrieveLoginUser();
	    	BrainJuice.retrieveANMgr().retrieveAdultNotification(user);
	    	ArrayList<com.example.brainjuice.entity.AdultNotification> adultNotificationList;
	    	adultNotificationList = BrainJuice.retrieveANMgr().retrieveAdultNotification(user);
	    	for( com.example.brainjuice.entity.AdultNotification counter : adultNotificationList){
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
	 
	 
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		final Context context = this;
		
		if(v.getId() < accept.size()){  
		     for(int i = 0; i < accept.size(); i++){
		    	 if(v.getId() == i){
		    		 Intent intentBank = new Intent(context, AdultAnswerBankInstance.class);
		    		 intentBank.putExtra("qn", accept.get(i).getQn());
		    		 intentBank.putExtra("userAsked", accept.get(i).getUserAsked());
		    		 intentBank.putExtra("answer", accept.get(i).getAnswer());
		    		 startActivity(intentBank);
		    		 break; 
		    	 }
		     }
	     } else if(v.getId() < accept.size() + reject.size()){
	    	 int acceptSize = accept.size();
	    	 for(int i = 0; i < reject.size(); i++){
		    	 if(v.getId() == i + acceptSize){
		    		 Intent intentBank = new Intent(context, AdultAnswerBankInstance.class);
		    		 intentBank.putExtra("qn", reject.get(i).getQn());
		    		 intentBank.putExtra("userAsked", reject.get(i).getUserAsked());
		    		 intentBank.putExtra("answer", reject.get(i).getAnswer());
		    		 startActivity(intentBank);
		    		 break;
		    	 }
	    	 }
	     } else {
	    	 int acceptSize = accept.size();
	    	 int rejectSize = reject.size();
	    	 for(int i = 0; i < pac.size(); i++){
		    	 if(v.getId() == i + acceptSize + rejectSize){
		    		 Intent intentBank = new Intent(context, AdultAnswerBankInstance.class);
		    		 intentBank.putExtra("qn", pac.get(i).getQn());
		    		 intentBank.putExtra("userAsked", pac.get(i).getUserAsked());
		    		 intentBank.putExtra("answer", pac.get(i).getAnswer());
		    		 startActivity(intentBank);
		    		 break;
		    	 }
	    	 }
	     }
        
        
    	
   	 switch (v.getId()) {
        case R.id.Answering: 
       	 Intent intent = new Intent(context, AdultHomePage.class);
            startActivity(intent);
            
            break;
            
        case R.id.AnswerBank: 
          	 Intent intentans = new Intent(context, AnswerBankAccepted.class);
               startActivity(intentans);
               
               break;
            
       	 
        case R.id.notification:
       	 Intent intentAnswerBankAccepted = new Intent (context, AdultNotification.class);
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