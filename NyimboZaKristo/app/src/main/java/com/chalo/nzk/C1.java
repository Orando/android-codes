package com.chalo.nzk;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
public class C1 extends ListActivity{
String songs[]={"1-Mtakatifu, Mtakatifu, Mtakatifu.","2-Twamsifu Mungu","3-Mungu Atukuzwe","4-Jina Ya Yesu, Salamu","5-Na Tumwabudu Mfalme Mtukufu","6-Kumekucha Kwa Uzuri","7-Mungu Msaada Wetu","8-Uje Mkombozi","9-Mwumbaji, Mfalme","10-Kristo Wa Neema Yote","11-Jina La Bwana Li Heri","12-Msifu Mungu","13-Yesu Uje Kwetu","14-Nitembee Nawe","15-Nena Mungu","16-Ninakuhitaji","17-Si Mimi, Kristo",
		"18-Mwokozi Kama Mchunga","19-Msalabani Pa Mwokozi","20-Mungu Wetu Yeye Mwamba","21-Baba Twakujia","22-Usinipite","23-Yesu Furaha Ya Myoyo","24-Jina Lake Yesu Tamu","25-Taji Mvikeni"};
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
				intent = new Intent (C1.this,H1.class);
				startActivity(intent);
				}
			if(position==1){
				intent = new Intent (C1.this,H2.class);
				startActivity(intent);
				}
			if(position==2){
				intent = new Intent (C1.this,H3.class);
				startActivity(intent);
				}
			if(position==3){
				intent = new Intent (C1.this,H4.class);
				startActivity(intent);
				}
			if(position==4){
				intent = new Intent (C1.this,H5.class);
				startActivity(intent);
				}
			if(position==5){
				intent = new Intent (C1.this,H6.class);
				startActivity(intent);
				}
			if(position==6){
				intent = new Intent (C1.this,H7.class);
				startActivity(intent);
				}
			if(position==7){
				intent = new Intent (C1.this,H8.class);
				startActivity(intent);
				}
			if(position==8){
				intent = new Intent (C1.this,H9.class);
				startActivity(intent);
				}
			if(position==9){
				intent = new Intent (C1.this,H10.class);
				startActivity(intent);
				}
			if(position==10){
				intent = new Intent (C1.this,H11.class);
				startActivity(intent);
				}
			if(position==11){
				intent = new Intent (C1.this,H12.class);
				startActivity(intent);
				}
			if(position==12){
				intent = new Intent (C1.this,H13.class);
				startActivity(intent);
				}
			if(position==13){
				intent = new Intent (C1.this,H14.class);
				startActivity(intent);
				}
			if(position==14){
				intent = new Intent (C1.this,H15.class);
				startActivity(intent);
				}
			if(position==15){
				intent = new Intent (C1.this,H16.class);
				startActivity(intent);
				}
			if(position==16){
				intent = new Intent (C1.this,H17.class);
				startActivity(intent);
				}
			if(position==17){
				intent = new Intent (C1.this,H18.class);
				startActivity(intent);
				}
			if(position==18){
				intent = new Intent (C1.this,H19.class);
				startActivity(intent);
				}
			if(position==19){
				intent = new Intent (C1.this,H20.class);
				startActivity(intent);
				}
			if(position==20){
				intent = new Intent (C1.this,H21.class);
				startActivity(intent);
				}
			if(position==21){
				intent = new Intent (C1.this,H22.class);
				startActivity(intent);
				}
			if(position==22){
				intent = new Intent (C1.this,H23.class);
				startActivity(intent);
				}
			if(position==23){
				intent = new Intent (C1.this,H24.class);
				startActivity(intent);
				}
			if(position==24){
				intent = new Intent (C1.this,H25.class);
				startActivity(intent);
				}
	}

	
	});
	}

;
}
