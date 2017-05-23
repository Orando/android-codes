package com.chalo.nzk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Yaliyomo extends Activity implements OnClickListener{
	Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,
	btn11,btn12,btn13,btn14,btn15,btn16,btn17,btn18,btn19,btn20
	,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30;
	Intent intent = null;
	TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.yaliyomo);
		tv1 = (TextView)findViewById(R.id.textView1);
		tv2 = (TextView)findViewById(R.id.textView2);
		tv3 = (TextView)findViewById(R.id.textView3);
		tv4 = (TextView)findViewById(R.id.textView4);
		tv5 = (TextView)findViewById(R.id.textView5);
		tv6 = (TextView)findViewById(R.id.textView6);
		tv7 = (TextView)findViewById(R.id.textView7);
	}

	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn1:
			intent = new Intent(Yaliyomo.this,C1.class);
			startActivity(intent);
			break;
		case R.id.btn2:
			intent = new Intent(Yaliyomo.this,C2.class);
			startActivity(intent);
			break;
		case R.id.btn3:
			intent = new Intent(Yaliyomo.this,C3.class);
			startActivity(intent);
			break;
		case R.id.btn4:
			intent = new Intent(Yaliyomo.this,C4.class);
			startActivity(intent);
			break;
		case R.id.btn5:
			intent = new Intent(Yaliyomo.this,C5.class);
			startActivity(intent);
			break;
		case R.id.btn6:
			intent = new Intent(Yaliyomo.this,C6.class);
			startActivity(intent);
			break;
		case R.id.btn7:
			intent = new Intent(Yaliyomo.this,C7.class);
			startActivity(intent);
			break;
		case R.id.btn8:
			intent = new Intent(Yaliyomo.this,C8.class);
			startActivity(intent);
			break;
		case R.id.btn9:
			intent = new Intent(Yaliyomo.this,C9.class);
			startActivity(intent);
			break;
		case R.id.btn10:
			intent = new Intent(Yaliyomo.this,C10.class);
			startActivity(intent);
			break;
		case R.id.btn11:
			intent = new Intent(Yaliyomo.this,C11.class);
			startActivity(intent);
			break;
		case R.id.btn12:
			intent = new Intent(Yaliyomo.this,C12.class);
			startActivity(intent);
			break;
		case R.id.btn13:
			intent = new Intent(Yaliyomo.this,C13.class);
			startActivity(intent);
			break;
		case R.id.btn14:
			intent = new Intent(Yaliyomo.this,C14.class);
			startActivity(intent);
			break;
		case R.id.btn15:
			intent = new Intent(Yaliyomo.this,C15.class);
			startActivity(intent);
			break;
		case R.id.btn16:
			intent = new Intent(Yaliyomo.this,C16.class);
			startActivity(intent);
			break;
		case R.id.btn17:
			intent = new Intent(Yaliyomo.this,C17.class);
			startActivity(intent);
			break;
		case R.id.btn18:
			intent = new Intent(Yaliyomo.this,C18.class);
			startActivity(intent);
			break;
		case R.id.btn19:
			intent = new Intent(Yaliyomo.this,C19.class);
			startActivity(intent);
			break;
		case R.id.btn20:
			intent = new Intent(Yaliyomo.this,C20.class);
			startActivity(intent);
			break;
		case R.id.btn21:
			intent = new Intent(Yaliyomo.this,C21.class);
			startActivity(intent);
			break;
		case R.id.btn22:
			intent = new Intent(Yaliyomo.this,C22.class);
			startActivity(intent);
			break;
		case R.id.btn23:
			intent = new Intent(Yaliyomo.this,C23.class);
			startActivity(intent);
			break;
		case R.id.btn24:
			intent = new Intent(Yaliyomo.this,C24.class);
			startActivity(intent);
			break;
		case R.id.btn25:
			intent = new Intent(Yaliyomo.this,C25.class);
			startActivity(intent);
			break;
		case R.id.btn26:
			intent = new Intent(Yaliyomo.this,C26.class);
			startActivity(intent);
			break;
		case R.id.btn27:
			intent = new Intent(Yaliyomo.this,C27.class);
			startActivity(intent);
			break;
		case R.id.btn28:
			intent = new Intent(Yaliyomo.this,C28.class);
			startActivity(intent);
			break;
		case R.id.btn29:
			intent = new Intent(Yaliyomo.this,C29.class);
			startActivity(intent);
			break;
		case R.id.btn30:
			intent = new Intent(Yaliyomo.this,C30.class);
			startActivity(intent);
			break;
			
		default:
			break;
		}
	}
	
	
}
