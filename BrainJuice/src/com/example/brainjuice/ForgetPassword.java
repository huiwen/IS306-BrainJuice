package com.example.brainjuice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;

public class ForgetPassword extends Activity implements OnClickListener {

	Button confirm;
    Button cancel;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
  
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);
        
        confirm = (Button)this.findViewById(R.id.Confirm);
        confirm.setOnClickListener(this);
        
        cancel = (Button)this.findViewById(R.id.Cancel);
        cancel.setOnClickListener(this);
        
        
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		final Context context = this;
		
		switch (v.getId()) {
        	case R.id.Confirm:
        		LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            	View popupView = layoutInflater.inflate(R.layout.activity_forgetpassword_successful, null);
                final PopupWindow popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);  
                popupWindow.setOutsideTouchable(false);
                popupWindow.setFocusable(true);
                
                try {
                	int curBrightnessValue = android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
                    WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                    layoutParams.screenBrightness = curBrightnessValue/500.0f;
                    getWindow().setAttributes(layoutParams);
                } catch (SettingNotFoundException e) {
                    e.printStackTrace();
                }
                
                
                Button btnDismiss = (Button)popupView.findViewById(R.id.Close);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){
                	public void onClick(View v) {
          		      // TODO Auto-generated method stub
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
                popupWindow.showAsDropDown(confirm, 150, -230);
                
        		break;
        		
        	case R.id.Cancel:
        		Intent intent = new Intent(context, BrainJuice.class);
                startActivity(intent);
                break;
		}	
	}

}
