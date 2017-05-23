package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C13 extends ListActivity{
String songs[]={"97-Sioshwi Dhambi Zangu","98-Nilikupa Wewe","99-Twende Kwa Yesu","100-Kuwatafuta","101-Yesu Akwita","102-Mlangoni Pa Moyo","103-Njoni Kwangu","104-Yesu Aliniita. 'Njoo'",
		"105-Mchungaji Mpenzi","106-Huna Kitu Kwa Yesu","107-Nipo Bwana, Nitume","108-Tumesikia Mbiu","109-Anisikiaye","110-Mlango Wazi","111-Tabibu Mkuu","112-Wewe Umechoka Sana?"};
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
				intent = new Intent (C13.this,H97.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C13.this,H98.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C13.this,H99.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C13.this,H100.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C13.this,H101.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C13.this,H102.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C13.this,H103.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C13.this,H104.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C13.this,H105.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C13.this,H106.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C13.this,H107.class);
				startActivity(intent);
				}
			if(position==11){
				intent = new Intent (C13.this,H108.class);
				startActivity(intent);
				}
			if(position==12){
				intent = new Intent (C13.this,H109.class);
				startActivity(intent);
				}
			if(position==13){
				intent = new Intent (C13.this,H110.class);
				startActivity(intent);
				}
			if(position==14){
				intent = new Intent (C13.this,H111.class);
				startActivity(intent);
				}
			if(position==15){
				intent = new Intent (C13.this,H112.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
