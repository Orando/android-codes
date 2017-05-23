package com.chalo.nzk;

import com.chalo.nzk.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NZK extends Activity implements OnClickListener{
Button btn1,btn2,btn3;
Intent intent = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nzk);
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
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			intent = new Intent(NZK.this,SongList.class);
			startActivity(intent);
			break;
		case R.id.button2:
			intent = new Intent(NZK.this,Yaliyomo.class);
			startActivity(intent);
			break;
		case R.id.button3:
			intent = new Intent(NZK.this,About.class);
			startActivity(intent);
			break;
		default:
			break;
		}
	}

	
	
}
