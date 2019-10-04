package com.example.mobile_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        //종료버튼
        Button calExitButton = (Button) findViewById(R.id.CalExitButton);
        calExitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"계산기를 종료합니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
    //각각의 라디오 버튼 눌렀을때 실행할 함수
    public void addClick(View v){
        EditText number1 =  (EditText) findViewById(R.id.number1);
        EditText number2 =  (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1+n2));
    }
    public void subClick(View v){
        EditText number1 =  (EditText) findViewById(R.id.number1);
        EditText number2 =  (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1-n2));
    }
    public void mulClick(View v){
        EditText number1 =  (EditText) findViewById(R.id.number1);
        EditText number2 =  (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1*n2));
    }
    public void divClick(View v){
        EditText number1 =  (EditText) findViewById(R.id.number1);
        EditText number2 =  (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        int n1 = Integer.parseInt(number1.getText().toString());
        int n2 = Integer.parseInt(number2.getText().toString());
        result.setText(Integer.toString(n1/n2));
    }
}
