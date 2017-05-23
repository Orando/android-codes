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
public class C22 extends ListActivity{
String songs[]={"175-Uso Kwa Uso","176-Ati Tuonane Mtoni?","177-Kazi Yangu Ikisha","178-Ukingoni Mwa Yordani","179-Watafurahi","180-Pana Mahali Pazuri Mno","181-Tutakaa Mahali Pa Maji","182-Hapana Giza","183-Yesu Anaporudi"};
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
				intent = new Intent (C22.this,H175.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C22.this,H176.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C22.this,H177.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C22.this,H178.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C22.this,H179.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C22.this,H180.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C22.this,H181.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C22.this,H182.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C22.this,H183.class);
				startActivity(intent);
				}
			
			
	}

	
	});
	}

;
}
