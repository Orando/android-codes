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
public class C7 extends ListActivity{
String songs[]={"53-Napenda Kuhubiri","54-Nataka Nimjue Yesu","55-Twapanda Mapema","56-Waponyeni Watu","57-Usikatae Kazi","58-Zitakuwa Nyota Tajini?","59-Fanyeni Kazi Zenu","60-Nitakwenda Utakaponituma","61-Bwana, Nami","62-Napenda Kitabu Chake","63-Niuonapo Msalaba"};
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
				intent = new Intent (C7.this,H53.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C7.this,H54.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C7.this,H55.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C7.this,H56.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C7.this,H57.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C7.this,H58.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C7.this,H59.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C7.this,H60.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C7.this,H61.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C7.this,H62.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C7.this,H63.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
