package com.example.mobile_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    String fname;
    String fpw;
    EditText IDview;
    EditText PWview;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //로그인클릭
        Button LoginButton = (Button) findViewById(R.id.LoginButton);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iD와 PW값 String으로 변경
                IDview = (EditText) findViewById(R.id.IDView);
                PWview = (EditText) findViewById(R.id.PWView);
                fname = IDview.getText().toString()+".txt";
                fpw = PWview.getText().toString();

                //파일 열기
                File file = new File(getFilesDir(),fname);
                try{
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(openFileInput(fname)));
                    String check = br.readLine();

                    //비밀번호 확인
                    if(check.equals(fpw))
                    {
                        Toast.makeText(getApplicationContext(),"로그인 성공!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Calculator.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                    br.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"회원정보가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"회원정보가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                }




            }
        }
        );

        //회원가입 클릭
        Button RegisterButton = (Button) findViewById(R.id.RegisterButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"회원가입 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
               Intent intent2 = new Intent(getApplicationContext(),Register.class);
               startActivity(intent2);
           }
        }
        );

        //종료 클릭
        Button exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
          @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"종료합니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        });
    }

}
