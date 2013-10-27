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


public class ChildNotification extends Activity implements OnClickListener {

	TextView textView;
	TextView notificationCount; 
	ImageButton faq;
	ImageButton logout;
	ImageButton asking;
	ImageButton notification;
	ImageButton qnbank;
	ImageButton setting;
	TableRow notiBody;
	
	ImageView icon;
	TextView welcomeMsg;
	String loginUser;
	UserMgr userMgr;
	ChildNotificationMgr cnMgr;
	ArrayList<com.example.brainjuice.entity.ChildNotification> cn;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_child);
       
    	checkChildNotification();
    	
        faq = (ImageButton)this.findViewById(R.id.FAQ);
        faq.setOnClickListener(this);
        
        
        logout = (ImageButton)this.findViewById(R.id.Logout);
        logout.setOnClickListener(this);
        
        asking = (ImageButton)this.findViewById(R.id.Asking);
        asking.setOnClickListener(this);
        
        
        notification = (ImageButton)this.findViewById(R.id.notification);
        notification.setOnClickListener(this);
        
        qnbank = (ImageButton)this.findViewById(R.id.QuestionBank);
        qnbank.setOnClickListener(this);
        
        setting = (ImageButton)this.findViewById(R.id.widget43);
        setting.setOnClickListener(this);
        
        loginUser = BrainJuice.retrieveLoginUser();
        userMgr = BrainJuice.retrieveUserMgr();
        
        icon = (ImageView)this.findViewById(R.id.qnprofilepic);
        int j = getResources().getIdentifier(userMgr.retrieveUser(loginUser).getProfile(), "drawable", getPackageName());
        icon.setImageResource(j);
        
        welcomeMsg = (TextView)this.findViewById(R.id.widget50);
        welcomeMsg.setText(Html.fromHtml("Hi, " + loginUser));
        
        cnMgr = BrainJuice.retrieveCNMgr();
        cn = cnMgr.retrieveChildNotification(loginUser);
        
        TableLayout tl = (TableLayout) findViewById(R.id.tablelayout);
        
        if(cn.size() == 0){
        	TextView textView = new TextView(this);
        	textView.setText("Currently, you don't have any notification!");
        	tl.addView(textView);
        }
        
        for(int i = 0; i < cn.size(); i++){
	        TableRow newRow = new TableRow(this);
	        
	        LinearLayout myLayout = new LinearLayout(this);
	        
	        //myLayout.setOrientation(LinearLayout.VERTICAL);
	        
	        ImageView column1 = new ImageView(this);
	        com.example.brainjuice.entity.ChildNotification temp = cn.get(i);
	        
	        int resource = getResources().getIdentifier(userMgr.retrieveUser(temp.getUserReplied()).getProfile(), "drawable", getPackageName());
	        column1.setImageResource(resource);
	        //column1.setLayoutParams(new LayoutParams(60, 60));
	        myLayout.addView(column1, new LinearLayout.LayoutParams(60, 60));
	        newRow.addView(myLayout);
	        //tl.addView(newRow, new TableLayout.LayoutParams());
	        //column1.getLayoutParams().height = 60;
	        //column1.getLayoutParams().width = 60;
	        
	        String qn = temp.getQn();
	        if(qn.length() > 30){
	        	qn = qn.substring(0, 29) + "...";
	        }
	        
	        //LinearLayout myLayout = new LinearLayout(this);
	        
	        //myLayout.setOrientation(LinearLayout.VERTICAL);
	        
	        /*final TextView qn = new TextView(this);
			qn.setText(Html.fromHtml("<strong>Your Question:</strong> " + temp.getQn()));
			myLayout.addView(qn);
			
			final TextView ans = new TextView(this);
			ans.setText(Html.fromHtml("<strong>Answer:</strong> " + temp.getAnswer()));
			myLayout.addView(ans);
			
			
			final TextView repliedBy = new TextView(this);
			repliedBy.setText(Html.fromHtml("<strong>Replied By:</strong> " + temp.getUserReplied()));
			myLayout.addView(repliedBy);*/
	        
	        TextView text = new TextView(this);
	        //text.setSingleLine(false);
	        //text.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	        text.setText("Your question '" + qn + "' has been replied by " + temp.getUserReplied());
	        //text.setMaxLines(3);
	        //text.setSingleLine(false);
	        //text.getLayoutParams().width = LayoutParams.WRAP_CONTENT;
	        
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
		    		
		    tl.addView(newRow, tableRowParams);
		    
		    
		    newRow.setClickable(true);
	        newRow.setOnClickListener(this);
        }
    }


public void checkChildNotification(){
   	    int countNumberOfNotifications = 0;
   	    String numToString = "";
   	    String user = BrainJuice.retrieveLoginUser();
       	BrainJuice.retrieveCNMgr().retrieveChildNotification(user);
       	ArrayList<com.example.brainjuice.entity.ChildNotification> childNotificationList;
       	childNotificationList = BrainJuice.retrieveCNMgr().retrieveChildNotification(user);
       	for( com.example.brainjuice.entity.ChildNotification counter : childNotificationList){
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
                
    	if(v.getId() < cn.size()){  
   	     for(int i = 0; i < cn.size(); i++){
   	    	 if(v.getId() == i){
   	    		 Intent intentNoti = new Intent(context, ChildNotificationInstance.class);
   	    		 intentNoti.putExtra("qn", cn.get(i).getQn());
   	    		 intentNoti.putExtra("userReplied", cn.get(i).getUserReplied());
   	    		 intentNoti.putExtra("answer", cn.get(i).getAnswer());
   	    		 startActivity(intentNoti);
   	    		 break;
   	    	 }
   	     }
    	}
    	
    	 switch (v.getId()) {
         case R.id.Asking: 
        	 Intent intent = new Intent(context, HomePage.class);
             startActivity(intent);
             
             break;
             
         case R.id.QuestionBank:
      		 Intent intentQnBank = new Intent(context, ChildrenQuestionBank.class);
           	 startActivity(intentQnBank);
           	 break;
         	 
    	 case R.id.FAQ:
      		 Intent intentFAQ = new Intent(context, ChildFaq.class);
           	 startActivity(intentFAQ);
           	 break;
             
         case R.id.notification:
        	 Intent intentNotification = new Intent (context, ChildNotification.class);
        	 startActivity(intentNotification);
        	 
        	 break;
        	 
        	 
         case R.id.widget43:
        	 Intent intentSetting = new Intent (context, ChildSetting.class);
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
