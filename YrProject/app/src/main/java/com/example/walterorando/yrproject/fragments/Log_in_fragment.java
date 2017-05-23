package com.example.walterorando.yrproject.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.activities.Authentication_Activity;
import com.example.walterorando.yrproject.app.AppConfig;
import com.example.walterorando.yrproject.app.AppController;
import com.example.walterorando.yrproject.activities.MainActivity;
import com.example.walterorando.yrproject.database.LoginDataBaseAdapter;
import com.example.walterorando.yrproject.helper.PreferenceHelper;
import com.example.walterorando.yrproject.helper.SessionManager;
import com.example.walterorando.yrproject.helper.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Log_in_fragment extends Fragment implements View.OnClickListener{

    private EditText Username,Password;
    private ProgressBar progressbar;
    private TextView status;
    private LinearLayout linearlayout;

    private Boolean isInternetPresent;
    private Utils utils;


    private SessionManager sessionManager;
    LoginDataBaseAdapter loginDataBaseAdapter;

    public Log_in_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_login, container, false);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Montserrat-Regular.ttf");

        Username = (EditText) layout.findViewById(R.id.username);
        Password = (EditText)layout.findViewById(R.id.password);
        Password.setTransformationMethod(new PasswordTransformationMethod());

        Button login = (Button)layout.findViewById(R.id.login);
        progressbar = (ProgressBar)layout.findViewById(R.id.progressBar);
        status = (TextView)layout.findViewById(R.id.status);
        linearlayout = (LinearLayout)layout.findViewById(R.id.loginLyt);
        progressbar.setVisibility(View.GONE);
        status.setVisibility(View.GONE);

        utils = new Utils();

        // SQLite database handler
        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        try {
            loginDataBaseAdapter=loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Session manager
        sessionManager = new SessionManager(getActivity());

        // Check if user is already logged in or not
        if (sessionManager.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }


        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!Username.getText().toString().isEmpty() && !Password.getText().toString().isEmpty()){
                    // fetch the Password form database for respective user name
                    String storedPassword = loginDataBaseAdapter.getSingleEntry(Username.getText().toString().trim());

                    // check if the Stored password matches with  Password entered by user
                    if(Password.getText().toString().equals(storedPassword))
                    {
                        Toast.makeText(getActivity(), "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                        PreferenceHelper.setAccessToken("access token",getActivity());
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }else
                    {
                        Toast.makeText(getActivity(), "User Name or Password does not match", Toast.LENGTH_LONG).show();
                    }

                }else {
                    // Prompt user to enter credentials
                    if (Username.getText().toString().isEmpty()) {
                        Username.setError(getString(R.string.error_empty_fields));
                    } else if (Password.getText().toString().isEmpty()) {
                        Password.setError(getString(R.string.error_empty_fields));
                    }
                }

            }
            });


        TextView signUp = (TextView)layout.findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Authentication_Activity.class);
                intent.putExtra("signup", "signup");
                startActivity(intent);
            }
        });


        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    /**
     * function to verify login details in mysql db
     * */

    private void showDialog() {
        progressbar.setVisibility(View.VISIBLE);
        status.setVisibility(View.VISIBLE);
        status.setText(getString(R.string.loading));
        linearlayout.setVisibility(View.GONE);
    }

    private void hideDialog() {
        progressbar.setVisibility(View.GONE);
        status.setVisibility(View.GONE);
        linearlayout.setVisibility(View.VISIBLE);
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View v) {

    }

}
