package com.example.brainjuice;

import java.util.ArrayList;

import com.example.brainjuice.entity.*;

import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.*;
import android.app.AlertDialog;
import android.content.DialogInterface;


public class AdultNotification extends Activity implements OnClickListener {

	TextView textView;
	TextView notificationCount;
	ImageButton faq;
	ImageButton logout;
	ImageButton answering;
	ImageButton notification;
	ImageButton answerbank;
	ImageButton setting;
	TableRow notiBody;
	//TextView qnBody;
	//TextView ansBody;
	//TextView msg;
	
	ImageView icon;
	TextView welcomeMsg;
	String loginUser;
	UserMgr userMgr;
	
	AdultNotificationMgr anMgr;
	ArrayList<com.example.brainjuice.entity.AdultNotification> an;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_adult);
       

    	checkNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        answering = (ImageButton)this.findViewById(R.id.Answering);
        answering.setOnClickListener(this);
        
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        answerbank = (ImageButton)this.findViewById(R.id.AnswerBank);
        answerbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        //notiBody = (TableRow)findViewById(R.id.tableRow1);
        //notiBody.setClickable(true);
        //notiBody.setOnClickListener(this);
        
        //qnBody = (TextView) this.findViewById(R.id.textView1);
        //qnBody.setText(Html.fromHtml("<strong>Question:</strong> How big is the earth?"));
        
        //ansBody = (TextView) this.findViewById(R.id.textView2);
        //ansBody.setText(Html.fromHtml("<strong>You Answer:</strong> Radius of the earth is 6,371km. The suerface area is 510,072,000km2."));
        
        //msg = (TextView) this.findViewById(R.id.textView3);
        //msg.setText(Html.fromHtml("<strong>Message:</strong> JonathanTan likes your answer!"));
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
        
        anMgr = BrainJuice.retrieveANMgr();
        an = anMgr.retrieveAdultNotification(loginUser);
        
        TableLayout tl = (TableLayout) findViewById(R.id.tablelayout);
        
        if(an.size() == 0){
        	TextView textView = new TextView(this);
        	textView.setText("Currently, you don't have any notification!");
        	tl.addView(textView);
        }
        
        for(int i = 0; i < an.size(); i++){
	        TableRow newRow = new TableRow(this);
	        
	        ImageView column1 = new ImageView(this);
	        com.example.brainjuice.entity.AdultNotification temp = an.get(i);
	        
	        int resource = getResources().getIdentifier(userMgr.retrieveUser(temp.getUserAsked()).getProfile(), "drawable", getPackageName());
	        column1.setImageResource(resource);
	        newRow.addView(column1);
	       // tl.addView(newRow, new TableLayout.LayoutParams());
	        column1.getLayoutParams().height = 60;
	        column1.getLayoutParams().width = 60;
	        
	        //LinearLayout myLayout = new LinearLayout(this);
	        //myLayout.setOrientation(LinearLayout.VERTICAL);
	        
			/*final TextView qn = new TextView(this);
			qn.setText(Html.fromHtml("<strong>Question:</strong> " + temp.getQn()));
			qn.setLayoutParams(new LayoutParams(280, 30));
			myLayout.addView(qn);
			
			final TextView ans = new TextView(this);
			ans.setText(Html.fromHtml("<strong>Your Answer:</strong> " + temp.getAnswer()));
			//ans.getLayoutParams().height = 30;
			//ans.getLayoutParams().width = 280;
			ans.setLayoutParams(new LayoutParams(280, 30));
			myLayout.addView(ans);
			
			
			final TextView msg = new TextView(this);
			msg.setText(Html.fromHtml("<strong>Message:</strong> " + temp.getUserAsked() + " likes your answer!"));
			msg.setLayoutParams(new LayoutParams(280, LayoutParams.WRAP_CONTENT));
			myLayout.addView(msg);*/
	        
	        String reply = temp.getAnswer();
	        if(reply.length() > 30){
	        	reply = reply.substring(0, 29) + "...";
	        }
	        
	        TextView text = new TextView(this);
	        text.setText(temp.getUserAsked() + " has liked your reply '" + reply + "'!");
	        newRow.addView(text);
		    newRow.setId(i);
		    newRow.setLayoutParams(new LayoutParams(75, 75));
		    newRow.setBackgroundResource(R.drawable.back);
		    TableLayout.LayoutParams tableRowParams=
		    		  new TableLayout.LayoutParams
		    		  (TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT);

		    		int leftMargin=2;
		    		int topMargin=2;
		    		int rightMargin=2;
		    		int bottomMargin=2;

		    		tableRowParams.setMargins(leftMargin, topMargin, rightMargin, bottomMargin);

		    		newRow.setLayoutParams(tableRowParams);
		    		
		    tl.addView(newRow);
		    
		    newRow.setClickable(true);
	        newRow.setOnClickListener(this);
        }
        
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
    
    @SuppressWarnings("deprecation")
	public void onClick(View v){
    	final Context context = this;
                
    	if(v.getId() < an.size()){  
      	     for(int i = 0; i < an.size(); i++){
      	    	 if(v.getId() == i){
      	    		 Intent intentNoti = new Intent(context, AdultNotificationInstance.class);
      	    		 intentNoti.putExtra("qn", an.get(i).getQn());
      	    		 intentNoti.putExtra("userAsked", an.get(i).getUserAsked());
      	    		 intentNoti.putExtra("answer", an.get(i).getAnswer());
      	    		 startActivity(intentNoti);
      	    		 break;
      	    	 }
      	     }
       	}      
    	
    	 switch (v.getId()) {
         case R.id.Answering: 
        	 Intent intent = new Intent(context, AdultHomePage.class);
             startActivity(intent);
             
             break;
             
         case R.id.notification: 
        	 Intent intentNoti = new Intent(context, AdultNotification.class);
             startActivity(intentNoti);
             
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
