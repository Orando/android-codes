package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C14 extends ListActivity{
String songs[]={"113-Bubujiko","114-Yesu Nataka Kutakaswa Sana","115-Naendea Msalaba","116-Moyo Safi","117-Wamwendea Yesu","118-Nilipotoka Kabisa","119-Alilipa Bei","120-Msalaba Wa Yesu"};
Intent intent = null;


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setListAdapter(new ArrayAdapter<String>(this,R.layout.songlist,songs));
	
	ListView lv = getListView();
	lv.setOnItemClickListener(new OnItemClickListener() {
	@Override
		public void onItemClick(AdapterView<?>arg0, View arg1, int position,long arg3){
	if(position==0){
				intent = new Intent (C14.this,H113.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C14.this,H114.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C14.this,H115.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C14.this,H116.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C14.this,H117.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C14.this,H118.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C14.this,H119.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C14.this,H120.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
