package com.example.lenovo.triptogether.usersPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.lenovo.triptogether.usersPage.LoginRegister.LoginActivity;
import com.example.lenovo.triptogether.R;
import com.example.lenovo.triptogether.usersPage.LoginRegister.RegisterActivity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserFragment extends Fragment {

    private String[] item = new String[]{"我的订单","收藏","优惠券","设置"};
    private RelativeLayout personalLayout ;
    private Button login;
    private Button register;

    public static UserFragment newInstance(String param1) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString("agrsl", param1);
        fragment.setArguments(args);
        return fragment;
    }
    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setBackground(R.drawable.personal_bg);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user,container, false);
        Bundle bundle = getArguments();
        String agrsl = bundle.getString("agrsl");
        final Intent intent = getActivity().getIntent();
        //获取activity传来内容
        final Bundle bundle1 = intent.getExtras();
        final TextView username = (TextView) view.findViewById(R.id.personName);
        if (bundle1 == null){
            username.setText("登陆/注册");
        }else{
            String name1 = bundle1.getString("username","defaultname");
            username.setText(name1);
        }

        personalLayout = (RelativeLayout)view.findViewById(R.id.personal_UI);
        login = (Button) view.findViewById(R.id.logIn_LogIn_Button);
        register = (Button) view.findViewById(R.id.register_registration_Button);

        final List<Map<String,Object>> data = new ArrayList<>();
        for (int i=0; i<4; i++){
            Map<String,Object> temp = new LinkedHashMap<>();
            temp.put("Name",item[i]);
            data.add(temp);
        }
        final SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(),data,R.layout.fragment_user_item,
                new String[]{"Name",},
                new int[]{R.id.user_item});
        final ListView listView = (ListView) view.findViewById(R.id.user_lv);
        listView.setAdapter(simpleAdapter);

        /**
         * 登陆点击事件
         **/
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        /**
         * 注册点击事件
         **/
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RegisterActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return view;
    }

    /*@SuppressWarnings("deprecation")
    /*
    private void setBackground(int id)
    {
        int scaleRatio=5;
        int blurRadius = 3;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),id);
        Bitmap scaledBm = Bitmap.createScaledBitmap(bm,bm.getWidth()/scaleRatio,bm.getHeight()/scaleRatio,false);
        final Bitmap blurBmp = BlurUtil.fastblur(this, scaledBm, blurRadius);
        final Drawable newBitmapDrawable = new BitmapDrawable(blurBmp);
        personalLayout.post(new Runnable()  //µ÷ÓÃUIÏß³Ì
        {
            @Override
            public void run()
            {
                personalLayout.setBackgroundDrawable(newBitmapDrawable);//ÉèÖÃ±³¾°
            }
        });
    }*/

}
