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
public class C21 extends ListActivity{
String songs[]={"168-Tarumbeta Ya Mwana","169-Tutashindaje Hukumuni?","170-Jina Langu Limeandikwa Je?",
		"171-Hukumu","172-Mfalme Ajapo","173-Hatujui Saa","174-Tukimngojea"};
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
				intent = new Intent (C21.this,H168.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C21.this,H169.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C21.this,H170.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C21.this,H171.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C21.this,H172.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C21.this,H173.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C21.this,H174.class);
				startActivity(intent);
				}
			
			
	}

	
	});
	}

;
}
