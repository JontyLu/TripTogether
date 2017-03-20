package com.example.lenovo.triptogether.homePage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;

/**
 * Created by lenovo on 2016/12/19.
 */
public class WeatherDynamicReceiver extends BroadcastReceiver {
    private Bitmap bm;
    public String DYNAMICATION = "android.intent.action.dynamicAction";
    @Override
    public  void onReceive(Context context, Intent intent) {
        Log.i("111","52252");
        if (intent.getAction().equals(DYNAMICATION)){



            //获取activity传来内容
            Bundle bundle = intent.getExtras();
            String weather = bundle.getString("weather");
            String cityName = bundle.getString("cityName");
            //建立一个notification
            Notification.Builder builder = new Notification.Builder(context);
            //定义notification控制器
            NotificationManager manager =
                    (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
            //获取大图标的来源
            bm = BitmapFactory.decodeResource(context.getResources(),R.mipmap.apple);
            builder.setContentTitle(cityName)//通知
                    .setContentText(weather)//通知内容
                    .setTicker("您有一条新消息")
                    .setLargeIcon(bm)
                    .setSmallIcon(R.mipmap.as)
                    //发出的通知时间,不过好像没啥卵用，系统会自动显示
                    .setWhen(System.currentTimeMillis())
                    //点击取消
                    .setAutoCancel(true);
            //点击通知，跳转到主页面
            builder.setContentIntent
                    (PendingIntent.getActivity(context,0,new Intent(context,BottomNavigationBarDemoActivity.class),0));
            Notification notify = builder.build();
            //发起通知
            manager.notify(0,notify);
        }
        else{
            Toast.makeText(context, "你没接受到广播啊少年", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
