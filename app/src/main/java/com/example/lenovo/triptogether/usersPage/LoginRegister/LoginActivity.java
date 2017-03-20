package com.example.lenovo.triptogether.usersPage.LoginRegister;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;

/**
 * Created by dell on 2016/12/5.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String DYNAMICATION = "com.example.projectforjourney.dynamicreceiver";
    DynamicReceiver dynamicReceiver=new DynamicReceiver();
    private DataBase dataBase = new DataBase(LoginActivity.this);
    private EditText login_username,login_password;
    private Button login_Button,cancel_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login_username = (EditText) findViewById(R.id.logIn_username_text);
        login_password = (EditText) findViewById(R.id.logIn_password_text);
        login_Button = (Button) findViewById(R.id.logIn_LogIn_Button);
        cancel_Button = (Button) findViewById(R.id.logIn_cancel_Button);

        final Intent mainIntent = new Intent(LoginActivity.this, BottomNavigationBarDemoActivity.class);
        cancel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplication(),BottomNavigationBarDemoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",3);

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!dataBase.queryNameDuplicate(login_username.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "用户不存在，请先注册吧", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.isEmpty(login_username.getText().toString())) {
                        Toast.makeText(LoginActivity.this, "用户名不能为空呦", Toast.LENGTH_SHORT).show();
                    } else {

                        String correctPassword = dataBase.queryPasswordByUsername(login_username.getText().toString());
                        if (TextUtils.equals(login_password.getText().toString(), correctPassword)) {

                            //register
                            IntentFilter dynamicFilter = new IntentFilter();
                            dynamicFilter.addAction(DYNAMICATION);
                            registerReceiver(dynamicReceiver, dynamicFilter);
                            //bundle
                            Bundle bundle = new Bundle();
                            String message = "Hello," + login_username.getText().toString() + "!";
                            bundle.putString("message", message);
                            Bundle namebundle = new Bundle();
                            namebundle.putString("username", login_username.getText().toString());
                            namebundle.putInt("position",3);
                            //broadcast
                            Intent sendIntent = new Intent(DYNAMICATION);
                            sendIntent.putExtras(bundle);
                            sendBroadcast(sendIntent);
                            //return name to personal UI
                            mainIntent.putExtras(namebundle);
                           // bundle.putInt("position",3);
                            startActivity(mainIntent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "密码不正确哦", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }

}
