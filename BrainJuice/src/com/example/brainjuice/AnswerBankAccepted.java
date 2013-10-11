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
 
public class AnswerBankAccepted extends Activity {
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answerbank_adult);
		TabHost tabHost=(TabHost)findViewById(R.id.tabhost);
		
		tabHost.setup();
		TextView txtTab = new TextView(this);
		txtTab.setTextSize(14);
		
		
		TabSpec spec1=tabHost.newTabSpec("Accepted");
		spec1.setContent(R.id.tab1);
		spec1.setIndicator("Accepted");
		
		
		

		TabSpec spec2=tabHost.newTabSpec("Rejected");
		spec2.setIndicator("Rejected");
		spec2.setContent(R.id.tab2);

		TabSpec spec3=tabHost.newTabSpec("Pending Acceptance");
		spec3.setIndicator("Pending Acceptance");
		spec3.setContent(R.id.tab3);

		tabHost.addTab(spec1);
		tabHost.addTab(spec2);
		tabHost.addTab(spec3);
		}
		
}