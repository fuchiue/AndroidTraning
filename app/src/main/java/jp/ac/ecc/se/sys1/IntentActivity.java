package jp.ac.ecc.se.sys1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentActivity extends AppCompatActivity {
    //カメラ起動のリクエストコード宣言
    final int CAMERA_RESULT = 100;
    //画像変数に画像情報を格納するURI変数を宣言する.
    Uri imageUri;
    boolean putFlag=false;

    //画像表示
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //画像表示領域の宣言
        ImageView cameraImage = findViewById(R.id.cameraImage);
        if(requestCode == CAMERA_RESULT && resultCode == RESULT_OK){
            //Bitmap bitmap = data.getParcelableExtra("data");
            //cameraImage.setImageBitmap(bitmap);
            //imageUriを表示
            cameraImage.setImageURI(imageUri);
            putFlag=true;
        }
        FloatingActionButton confirmFab = findViewById(R.id.confirmFab);
        confirmFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (putFlag) {
                    Intent intent = new Intent(getApplicationContext(), ImageActivity.class);
                    intent.putExtra("image", imageUri);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //検索バーとボタンを宣言
        EditText searchText = findViewById(R.id.searchText);
        Button searchButton = findViewById(R.id.searchButton);
        //カメラ起動ボタンを宣言;
        Button cameraButton = findViewById(R.id.cameraButton);
        //viewボタン宣言
        //


        //searchButtonが押されたときWeb検索
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,query);

                startActivity(intent);
            }
        });

        //cameraButtonが押されたときカメラを起動させる
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = "Traning"+timestamp+"_.jpg";
                //パラメータ設定
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.TITLE,fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");

                //画像情報のURIを生成する
                imageUri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);

                startActivityForResult(intent,CAMERA_RESULT);

            }
        });


    }
}