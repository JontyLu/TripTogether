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
public class RegisterActivity extends AppCompatActivity {
    private static final String DYNAMICATION = "com.example.projectforjourney.dynamicreceiver";
    DynamicReceiver dynamicReceiver=new DynamicReceiver();
    private DataBase dataBase = new DataBase(RegisterActivity.this);
    private EditText register_username,register_password,register_confirm_password;
    private Button register_Button,cancel_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        register_username=(EditText)findViewById(R.id.register_username_text);
        register_password=(EditText)findViewById(R.id.register_password_text);
        register_confirm_password=(EditText)findViewById(R.id.register_passwordconfirm_text);
        register_Button=(Button)findViewById(R.id.register_registration_Button);
        cancel_Button=(Button)findViewById(R.id.register_cancel_Button);
        final Intent mainIntent=new Intent(RegisterActivity.this,BottomNavigationBarDemoActivity.class);
        cancel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),BottomNavigationBarDemoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",3);

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dataBase.queryNameDuplicate(register_username.getText().toString()))
                {
                    Toast.makeText(RegisterActivity.this,"名字已经有人使用了，换一个吧", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (TextUtils.isEmpty(register_username.getText().toString())) {
                        Toast.makeText(RegisterActivity.this, "名字不能为空呦", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(TextUtils.equals(register_password.getText().toString(),register_confirm_password.getText().toString()))
                            {
                                dataBase.insert(register_username.getText().toString(),
                                register_password.getText().toString());
                                IntentFilter dynamicFilter = new IntentFilter();
                                dynamicFilter.addAction(DYNAMICATION);
                                registerReceiver(dynamicReceiver, dynamicFilter);
                                //bundle
                                Bundle bundle = new Bundle();
                                String message = "Welcome," + register_username.getText().toString() + "!";
                                bundle.putString("message", message);
                                Bundle namebundle = new Bundle();
                                namebundle.putString("username", register_username.getText().toString());
                                namebundle.putInt("position",3);
                                //broadcast
                                Intent sendIntent = new Intent(DYNAMICATION);
                                sendIntent.putExtras(bundle);
                                sendBroadcast(sendIntent);
                                //return name to personal UI
                                mainIntent.putExtras(namebundle);
                                startActivity(mainIntent);
                                finish();
                            }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "密码不匹配", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
}
