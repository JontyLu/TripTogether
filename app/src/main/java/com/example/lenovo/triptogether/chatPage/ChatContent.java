package com.example.lenovo.triptogether.chatPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;

public class ChatContent extends AppCompatActivity {

    private TextView chatName ;
    private Button back_button;
    private TextView chatDistance;
    private ImageView merchant_head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chatting_layout);

        back_button = (Button) findViewById(R.id.back_button);
        chatName = (TextView) findViewById(R.id.chatName);
        chatDistance = (TextView) findViewById(R.id.chatDistance);
        merchant_head = (ImageView)findViewById(R.id.merchant_head);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String name = bundle.getString("Name","default name");
            String distance = bundle.getString("Distance","default distance");
            int title = bundle.getInt("mailImage",R.drawable.cart_round);
            chatName.setText(name);
            chatDistance.setText(distance);
            merchant_head.setBackgroundResource(title);


        }



        /*返回*/
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),BottomNavigationBarDemoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",1);

                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }
}
