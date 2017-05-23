package com.example.walterorando.yrproject.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.walterorando.yrproject.R;

/**
 * Created by Walter Orando on 3/23/2016.
 */
public class Utils {

    public static int getToolbarHeight(Context context) {
        final TypedArray styledAttributes = context.getTheme().obtainStyledAttributes(
                new int[]{R.attr.actionBarSize});
        int toolbarHeight = (int) styledAttributes.getDimension(0, 0);
        styledAttributes.recycle();

        return toolbarHeight;
    }

    public static int getTabsHeight(Context context) {
        return (int) context.getResources().getDimension(R.dimen.tabsHeight);
    }

    public void setSingleMsgAlert(Context mCtx, String msg) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        LayoutInflater inflater = (LayoutInflater) mCtx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.single_msg_dialog, null);
        TextView txtAMsg = (TextView) layout.findViewById(R.id.txtHead);
        Button btnOk = (Button) layout.findViewById(R.id.dialog_ok);
        txtAMsg.setText(msg);
        builder.setView(layout);
        final AlertDialog alertDialog = builder.create();

        if (!((Activity) mCtx).isFinishing()) {

            alertDialog.show();
        }
        alertDialog.show();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                alertDialog.dismiss();
            }
        });
    }
}
