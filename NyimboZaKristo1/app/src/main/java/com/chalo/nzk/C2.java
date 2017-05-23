package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
public class C2 extends ListActivity{
String songs[]={"26-Tutokapo Tubariki","26a-Tupe Amani","27-Tena, Mwokozi, Twalitukuza Jina Lako","28-Jina La Thamani"};
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
				intent = new Intent (C2.this,H26.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C2.this,H26a.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C2.this,H27.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C2.this,H28.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
