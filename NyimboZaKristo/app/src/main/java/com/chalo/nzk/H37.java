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

public class H37 extends Activity implements OnClickListener, OnCompletionListener{
	TextView  tv ;
	private ImageButton buttonPlay;
	private ImageButton buttonPause;
	private MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.h1);
		
		tv = (TextView)findViewById(R.id.tv);
		tv.setText(readNewTxt());
		buttonPlay = (ImageButton)findViewById(R.id.buttonPlay);
		buttonPlay.setOnClickListener(this);
		buttonPause = (ImageButton)findViewById(R.id.buttonPause);
		buttonPause.setOnClickListener(this);
		player = MediaPlayer.create(this, R.raw.s37);
		player.setLooping(true); // Set looping
		player.setOnCompletionListener(this);
		
	}

	private CharSequence readNewTxt() {
		// TODO Auto-generated method stub
		InputStream inputStream = getResources().openRawResource(R.raw.n37);
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


	@Override
	public void onClick(View v) 
	{
		if(v.getId() == R.id.buttonPlay)
		{
			 /** ImageButton onClick event handler. Method which start/pause mediaplayer playing */
			player.start();
		}
		else if(v.getId()==R.id.buttonPause)
		player.pause();
	}

	@Override
	public void onCompletion(MediaPlayer arg0) {
		// TODO Auto-generated method stub
		
		player.stop();
		
	}	
     @Override
	public void finish() {
		// TODO Auto-generated method stub
		player.stop();
		super.finish();
	}}
