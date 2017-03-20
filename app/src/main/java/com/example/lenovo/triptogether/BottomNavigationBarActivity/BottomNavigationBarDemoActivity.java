package com.example.lenovo.triptogether.BottomNavigationBarActivity;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.lenovo.triptogether.R;
import com.example.lenovo.triptogether.chatPage.ChatFragment;
import com.example.lenovo.triptogether.homePage.HomeFragment;
import com.example.lenovo.triptogether.mailPage.MailFragment;
import com.example.lenovo.triptogether.usersPage.UserFragment;

import java.util.ArrayList;

public class BottomNavigationBarDemoActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private HomeFragment homeFragment;
    private UserFragment userFragment;
    private MailFragment mailFragment;
    private ChatFragment chatFragment;
    private ArrayList<Fragment> fragments;
    BottomNavigationBar bottomNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomnavigationbardemo);
        initView();
        fragments = fragmentsFunction();
    }

    private ArrayList<Fragment> fragmentsFunction(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(HomeFragment.newInstance("商家"));
        fragments.add(ChatFragment.newInstance("旅伴"));
        fragments.add(MailFragment.newInstance("消息"));
        fragments.add(UserFragment.newInstance("个人"));
        return fragments;
    }
    /** 导航栏**/
    private void initView(){
        //得到BottomNavigationBar控件
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        //设置模式
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //设置BottomNavigationBar背景风格
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        //按钮的ico和文字设置
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.shop, "商家").setActiveColorResource(R.color.colorApp))
                .addItem(new BottomNavigationItem(R.mipmap.heart, "旅伴").setActiveColorResource(R.color.colorApp))
                .addItem(new BottomNavigationItem(R.mipmap.speach_, "消息").setActiveColorResource(R.color.colorApp))
                .addItem(new BottomNavigationItem(R.mipmap.user, "个人").setActiveColorResource(R.color.colorApp));



        bottomNavigationBar
                .setActiveColor(R.color.colorAccent)
                .setInActiveColor(R.color.white)
                .setBarBackgroundColor("#ffffff")
                .setTabSelectedListener(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            int intentposition = bundle.getInt("position",0);
            Log.i("tag", String.valueOf(intentposition));
            if (intentposition == 1){
                bottomNavigationBar.setFirstSelectedPosition(1)//默认选择索引为0的菜单为主页面;
                        .initialise();//对导航进行重绘
                setSecondFragment();

            }
            else if (intentposition == 2){

            }else if (intentposition == 3){
                bottomNavigationBar.setFirstSelectedPosition(3)//默认选择索引为0的菜单为主页面;
                        .initialise();//对导航进行重绘
                setFourthFragment();
            }

        }else{
            bottomNavigationBar.setFirstSelectedPosition(0)//默认选择索引为0的菜单为主页面
            .initialise();//对导航进行重绘
            setDefaultFragment();
        }


    }
    /** * 设置默认的 */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance("商家");
        transaction.replace(R.id.layFrame, homeFragment);
        transaction.commit();
    }
    /** * 旅伴界面 */
    private void setSecondFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        chatFragment = ChatFragment.newInstance("旅伴");
        transaction.replace(R.id.layFrame, chatFragment);
        transaction.commit();
    }
    /** * 消息界面 */
    private void setThirdFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mailFragment = MailFragment.newInstance("旅伴");
        transaction.replace(R.id.layFrame, mailFragment);
        transaction.commit();
    }
    /** * 跳转个人界面 */
    private void setFourthFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        userFragment = UserFragment.newInstance("个人");
        transaction.replace(R.id.layFrame, userFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragments.get(position);
        ft.replace(R.id.layFrame,fragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
