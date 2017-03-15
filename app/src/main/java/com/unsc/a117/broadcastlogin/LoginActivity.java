package com.unsc.a117.broadcastlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText accouttext;
    private EditText passwordtext;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*找到关心的空间*/
        accouttext = (EditText) findViewById(R.id.accout);
        passwordtext = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login_button);
        //设定监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accout = accouttext.getText().toString();
                String password = passwordtext.getText().toString();
                //这里我手动设置一个判断 账号unsc 密码117 则为成功 并且转跳活动
                if(accout.equals("unsc") && password.equals("117")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"账户或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
