package com.chalo.nzk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nzk, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item) 
	{
		// TODO Auto-generated method stub
		switch (item.getItemId())
		{
	case R.id.share:
     
		Intent sendIntent = new Intent(Intent.ACTION_SEND);
		//sendIntent.setAction(Intent.ACTION_SEND);
		sendIntent.putExtra(Intent.EXTRA_TEXT,"Download the App 'Nyimbo Za Kristo' with midi and categorized hymns. Click on this link https://play.google.com/store/apps/details?id=com.chalo.nzk");
		sendIntent.setType("text/plain");
		startActivity(sendIntent);
     return true;
 
   
 default:
     
		return super.onOptionsItemSelected(item);
	}
	}
	
}
