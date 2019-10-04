package com.example.mobile_project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText IDtext;
    EditText PWtext;
    EditText Nametext;
    EditText PNumbertext;
    EditText Addresstext;
    Button Registerbutton2;
    RadioButton AButton;
    RadioButton DButton;
    int checkid = 0; // 기존에 있는 아이디인지 확인
    int checkRadio = 0; //라디오 버튼 값
    boolean checkPW; // 패스워드에 특수문자 확인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        IDtext = (EditText) findViewById(R.id.IDText);
        PWtext = (EditText) findViewById(R.id.PWText);
        Nametext = (EditText) findViewById(R.id.NameText);
        PNumbertext = (EditText) findViewById(R.id.PNumberText);
        Addresstext = (EditText) findViewById(R.id.AddressText);


        //회원가입 버튼 클릭
        Registerbutton2 = (Button) findViewById(R.id.RegisterButton2);
        Registerbutton2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //각각의 입력 String으로 변환
                String IT = IDtext.getText().toString();
                String PT = PWtext.getText().toString();
                String NT = Nametext.getText().toString();
                String PNT = PNumbertext.getText().toString();
                String AT = Addresstext.getText().toString();

                //기존에 있는 아이디인지 확인
                try{
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(openFileInput(IT + ".txt")));
                    Toast.makeText(getApplicationContext(),"중복된 아이디입니다.", Toast.LENGTH_SHORT).show();
                    checkid = 0; //기존에 있는 아이디이면 checkid 변수 0으로 설정
                    br.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    checkid=1; //없으면 1로 설정
                } catch (IOException e) {
                    e.printStackTrace();
                    checkid=1;
                }

                //특수문자 포함되어있는지 확인
                String pattern = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$";
                checkPW = Pattern.matches(pattern,PT);

                //라디오값 체크
                RadioGroup rg = (RadioGroup) findViewById(R.id.RG);
                AButton = (RadioButton) findViewById(R.id.aggreeButton);
                DButton = (RadioButton) findViewById(R.id.disagreeButton);

                switch(rg.getCheckedRadioButtonId())
                {
                    case R.id.aggreeButton:
                        checkRadio = 1;
                        break;

                    case R.id.disagreeButton:
                        checkRadio=0;

                        break;
                }






                //새로가입
                if(checkRadio == 0)
                {
                    Toast.makeText(getApplicationContext(),"개인정보 동의를 하셔야 합니다.", Toast.LENGTH_SHORT).show();
                }
                //비밀번호에 특수문자 확인
                else if (checkPW == false) {
                    Toast.makeText(getApplicationContext(), "비밀번호에 특수문자는 사용 할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
                // 비밀번호 입력여부 확인
                else if (PT.getBytes().length <= 0)
                {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                //기존에 없는 아이디인지 확인
                else if(checkid == 1)
                {
                    try {
                        BufferedWriter bw = new BufferedWriter(
                                new OutputStreamWriter(openFileOutput(IT + ".txt", MODE_PRIVATE)));
                            bw.write(PT); //PW 저장
                            bw.write("\n");
                            bw.write(NT); //이름 저장
                            bw.write("\n");
                            bw.write(PNT); //전화번호 저장
                            bw.write("\n");
                            bw.write(AT); //주소 저장

                            bw.close();
                            Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();
                            finish(); //종료
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });


        //종료버튼
        Button RegisterExitButton = (Button) findViewById(R.id.RegisterExitButton);
        RegisterExitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "회원가입 종료", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

