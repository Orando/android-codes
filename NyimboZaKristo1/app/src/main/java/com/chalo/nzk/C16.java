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
public class C16 extends ListActivity{
String songs[]={"126-Nina Haja Nawe","127-Ni Salama Rohoni Mwangu","128-Taamini Nitii Pia","129-Kumtegemea Mwokozi","130-Yesu Kwetu Ni Rafiki","131-Baba Anilinda","131a-Kwa Mahitaji Ya Kesho","132-Bwana Ni Mchunga","133-Po Pote Na Yesu","134-Tafuta Daima Utakatifu"};
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
				intent = new Intent (C16.this,H126.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C16.this,H127.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C16.this,H128.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C16.this,H129.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C16.this,H130.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C16.this,H131.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C16.this,H131a.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C16.this,H132.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C16.this,H133.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C16.this,H134.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
