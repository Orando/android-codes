package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C9 extends ListActivity{
String songs[]={"81-Siku Sita Zimepita","82-Ni Siku Ya Furaha","83-Ewe Skuli Ya Sabato","84-Ikumbuke Sabato","85-Salama Tumepita",
		"86-Ukaribie Tena","87-Siku Ya Sabato","88-Siku Hii Ya Sabato"};
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
				intent = new Intent (C9.this,H81.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C9.this,H82.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C9.this,H83.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C9.this,H84.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C9.this,H85.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C9.this,H86.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C9.this,H87.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C9.this,H88.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
