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
public class C29 extends ListActivity{
String songs[]={"196-Vito Vya Thamani","197-Ananipenda Ni Kweli","198-Kaza Sana Macho","199-Upendo Ni Furaha","200-Baba Yetu Aliye Mbinguni","201-Hunipenda Pia","202-Sikia Mlio","203-Ya Saba Ni Kwa Yesu","204-Kuwa Na Yesu Nyumbani","205-Msifu Mungu Ee Watoto",
		"206-Mwokozi Wangu Anipenda","207-Nani Afanya Maua","208-Mungu Afanya Upindi","209-Napenda Sana Kufika"};
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
				intent = new Intent (C29.this,H196.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C29.this,H197.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C29.this,H198.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C29.this,H199.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C29.this,H200.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C29.this,H201.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C29.this,H202.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C29.this,H203.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C29.this,H204.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C29.this,H205.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C29.this,H206.class);
				startActivity(intent);
				}
			if(position==11){
				intent = new Intent (C29.this,H207.class);
				startActivity(intent);
				}
			if(position==12){
				intent = new Intent (C29.this,H208.class);
				startActivity(intent);
				}
			if(position==13){
				intent = new Intent (C29.this,H209.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
