package com.unsc.a117.broadcastlogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

    private EditText accouttext;
    private EditText passwordtext;
    private Button login;

    private CheckBox rememberPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //记住账户密码 找到关心的控件
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);


        /*找到关心的控件*/
        accouttext = (EditText) findViewById(R.id.accout);
        passwordtext = (EditText)findViewById(R.id.password);

        //判断是否记住密码
        boolean isRemember = pref.getBoolean("remember_password",false);
        if(isRemember){
            //两个String对象   pref.getString 键值设置account和password 后面的 "" 用于初始化
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            //把记录下来的账户和密码引入账号密码输入框内
            accouttext.setText(account);
            passwordtext.setText(password);
            //rememberPass是CheckBox 勾选框
            rememberPass.setChecked(true);
        }

        //找到按钮
        login = (Button)findViewById(R.id.login_button);
        //设定监听
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accout = accouttext.getText().toString();
                String password = passwordtext.getText().toString();
                //这里我手动设置一个判断 账号unsc 密码117 则为成功 并且转跳活动
                if(accout.equals("unsc") && password.equals("117")){
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",accout);
                        editor.putString("password",password);

                    }else{
                        editor.clear();
                    }
                    editor.apply();

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
