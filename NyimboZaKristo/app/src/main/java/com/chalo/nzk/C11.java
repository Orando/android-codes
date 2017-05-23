package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C11 extends ListActivity{
String songs[]={"91-Kaa Nami","92-Magharibi Jua","93-Jua La Rohoni Mwangu"};
Intent intent = null;


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setListAdapter(new ArrayAdapter<String>(this,R.layout.songlist,R.id.textView1,songs));
	
	ListView lv = getListView();
	lv.setOnItemClickListener(new OnItemClickListener() {
	@Override
		public void onItemClick(AdapterView<?>arg0, View arg1, int position,long arg3){
	if(position==0){
				intent = new Intent (C11.this,H91.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C11.this,H92.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C11.this,H93.class);
				startActivity(intent);
				}
	}

	
	});
	}

;
}
