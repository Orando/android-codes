package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C12 extends ListActivity{
String songs[]={"94-Po Pote Mashamba Yajaa","95-Zileteni Zaka Kwa Hazina","96-Mali Yako Sasa"};
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
				intent = new Intent (C12.this,H94.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C12.this,H95.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C12.this,H96.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}