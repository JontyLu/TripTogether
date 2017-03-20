package com.example.lenovo.triptogether.usersPage.LoginRegister;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;

/**
 * Created by dell on 2016/10/13.
 */
public class DynamicReceiver extends BroadcastReceiver{
    private static final String DYNAMICATION = "com.example.projectforjourney.dynamicreceiver";
    @Override
    public void onReceive(Context context, Intent intent){
        if(intent.getAction().equals(DYNAMICATION)){
            //获取activity传来内容
            Bundle bundle = intent.getExtras();
            //建立一个notification
            Notification.Builder builder = new Notification.Builder(context);
            //定义notification控制器
            NotificationManager notificationManager =
                    (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
            //定义大Icon
            Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon);
            //notification相关内容设定
            builder.setContentTitle("动态广播")
                    .setContentText(bundle.getString("message"))
                    .setTicker("您有一条新信息")
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.icon)
                    .setAutoCancel(true);
            //点击通知，跳转到主页面
            builder.setContentIntent
                    (PendingIntent.getActivity(context,0,new Intent(context,BottomNavigationBarDemoActivity.class),0));
            //显示通知
            Notification notify = builder.build();
            notificationManager.notify(0,notify);
        }
    }
}
