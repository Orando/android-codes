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
public class C3 extends ListActivity{
String songs[]={"29-Yesu, Nakupenda","30-Yesu Unipendaye","31-Niimbe Pendo Lake","32-Tangu Kuamini","33-Karibu Sana",
		"34-Hadithia Kisa Cha Yesu","35-Nimekombolewa Na Yesu","36-Siku Kuu","37-Pendo Lako, Ee Mwokozi"};
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
				intent = new Intent (C3.this,H29.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C3.this,H30.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C3.this,H31.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C3.this,H32.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C3.this,H33.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C3.this,H34.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C3.this,H35.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C3.this,H36.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C3.this,H37.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
