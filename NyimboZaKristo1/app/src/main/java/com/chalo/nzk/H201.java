package com.chalo.nzk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class H201 extends Activity{
	TextView  tv ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.h2);
		
		tv = (TextView)findViewById(R.id.tv);
		tv.setText(readNewTxt());
		
	}

	private CharSequence readNewTxt() {
		// TODO Auto-generated method stub
		InputStream inputStream = getResources().openRawResource(R.raw.n201);
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
	