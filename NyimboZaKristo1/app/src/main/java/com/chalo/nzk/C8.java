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
public class C8 extends ListActivity{
String songs[]={"64-Piga Panda","65-Twendeni Askari","66-Roho Yangu Amka Sasa","67-Kesha Roho Yangu","68-Tusimame Imara Mwambani",
		"69-Cha Kutumaini Sina","70-Wapenzi Wa Bwana","71-Kesheni Kaombeni","72-Jenga Juu Ya Mwamba","73-'Bwana, Uniongoze Juu'",
		"74-Niambie, Ee Mlinzi","75-Msingi Imara, Ninyi Wa Bwana","76-Mrithi Ufalme","77-Habari Za Usiku","78-Mpaka Lini Bwana?","79-Nataka Imani Hii","80-Tupe Moto Wa Uhai"};
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
				intent = new Intent (C8.this,H64.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C8.this,H65.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C8.this,H66.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C8.this,H67.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C8.this,H68.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C8.this,H69.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C8.this,H70.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C8.this,H71.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C8.this,H72.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C8.this,H73.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C8.this,H74.class);
				startActivity(intent);
				}
			if(position==11){
				intent = new Intent (C8.this,H75.class);
				startActivity(intent);
				}
			if(position==12){
				intent = new Intent (C8.this,H76.class);
				startActivity(intent);
				}
			if(position==13){
				intent = new Intent (C8.this,H77.class);
				startActivity(intent);
				}
			if(position==14){
				intent = new Intent (C8.this,H78.class);
				startActivity(intent);
				}
			if(position==15){
				intent = new Intent (C8.this,H79.class);
				startActivity(intent);
				}
			if(position==16){
				intent = new Intent (C8.this,H80.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
