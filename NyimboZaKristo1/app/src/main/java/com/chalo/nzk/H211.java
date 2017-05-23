package com.chalo.nzk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class H211 extends Activity{
	TextView  tv ;
	private ImageButton buttonPlay;
	private ImageButton buttonPause;
	private MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.h2);
		
		tv = (TextView)findViewById(R.id.tv);
		tv.setText(readNewTxt());
		
	}

	private CharSequence readNewTxt() {
		// TODO Auto-generated method stub
		InputStream inputStream = getResources().openRawResource(R.raw.n211);
		 ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         int i;
		 try {
		 i = inputStream.read();
		while (i != -1)
		  {
		   byteArrayOutputStream.write(i);
		   i = inputStream.read();
		   }
		    inputStream.close();
		  } catch (IOException e) {
		   // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

		 return byteArrayOutputStream.toString();
		 }
	



	}
	