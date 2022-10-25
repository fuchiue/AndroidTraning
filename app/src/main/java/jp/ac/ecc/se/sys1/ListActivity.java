package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] curreyList={"ドライカレー","カツカレー","チーズカレー","スープカレー"};
        //画面上のパーツを生成
        ListView listView = findViewById(R.id.curryList);

        //配列セット用のアダプタを宣言
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,curreyList);
        //画面上のlistViewにアダプターの配置データを表示
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view;
                Toast.makeText(getApplicationContext(),tv.getText(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),PreferencesActivity.class);
                intent.putExtra("index",tv.getText());
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),Integer.toString(position),Toast.LENGTH_SHORT).show();
                //position:何番目を選んだか


            }
        });
    }
}