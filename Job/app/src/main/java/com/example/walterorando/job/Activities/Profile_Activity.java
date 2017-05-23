package com.example.walterorando.job.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.walterorando.job.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Walter Orando on 3/24/2016.
 */
public class Profile_Activity extends AppCompatActivity implements View.OnClickListener {
    String fullnames, username, email, avatarPic;
    EditText playingpos,birthday ,nationality,jerseyno;
    private DatePickerDialog born;
    private SimpleDateFormat simpledateformat;

   // LoginDataBaseAdapter mydb;

    public LinearLayoutManager layoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

      //  mydb = new LoginDataBaseAdapter(getApplicationContext());

       // HashMap<String, String> user = mydb.getUserDetails();

      /*  username = user.get("USERNAME");
        fullnames = user.get("FULLNAMES");
        email = user.get("EMAIL");*/

        TextView Username = (TextView) findViewById(R.id.username);
        Username.setText(username);
        TextView Fullname = (TextView) findViewById(R.id.fullname);
        Fullname.setText(fullnames);
        TextView Email = (TextView) findViewById(R.id.email);
        Email.setText(email);
        playingpos = (EditText)findViewById(R.id.playingPos);
        birthday = (EditText)findViewById(R.id.birthday);
        birthday.requestFocus();
        nationality = (EditText)findViewById(R.id.nationality);
        jerseyno =(EditText)findViewById(R.id.jerseyNo);

        simpledateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        setDateTimeField();

        Button SendDetails = (Button)findViewById(R.id.senddetails);
        SendDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Apply();
            }
        });

        final ImageView avatar = (ImageView) findViewById(R.id.avatar);
        Glide.with(getApplicationContext())
                .load(avatarPic)
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.avatar)
                .error(R.drawable.avatar)
                .into(new BitmapImageViewTarget(avatar) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        avatar.setImageDrawable(circularBitmapDrawable);
                    }

                });
        layoutmanager = new LinearLayoutManager(Profile_Activity.this);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
    }
    private void setDateTimeField(){
        birthday.setOnClickListener(this);
                Calendar calendar = Calendar.getInstance();
                born = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year,monthOfYear,dayOfMonth);
                        birthday.setText(simpledateformat.format(newDate.getTime()));
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            }


    public void Apply(){
        if(playingpos.getText().toString().isEmpty()) {
            playingpos.setError(getString(R.string.error_empty_fields));
        }else if(birthday.getText().toString().isEmpty()){
            birthday.setError(getString(R.string.error_empty_fields));
        }else if(nationality.getText().toString().isEmpty()){
            nationality.setError(getString(R.string.error_empty_fields));
        }else if(jerseyno.getText().toString().isEmpty()){
            jerseyno.setError(getString(R.string.error_empty_fields));
        }else{
            Toast.makeText(getApplicationContext(),"Details captured: wait for response", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main_drawer, menu);
        return true;
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        }

    @Override
    public void onClick(View v) {
        born.show();
    }
}
