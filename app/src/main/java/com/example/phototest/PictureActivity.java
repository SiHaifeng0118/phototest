package com.example.phototest;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import bean.Picture;
import view.PhotoView;

public class PictureActivity extends AppCompatActivity {
        String path;
        String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        PhotoView imageView = findViewById(R.id.PictureIV);
        imageView.enable();
        Intent intent = getIntent();
        path = intent.getStringExtra("picturepath");
        date = intent.getStringExtra("pictureDate");
        File file = new File(path);
        Glide.with(PictureActivity.this).load(path).into(imageView);

        TextView pic_Date = findViewById(R.id.pic_date);
        TextView pic_Loc = findViewById(R.id.pic_Loc);
        pic_Date.setText(date);

        Button button = findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//
////将功能Scheme以URI的方式传入data
//                Uri uri = Uri.parse("androidamap://navi?sourceApplication=appname&amp;poiname=fangheng&amp;lat=36.547901&amp;lon=104.258354&amp;dev=1&amp;style=2");
//                intent.setData(uri);
//
////启动该页面即可
//                startActivity(intent);
//                double currLocationY = 32.43571 ;
//                double currLocationX=119.569684;
//                String url;
//
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.addCategory(Intent.CATEGORY_DEFAULT);
//                Log.i("高德定位：","经度："+currLocationY+" ,纬度："+currLocationX);
//                if (currLocationX == 0.0 || currLocationY == 0.0){
//                    url = "androidamap://route?sourceApplication=amap&dlat="+currLocationY+"&dlon="+currLocationX+"&dname="+"扬州市政府"+"&dev=0&t=1";
//                }else {
//                    url = "androidamap://route?sourceApplication=amap&slat="+currLocationX+"&slon="+currLocationY
//                            +"&dlat="+currLocationY+"&dlon="+currLocationX+"&dname="+"扬州市政府"+"&dev=0&t=1";
//                }
//
//
//
//                Uri uri = Uri.parse(url);
//                //将功能Scheme以URI的方式传入data
//                intent.setData(uri);
//                //启动该页面即可
//                startActivity(intent);
                String act = "android.intent.action.VIEW";
                String dat = "androidamap://keywordNavi?sourceApplication=softname&keyword=" + "扬州市政府" + " &style=2";
                String pkg = "com.autonavi.minimap";
                Intent intent = new Intent(act, Uri.parse(dat));
                intent.setPackage(pkg);
                startActivity(intent);
            }
        });



    }

}