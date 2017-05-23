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
public class C6 extends ListActivity{
String songs[]={"43-Furaha Gani","44-Urafiki Wa Yesu","45-Mwanga Umo Moyoni","46-Miguuni Pake Yesu","47-Ni Heri Kifungo","48-Ninakupenda Zaidi","49-Ninaye Rafiki","50-Mungu Nawe Nanyi Daima",
		"51-Kuwa Na Yesu","52-Nipe Biblia"};
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
				intent = new Intent (C6.this,H43.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C6.this,H44.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C6.this,H45.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C6.this,H46.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C6.this,H47.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C6.this,H48.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C6.this,H49.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C6.this,H50.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C6.this,H51.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C6.this,H52.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
