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
public class C30 extends ListActivity{
String songs[]={"210-Roho Wa Mungu","211-Moyoni","212-Mtazame Mwokozi","213-Niwe Nao Uzuri Wa Mwokozi","214-Nataka Niwe Tayari","215-Ulimwengu Wataka","216-Moyoni 'Nijaze","217-Omba Sana Asubuhi","218-Yesu Mwokozi Mpendwa","219-Pambazuka Nuru","220-Kwa Heri"};
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
				intent = new Intent (C30.this,H210.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C30.this,H211.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C30.this,H212.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C30.this,H213.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C30.this,H214.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C30.this,H215.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C30.this,H216.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C30.this,H217.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C30.this,H218.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C30.this,H219.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C30.this,H220.class);
				startActivity(intent);
				}
			
	}

	
	});
	}

;
}
