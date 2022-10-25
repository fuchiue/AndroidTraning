package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
        //画面上のパーツ生成
        Button addDataButton = findViewById(R.id.addDataButton);
        EditText dataText = findViewById(R.id.dataText);
        ListView listView = findViewById(R.id.listView);
        //配列作成
        ArrayList<String> dataList = new ArrayList<>();
        //配列セット用のアダプタ宣言
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);

        addDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.add(dataText.getText().toString());
                listView.setAdapter(adapter);
                dataText.setText("");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),EventActivity.class);
                Intent intent2 = new Intent(getApplicationContext(),SubActivity.class);
                if(position%2==1){
                    startActivity(intent);
                }else{
                    startActivity(intent2);
                }
            }
        });



    }
}