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
public class C19 extends ListActivity{
String songs[]={"150-Hasha, Maneno Mabaya Yasitoke","151-Huniongoza Mwongozi","152-Karibu Na Wewe, Mungu Wangu","153-Fikira Moja Tu",
		"154-Yanipasa Kuwa Naye","155-Njiani Huniongoza","156-Uniongoze, Yehova"};
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
				intent = new Intent (C19.this,H150.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C19.this,H151.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C19.this,H152.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C19.this,H153.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C19.this,H154.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C19.this,H155.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C19.this,H156.class);
				startActivity(intent);
				}
			
			
	}

	
	});
	}

;
}
