package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        Intent intent = getIntent();
        String index = intent.getStringExtra("index");
        setTitle(index);
        //このアプリの情報を保存するファイルを生成
        SharedPreferences pref = getPreferences(Context.MODE_PRIVATE);

        //
        EditText memoText = findViewById(R.id.memoText);
        Button saveButton = findViewById(R.id.saveButoon);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button deleteButton =findViewById(R.id.deleteButton);

        String memoSt = pref.getString(index,null);
        memoText.setText(memoSt);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(index,null);
                editor.apply();
                String memoSt = pref.getString(index,null);
                memoText.setText(memoSt);
                Toast.makeText(getApplicationContext(),"削除しました",Toast.LENGTH_SHORT).show();

            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(index,memoText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(),"保存しました",Toast.LENGTH_SHORT).show();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"終了します",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


}