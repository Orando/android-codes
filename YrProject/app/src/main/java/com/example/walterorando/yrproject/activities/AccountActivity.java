package com.example.walterorando.yrproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.fragments.Log_in_fragment;
import com.example.walterorando.yrproject.fragments.Sign_Up_fragment;
import com.example.walterorando.yrproject.helper.PreferenceHelper;


/**
 * Created by Walter Orando on 3/24/2016.
 */

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  PreferenceHelper.setEmail(null,getApplicationContext());

        if (PreferenceHelper.getAccessToken(getApplicationContext()) != null){
            Intent intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_startpage);
            Button login = (Button)findViewById(R.id.login);
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AccountActivity.this, Authentication_Activity.class);
                    intent.putExtra("login", "login");
                    startActivity(intent);
                }
            });

            Button register = (Button)findViewById(R.id.newAcc);
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AccountActivity.this, Authentication_Activity.class);
                    intent.putExtra("signup", "signup");
                    startActivity(intent);
                }
            });
        }


    }
}

