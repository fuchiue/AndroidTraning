package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub);
        setContentView(R.layout.activity_const);
        TextView nameLavel = findViewById(R.id.nameLable);
        nameLavel.setText("Name");

        EditText nameText2 = findViewById(R.id.nameText2);

        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                nameText2.setText("");
            }
        });
        Button sendButton = findViewById(R.id.sendButton);
        Button confirmButton = findViewById(R.id.confirmButton);
        sendButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        setTitle("Button Clicked");
        Intent intent = new Intent(this,EventActivity.class);
        switch (view.getId()){
            case R.id.sendButton:
                //intent.putExtra("age",19);
                Toast.makeText(this,"送信クリック",Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;
            case R.id.confirmButton:
                Toast.makeText(this,"確認クリック",Toast.LENGTH_SHORT).show();
        }
    }
}

