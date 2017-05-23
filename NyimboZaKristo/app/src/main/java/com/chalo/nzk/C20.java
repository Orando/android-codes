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
public class C20 extends ListActivity{
String songs[]={"157-Mfalme Yu Mlangoni","158-U Mwendo Gani Nyumbani?","159-Anakuja Upesi","160-Watakatifu Kesheni","161-Piga Panda","162-Tumaini Liko","163-Anakuja, Bwana Yesu","164-Mishale Ya Nuru","165-'Uwe Imara'","166-Furaha Kwa Ulimwengu","167-Yu Hai, Yu Hai"};
Intent intent = null;


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setListAdapter(new ArrayAdapter<String>(this,R.layout.songlist,R.id.textView1,songs));
	
	ListView lv = getListView();
	lv.setOnItemClickListener(new OnItemClickListener() {
	@Override
		public void onItemClick(AdapterView<?>arg0, View arg1, int position,long arg3){
	if(position==0){
				intent = new Intent (C20.this,H157.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C20.this,H158.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C20.this,H159.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C20.this,H160.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C20.this,H161.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C20.this,H162.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C20.this,H163.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C20.this,H164.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C20.this,H165.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C20.this,H166.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C20.this,H167.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
