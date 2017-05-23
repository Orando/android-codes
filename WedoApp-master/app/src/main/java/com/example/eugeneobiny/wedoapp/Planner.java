package com.example.eugeneobiny.wedoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by EUGENE OBINY on 18/03/2017.
 */
public class Planner extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_planner, container, false);

        Button invitations = (Button) rootView.findViewById(R.id.InvitationButton);
        invitations.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Implement the code to run on button click here
                Intent a = new Intent(getActivity(), Invitations.class);
                startActivity(a);
            }
        });
        Button todo = (Button) rootView.findViewById(R.id.TodolistButton);
        todo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Implement the code to run on button click here
                Intent b = new Intent(getActivity(), Todolist.class);
                startActivity(b);
            }
        });
        Button vendors = (Button) rootView.findViewById(R.id.VendorsButton);
        vendors.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Implement the code to run on button click here
                Intent c = new Intent(getActivity(), Vendors.class);
                startActivity(c);
            }
        });
        Button journals = (Button) rootView.findViewById(R.id.JournalButton);
        journals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Implement the code to run on button click here
                Intent d = new Intent(getActivity(), Storyboard.class);
                startActivity(d);
            }
        });
        return rootView;
    }

}
