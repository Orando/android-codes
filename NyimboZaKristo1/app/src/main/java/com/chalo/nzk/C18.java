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
public class C18 extends ListActivity{
String songs[]={"138-Nitakuandama Kote","139-Uliniimbie Tena","140-Hivi Nilivyo Unitwae","141-Chini Ya Msalaba","142-Nasikia Sauti Yako","143-Naamini","144-Ni Wako Bwana","145-Namtaka Bwana Yesu","146-Twae Wangu Uzima","147-Uishi Ndani Yangu","148-Univute Karibu","149-Kuwa Wake Yesu"};
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
				intent = new Intent (C18.this,H138.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C18.this,H139.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C18.this,H140.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C18.this,H141.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C18.this,H142.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C18.this,H143.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C18.this,H144.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C18.this,H145.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C18.this,H146.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C18.this,H147.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C18.this,H148.class);
				startActivity(intent);
				}
			if(position==11){
				intent = new Intent (C18.this,H149.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
