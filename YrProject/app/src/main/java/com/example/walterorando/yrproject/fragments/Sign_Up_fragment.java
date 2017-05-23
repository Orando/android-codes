package com.example.walterorando.yrproject.fragments;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.PopupMenu;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.walterorando.yrproject.R;
import com.example.walterorando.yrproject.activities.Authentication_Activity;
import com.example.walterorando.yrproject.activities.MainActivity;
import com.example.walterorando.yrproject.activities.RegisterUserClass;
import com.example.walterorando.yrproject.database.LoginDataBaseAdapter;
import com.example.walterorando.yrproject.helper.FilePath;
import com.example.walterorando.yrproject.helper.SessionManager;
import com.example.walterorando.yrproject.helper.Utils;
import com.example.walterorando.yrproject.models.HomeItems;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Walter Orando on 3/23/2016.
 */
public class Sign_Up_fragment extends Fragment implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {


    EditText eFullnames, eUsername, eEmail, ePassword, eConfirmpass;
    String me;

    private ProgressBar progressBar;
    private TextView status;
    private LinearLayout linearLayout;
    ImageView avatar;
    private SessionManager sessionManager;

    LoginDataBaseAdapter loginDataBaseAdapter;

    private static final int SELECT_PIC = 0;
    private static final int SELECT_PIC_CAMERA = 2;
    private String selectedAvatarImagePath = null;

    private Utils utils;
    private Boolean isInternetPresent;

    public Sign_Up_fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_sign_up, container, false);

        eFullnames = (EditText) layout.findViewById(R.id.fullnames);
        eUsername = (EditText) layout.findViewById(R.id.username);
        eEmail = (EditText) layout.findViewById(R.id.email);
        ePassword = (EditText) layout.findViewById(R.id.password);
        ePassword.setTransformationMethod(new PasswordTransformationMethod());
        eConfirmpass = (EditText) layout.findViewById(R.id.passwordConfirm);
        eConfirmpass.setTransformationMethod(new PasswordTransformationMethod());
        progressBar = (ProgressBar) layout.findViewById(R.id.progressBar);
        status = (TextView) layout.findViewById(R.id.status);
        linearLayout = (LinearLayout) layout.findViewById(R.id.loginLyt);
        avatar = (ImageView) layout.findViewById(R.id.avatar);
        TextView photo = (TextView) layout.findViewById(R.id.photo);
        progressBar.setVisibility(View.GONE);
        status.setVisibility(View.GONE);

        avatar.setOnClickListener(this);
        photo.setOnClickListener(this);

        utils = new Utils();



        // Session manager
        sessionManager = new SessionManager(getActivity());

        // SQLite database handler
        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        try {
            loginDataBaseAdapter=loginDataBaseAdapter.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Check if user is already logged in or not
        if (sessionManager.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(getActivity(),
                    MainActivity.class);
            startActivity(intent);

        }


        Button register = (Button) layout.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
                showDialog();
            }
        });

        TextView signIn = (TextView) layout.findViewById(R.id.sign_in);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Authentication_Activity.class);
                intent.putExtra("login", "login");
                startActivity(intent);
            }
        });

        return layout;
    }


    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     */



    private void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
        status.setVisibility(View.VISIBLE);
        status.setText(getString(R.string.loading));
        linearLayout.setVisibility(View.GONE);
    }

    private void hideDialog() {
        progressBar.setVisibility(View.GONE);
        status.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }

    @Override
    public void onResume() {
        super.onResume();
        //Profile profile = Profile.getCurrentProfile();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.avatar) {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.inflate(R.menu.menu_image_source);
            popupMenu.show();
        } else if (v.getId() == R.id.photo) {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            popupMenu.setOnMenuItemClickListener(this);
            popupMenu.inflate(R.menu.menu_image_source);
            popupMenu.show();
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cameraItem:
                if (getActivity().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Authentication_Activity activity = (Authentication_Activity) getActivity();
                    if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {
                        File photoFile = null;
                        try {
                            photoFile = createImageFile();
                        } catch (IOException ex) {
                            Toast toast = Toast.makeText(activity, getString(R.string.save_error), Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        if (photoFile != null) {
                            Uri fileUri = Uri.fromFile(photoFile);
                            activity.setCapturedImageURI(fileUri);
                            activity.setCurrentPhotoPath(fileUri.getPath());
                            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                    activity.getCapturedImageURI());
                            startActivityForResult(takePictureIntent, SELECT_PIC_CAMERA);
                        }
                    }
                } else {
                    Toast.makeText(getActivity(), getString(R.string.no_camera), Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.galleryItem:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(intent, getActivity().getString(R.string.select_an_image)),
                        SELECT_PIC);
                return true;
        }
        return true;
    }
/*
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getActivity();
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_PIC) {
                selectedAvatarImagePath = FilePath.getPath(getActivity(), data.getData());
                Glide.with(getActivity())
                        .load(new File(selectedAvatarImagePath))
                        .asBitmap()
                        .centerCrop()
                        .placeholder(R.drawable.avatar)
                        .error(R.drawable.image_holder)
                        .into(new BitmapImageViewTarget(avatar) {
                            @Override
                            protected void setResource(Bitmap resource) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                                circularBitmapDrawable.setCircular(true);
                                avatar.setImageDrawable(circularBitmapDrawable);
                            }
                        });
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getActivity().getContentResolver()
                        .query(selectedImage, filePathColumn, null, null,
                                null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                HomeItems images = new HomeItems();
                images.setPath(picturePath);


            }  else if (requestCode == SELECT_PIC_CAMERA) {
                addPhotoToGallery();
                Authentication_Activity activity = (Authentication_Activity) getActivity();
                selectedAvatarImagePath = activity.getCurrentPhotoPath();
                Glide.with(getActivity())
                        .load(activity.getCurrentPhotoPath())
                        .asBitmap()
                        .centerCrop()
                        .placeholder(R.drawable.avatar)
                        .error(R.drawable.image_holder)
                        .into(new BitmapImageViewTarget(avatar) {
                            @Override
                            protected void setResource(Bitmap resource) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                                circularBitmapDrawable.setCircular(true);
                                avatar.setImageDrawable(circularBitmapDrawable);
                            }
                        });
                HomeItems images = new HomeItems();
                images.setPath(selectedAvatarImagePath);
            }

        }
    }

*************************/
    protected File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        String imageFileName = "tandazafc_" + timeStamp;
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        Authentication_Activity activity = (Authentication_Activity)getActivity();
        activity.setCurrentPhotoPath("file:" + image.getAbsolutePath());
        return image;
    }

    protected void addPhotoToGallery() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Authentication_Activity activity = (Authentication_Activity)getActivity();
        File f = new File(activity.getCurrentPhotoPath());
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.getActivity().sendBroadcast(mediaScanIntent);
    }

    private void registerUser(){

        if (eFullnames.getText().toString().isEmpty()) {
            eFullnames.setError(getString(R.string.error_empty_fields));
        }else if (eUsername.getText().toString().isEmpty()) {
            eUsername.setError(getString(R.string.error_empty_fields));
        }else if (eEmail.getText().toString().isEmpty()) {
            eEmail.setError(getString(R.string.error_empty_fields));
        } else if (ePassword.getText().toString().isEmpty()) {
            ePassword.setError(getString(R.string.error_empty_fields));
        }else if (ePassword.getText().toString().length() < 8) {
            ePassword.setError(getString(R.string.error_weak_pass));
        } else if (eConfirmpass.getText().toString().isEmpty()) {
            eConfirmpass.setError(getString(R.string.error_empty_fields));
        } else if (!ePassword.getText().toString().equalsIgnoreCase(eConfirmpass.getText().toString())) {
            eConfirmpass.setError(getString(R.string.error_pass_no_match));
        } else if (selectedAvatarImagePath == null) {
            Toast.makeText(getActivity(), getString(R.string.error_image), Toast.LENGTH_SHORT).show();
        } else if(!eFullnames.getText().toString().isEmpty() && !eUsername.getText().toString().isEmpty() && !ePassword.getText().toString().isEmpty()){
            // Save the Data in Database
            loginDataBaseAdapter.insertEntry(eUsername.getText().toString(), ePassword.getText().toString(),eFullnames.getText().toString(),eEmail.getText().toString());
            Toast.makeText(getActivity(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
            hideDialog();
            Intent intent = new Intent(getActivity(), Authentication_Activity.class);
            intent.putExtra("login", "login");
            startActivity(intent);
        }

    }

}
