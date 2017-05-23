package com.example.walterorando.cameraapp;


import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private static int timer = 3000;
    private static final int SELECT_PIC = 2;
    private Camera mCamera;
    private CameraPreview mCameraPreview;
    String imagePath;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);


        if(checkCameraHardware(this)){

            mCamera = getCameraInstance();
            mCamera.setDisplayOrientation(90);
            mCameraPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mCameraPreview);

            Button captureButton = (Button) findViewById(R.id.button_capture);
            captureButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Waiting for three seconds", Toast.LENGTH_LONG).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mCamera.takePicture(null, null, mPictureCallback);
                            finish();
                        }
                    },timer);
                }
            });
        }else{
            Toast.makeText(this,"No Camera",Toast.LENGTH_LONG);
        }

    }

    Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            File pictureFile = getOutputMediaFile();
            Bitmap loadedImage = null;
            loadedImage = BitmapFactory.decodeByteArray(data, 0,
                    data.length);

            if (pictureFile == null) {
                Toast.makeText(MainActivity.this,"File picture file is null",Toast.LENGTH_LONG).show();
                return;
            }
            try {
                ByteArrayOutputStream ostream = new ByteArrayOutputStream();
                loadedImage.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                FileOutputStream fos = new FileOutputStream(pictureFile);
                fos.write(ostream.toByteArray());
                fos.close();
                imagePath = "file:" + pictureFile.getAbsolutePath();
                Log.i("File", "picture saved "+imagePath);
                Toast.makeText(MainActivity.this,"Picture saved in "+imagePath, Toast.LENGTH_LONG).show();
                Intent returnIntent = new Intent();
                //returnIntent.putExtra("data",data);
                returnIntent.putExtra("file", imagePath);
                setResult(Activity.RESULT_OK,returnIntent);
                //Toast.makeText(Custom_CameraActivity.this,"Intent made",Toast.LENGTH_LONG).show();
                finish();
            } catch (FileNotFoundException e) {
                Toast.makeText(MainActivity.this,"Error "+e.toString() ,Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(MainActivity.this,"Error "+e.toString() ,Toast.LENGTH_LONG).show();
            }

        }
    };

    private static File getOutputMediaFile() {
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "WambasiPic");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Camera", "failed to create directory");
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        File mediaFile;
        mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");

        return mediaFile;
    }
    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_PIC) {
            String image =data.getStringExtra("data");
            String path = FilePath.getPath(getApplicationContext(), data.getData());
            Intent returnIntent = new Intent();
            //returnIntent.putExtra("data",image);
            returnIntent.putExtra("file",path);
            setResult(Activity.RESULT_OK,returnIntent);
            finish();
        }
    }
}
