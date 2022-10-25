package jp.ac.ecc.se.sys1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{
    static int check =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enpty_activity);

        Intent intent = getIntent();
        int age = intent.getIntExtra("age",25);
        Toast.makeText(this, "name:" + "age"+age, Toast.LENGTH_SHORT).show();


        //コンテンツの宣言
        EditText nameText_enp = findViewById(R.id.nameText_enp);
        EditText password_enp = findViewById(R.id.password_enp);
        Button nameClear_enp = findViewById(R.id.nameClear_enp);
        Button passClear_enp = findViewById(R.id.passClear_enp);
        CheckBox checkBox10_enp = findViewById(R.id.checkBox10_enp);
        CheckBox checkBox20_enp = findViewById(R.id.checkBox20_enp);
        CheckBox checkBox30_enp = findViewById(R.id.checkBox30_enp);
        RadioButton radio_enp = findViewById(R.id.radio_enp);
        RadioButton radio2_enp = findViewById(R.id.radio2_enp);
        Button kakunin_enp = findViewById(R.id.kakunin_enp);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        kakunin_enp.setOnClickListener(this);
        nameClear_enp.setOnClickListener(this);
        passClear_enp.setOnClickListener(this);

        kakunin_enp.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                check=1;
                if(radio_enp.isChecked()==true){
                    Toast.makeText(getApplicationContext(),"性別："+R.string.man_rb,Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"性別："+R.string.woman_rb,Toast.LENGTH_SHORT).show();
                }
                finish();
                return false;
            }
        });

        passClear_enp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                setTitle(password_enp.getText());
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        EditText nameText_enp = findViewById(R.id.nameText_enp);
        EditText password_enp = findViewById(R.id.password_enp);
        Button nameClear_enp = findViewById(R.id.nameClear_enp);
        Button passClear_enp = findViewById(R.id.passClear_enp);
        CheckBox checkBox10_enp = findViewById(R.id.checkBox10_enp);
        CheckBox checkBox20_enp = findViewById(R.id.checkBox20_enp);
        CheckBox checkBox30_enp = findViewById(R.id.checkBox30_enp);
        RadioButton radio_enp = findViewById(R.id.radio_enp);
        RadioButton radio2_enp = findViewById(R.id.radio2_enp);
        Button kakunin_enp = findViewById(R.id.kakunin_enp);
        switch(view.getId()){
            case R.id.nameClear_enp:
                nameText_enp.setText("");break;
            case R.id.passClear_enp:
                password_enp.setText("");
                setTitle(R.string.app_name);break;
            case R.id.kakunin_enp:
                if(check==0) {
                Toast.makeText(this, "name:" + nameText_enp.getText(), Toast.LENGTH_SHORT).show();
            }check=0;
        }
    }
}