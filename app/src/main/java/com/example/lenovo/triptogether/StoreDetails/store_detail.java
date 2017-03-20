package com.example.lenovo.triptogether.StoreDetails;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.example.lenovo.triptogether.BottomNavigationBarActivity.BottomNavigationBarDemoActivity;
import com.example.lenovo.triptogether.R;
import com.example.lenovo.triptogether.chatPage.ChatContent;

public class store_detail extends AppCompatActivity {

    private MapView mapView = null;     // 百度地图控件
    private BaiduMap bdMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
//        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_store_detail);
        final TextView detailsTitle = (TextView) findViewById(R.id.detailsTitle);
        final TextView detailScore = (TextView) findViewById(R.id.detailsScore);
        final TextView detailPhone = (TextView) findViewById(R.id.phone_number);
        final TextView detailMsg = (TextView) findViewById(R.id.open_time);
        final ImageView titleImg = (ImageView) findViewById(R.id.store_image);
        final ImageButton chatbutton  = (ImageButton) findViewById(R.id.detailsMessageButton);
        final ImageButton backbutton = (ImageButton) findViewById(R.id.detailsBackButton);
        final Intent intent = getIntent();
        //获取activity传来内容
        final Bundle bundle = intent.getExtras();
        detailsTitle.setText(bundle.getString("storename"));
        if(bundle.getString("score")!=null && !bundle.getString("score").equals(""))
            detailScore.setText(bundle.getString("score")+" 分");
        if(bundle.getString("phone")!=null && !bundle.getString("phone").equals(""))
            detailPhone.setText(bundle.getString("phone"));
        Log.i("wht",bundle.getString("phone"));
        if(bundle.getString("msg")!=null && !bundle.getString("msg").equals(""))
            detailMsg.setText(bundle.getString("msg"));
        //设置头图
        int temp = Integer.parseInt(bundle.getString("id"));
        switch (temp){
            case 1: titleImg.setImageResource(R.drawable.big_1); break;
            case 2: titleImg.setImageResource(R.drawable.big_2); break;
            case 3: titleImg.setImageResource(R.drawable.big_3); break;
            case 4: titleImg.setImageResource(R.drawable.big_4); break;
            case 5: titleImg.setImageResource(R.drawable.big_5); break;
            case 6: titleImg.setImageResource(R.drawable.big_6); break;
            case 7: titleImg.setImageResource(R.drawable.big_7); break;
            case 8: titleImg.setImageResource(R.drawable.big_8); break;
            case 9: titleImg.setImageResource(R.drawable.big_9); break;
            case 10: titleImg.setImageResource(R.drawable.big_10); break;
            default: break;
        }
        titleImg.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //返回
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), store_detail.class);
                startActivity(intent1);
                finish();
            }
        });
        //消息点击事件
        chatbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplication(), ChatContent.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Name",bundle.getString("storename"));
                intent1.putExtras(bundle1);
                startActivity(intent1);
                finish();
            }
        });
        init();
        GeoCode();
    }




    private void init() {
        mapView = (MapView) findViewById(R.id.bmapView);
        bdMap = mapView.getMap();
        bdMap.setMapStatus(MapStatusUpdateFactory.zoomTo(15));

        // 去掉百度地图的logo
        View child = mapView.getChildAt(1);
        if (child != null && (child instanceof ImageView || child instanceof ZoomControls)) {
            child.setVisibility(View.INVISIBLE);
        }

        // 不显示缩放按钮和比例尺
        mapView.showScaleControl(false);
        mapView.showZoomControls(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        mapView.onDestroy();
        mapView = null;
        super.onDestroy();
    }

    // 地理信息的编码和反编码
    private void GeoCode() {
        // 创建地理编码索引实例
        final GeoCoder geoCoder = GeoCoder.newInstance();
        // 设置地理编码的监听
        OnGetGeoCoderResultListener listener = new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                if (geoCodeResult.error == SearchResult.ERRORNO.PERMISSION_UNFINISHED){
                    geoCoder.geocode(new GeoCodeOption().city("广州").address("番禺区大石镇迎宾路长隆欢乐世界"));
                }

                if (geoCodeResult == null || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                } else {
                    // 获取地理编码结果
                    float latitude = (float) geoCodeResult.getLocation().latitude;
                    float longitude = (float) geoCodeResult.getLocation().longitude;

                    LatLng point = new LatLng(latitude, longitude);

                    bdMap.clear();
                    // 加载自定义Marker
                    View popMarker = View.inflate(store_detail.this, R.layout.pop, null);
                    Bitmap bitmap = getViewBitmap(popMarker);
                    BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);
                    OverlayOptions option = new MarkerOptions()
                            .position(new LatLng(latitude + 0.01, longitude))
                            .icon(bitmapDescriptor);

                    MapStatusUpdate msu = MapStatusUpdateFactory.newLatLng(point);
                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(point);// 设置圆心坐标
                    circleOptions.fillColor(Color.argb(110,87,163,189));// 圆的填充颜色
                    circleOptions.radius(700);// 设置半径
                    circleOptions.stroke(new Stroke(4, Color.argb(255,78,127,144)));// 设置边框

                    bdMap.addOverlay(circleOptions);
                    bdMap.addOverlay(option);
                    bdMap.animateMapStatus(msu);

                }
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                }
            }
        };

        geoCoder.setOnGetGeoCodeResultListener(listener);
        geoCoder.geocode(new GeoCodeOption().city("广州").address("番禺区大石镇迎宾路长隆欢乐世界"));
    }


    // 把View转换成Bitmap
    private Bitmap getViewBitmap(View addViewContent) {
        addViewContent.setDrawingCacheEnabled(true);
        addViewContent.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        addViewContent.layout(0, 0,
                addViewContent.getMeasuredWidth(),
                addViewContent.getMeasuredHeight());
        addViewContent.buildDrawingCache();
        Bitmap cacheBitmap = addViewContent.getDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

        return bitmap;
    }
}
