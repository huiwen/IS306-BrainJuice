package com.example.brainjuice;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
 
public class ChildrenQuestionBank extends Activity {
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_childrenquestionbank);
		
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		
		tabHost.setup();
		TextView txtTab = new TextView(this);
		txtTab.setTextSize(14);
		
		
		TabSpec spec1=tabHost.newTabSpec("Answered");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("Answered");
		
		
		

		TabSpec spec2=tabHost.newTabSpec("Pending Answer");
		spec2.setIndicator("Pending Answer");
		spec2.setContent(R.id.tab2);

		

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		
		}
		
}