package com.example.lenovo.triptogether.homePage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.lenovo.triptogether.Database.StoreList;
import com.example.lenovo.triptogether.R;
import com.example.lenovo.triptogether.StoreDetails.store_detail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment {


    //这两个是定位相关@jt
    private ImageButton localizationButton ;
    private EditText localizationText ;
    //merchant type 1
    private ImageView merchant1_image;
    private TextView merchant1_service;
    private TextView merchant1_price;
    private TextView merchant1_address;
    private RecyclerView merchant1_recycler;
    //merchant type 2
    private ImageView merchant2_image;
    private TextView merchant2_service;
    private TextView merchant2_price;
    private TextView merchant2_address;
    private RecyclerView merchant2_recycler;
    //merchant details 1
    int[] imageId1 = new int[]{R.mipmap.merchant1_1,R.mipmap.merchant1_2,R.mipmap.merchant1_3,R.mipmap.merchant1_4,R.mipmap.merchant1_5};
    String[] service1;
    String[] price1 = new String[]{};
    String[] address1 = new String[]{};
    //从数据库提取的暂存
    List<String> service1List =new ArrayList<String>();
    List<String> price1List = new ArrayList<String>();
    List<String> address1List = new ArrayList<String>();
    List<String> score1List = new ArrayList<String>();
    List<String> phone1List = new ArrayList<String>();
    List<String> Msg1List = new ArrayList<String>();
    List<String> ID1List = new ArrayList<String>();
    //merchant details 2
    int[] imageId2 = new int[]{R.mipmap.merchant2_2,R.mipmap.merchant2_1,R.mipmap.merchant2_4,R.mipmap.merchant2_3,R.mipmap.merchant2_5};
    String[] service2 = new String[]{};
    String[] price2 = new String[]{};
    String[] address2 = new String[]{};
    //从数据库提取的暂存
    List<String> service2List =new ArrayList<String>();
    List<String> price2List = new ArrayList<String>();
    List<String> address2List = new ArrayList<String>();
    List<String> score2List = new ArrayList<String>();
    List<String> phone2List = new ArrayList<String>();
    List<String> Msg2List = new ArrayList<String>();
    List<String> ID2List = new ArrayList<String>();


    private  TextView cityName;
    private EditText currentlocal;

    private static final String TAG = "dzt";


    private LocationClient mLocationClient = null;//定义SDK的核心类
    private BDLocationListener myListener = new MyLocationListener();
    public String DYNAMICATION= "android.intent.action.dynamicAction";//动态广播注册
    /*天气预报*/
    private String location;
    private TextView textview_01;

    private String weather =     "无法查询天气请重试";
    final WeatherDynamicReceiver dynamicReceiver = new WeatherDynamicReceiver();
    private Map<String, String> smap;
    private Handler handler = new Handler() {
        //在handler中更新天气UI
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    if(smap.get("text") != "x"){
                        String temp = smap.get("text") + "  " + smap.get("tem") + "℃";
                        weather = temp;
                        /**   * 天气广播
                         */

                        Log.i("weather",weather);

                        //Action
                        Intent intent = new Intent(DYNAMICATION);
                        Bundle bundle = new Bundle();
                        bundle.putString("weather",weather);
                        bundle.putString("cityName",location);
                        intent.putExtras(bundle);
                        getContext().sendBroadcast(intent);
//                getContext().unregisterReceiver(dynamicReceiver);
                    }
                    break;

                default:
                    break;
            }
        }
    };

    //
    private Context mActivity;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity=activity;
    }
    private void UpdateRecycle(){
        //两个Recycle 填充
        service1 = (String[])service1List.toArray(new String[service1List.size()]);
        price1 = (String[])price1List.toArray(new String[price1List.size()]);
        address1 = (String[])address1List.toArray(new String[address1List.size()]);
        service2 = (String[])service2List.toArray(new String[service2List.size()]);
        price2 = (String[])price2List.toArray(new String[price2List.size()]);
        address2 = (String[])address2List.toArray(new String[address2List.size()]);
        Log.i("xx",address2List.size()+"");
        Log.i("xx2",service2.length+"");

        //merchant details 1
        final ArrayList<Merchant> merchantArrayList1 = new ArrayList<Merchant>();
        for(int i=0;i<service1.length;i++)
        {
            Merchant merchant1 = new Merchant(imageId1[i],service1[i],price1[i],address1[i]);
            merchantArrayList1.add(merchant1);
        }
        final MerchantAdapter1 merchantAdapter1 = new MerchantAdapter1(mActivity,merchantArrayList1);
        Log.i("x","xx");
        merchant1_recycler.setAdapter(merchantAdapter1);
        //merchant details 2
        final ArrayList<Merchant> merchantArrayList2 = new ArrayList<Merchant>();
        for(int i=0;i<service2.length;i++)
        {
            Merchant merchant2 = new Merchant(imageId2[i],service2[i],price2[i],address2[i]);
            merchantArrayList2.add(merchant2);
        }
        final MerchantAdapter2 merchantAdapter2 = new MerchantAdapter2(mActivity,merchantArrayList2);
        merchant2_recycler.setAdapter(merchantAdapter2);

        /**
         * Adapte1单击跳转         **/
        merchantAdapter1.setOnItemClickListener(new MerchantAdapter1.OnMyItemClickListener(){
            public void onItemClick(View view,int position,Merchant item){
                Intent intent = new Intent(getContext(),store_detail.class);
                Bundle bundle = new Bundle();
                bundle.putString("storename",item.getService().toString());
                bundle.putString("score",score1List.get(position));
                bundle.putString("phone",phone1List.get(position));
                bundle.putString("msg",Msg1List.get(position));
                bundle.putString("id",ID1List.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        /**
         * Adapte2单击跳转         **/
        merchantAdapter2.setOnItemClickListener(new MerchantAdapter2.OnMyItemClickListener(){
            public void onItemClick(View view,int position,Merchant item){
                Intent intent = new Intent(getContext(),store_detail.class);
                Bundle bundle = new Bundle();
                bundle.putString("storename",item.getService().toString());
                bundle.putString("score",score2List.get(position));
                bundle.putString("phone",phone2List.get(position));
                bundle.putString("msg",Msg2List.get(position));
                bundle.putString("id",ID2List.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
    private Handler new_handler = new Handler(){
        //更新RecycleView
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 0:
                    //更新Recycle
                    UpdateRecycle();
                    break;

                default:
                    break;
            }
        }
    };


    public HomeFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        localizationButton =(ImageButton)view.findViewById(R.id.LocationButton);
        localizationText = (EditText) view.findViewById(R.id.LocationText);

        /**
         * 两个recycle的声明 *
         **/
        merchant1_image = (ImageView)view.findViewById(R.id.merchantType1_image);
        merchant1_service = (TextView)view.findViewById(R.id.merchantType1_service);
        merchant1_price=(TextView)view.findViewById(R.id.merchantType1_price);
        merchant1_address = (TextView)view.findViewById(R.id.merchantType1_address);
        merchant1_recycler =(RecyclerView)view.findViewById(R.id.entertainment_recycler);

        merchant2_image = (ImageView)view.findViewById(R.id.merchantType2_image);
        merchant2_service = (TextView)view.findViewById(R.id.merchantType2_service);
        merchant2_price=(TextView)view.findViewById(R.id.merchantType2_price);
        merchant2_address = (TextView)view.findViewById(R.id.merchantType2_address);
        merchant2_recycler =(RecyclerView)view.findViewById(R.id.life_recycler);
        //layoutmanager1
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        merchant1_recycler.setLayoutManager(layoutManager1);
        //layoutmanager2
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        merchant2_recycler.setLayoutManager(layoutManager2);


        /**
         * 初始化BmodSDK
         * */
        Bmob.initialize(getContext(), "dd9ac090ee7d6b9bf45d47790cbb33c4");
        StoreList storeList = new StoreList();
        final String[] lll = new String[]{};
        final int ld=0;
        BmobQuery query = new BmobQuery("StoreList");
        query.findObjectsByTable(new QueryListener<JSONArray>() {
            @Override
            public void done(JSONArray jsonArray, BmobException e) {
                //先清空List
                service1List.clear();
                price1List.clear();
                address1List.clear();
                score1List.clear();
                phone1List.clear();
                Msg1List.clear();
                ID1List.clear();
                service2List.clear();
                price2List.clear();
                address2List.clear();
                score2List.clear();
                phone2List.clear();
                Msg2List.clear();
                ID2List.clear();

                //从云数据库中读取，再进行初步解析
                if (e == null){
                    for (int i=0; i<jsonArray.length(); i++){
                        try {
                            JSONObject jb = (JSONObject) jsonArray.get(i);
                            Log.i("length",jsonArray.length()+"");
                            Log.i("bmob",jb.toString());
                            String classid = jb.get("ClassId").toString();
                            String name = jb.get("StoreName").toString();
                            String yijia="";
                            if(!jb.has("Yijia"))   yijia ="";
                            else yijia = jb.get("Yijia").toString();
                            String dis="";
                            if(!jb.has("Distance")) dis = "";
                            else {
                                int temp= (int)jb.get("Distance");
                                if (temp > 1000)
                                    dis = ">1km";
                                else if (temp > 500)
                                    dis = ">500m";
                                else dis = "<500m";
                            }
                            String score;
                            if(!jb.has("Score")) score = "";
                            else score = jb.get("Score").toString();
                            String phone;
                            if(!jb.has("Phone")) phone = "";
                            else phone = jb.get("Phone").toString();
                            String msg;
                            if(!jb.has("Msg")) msg = "";
                            else msg = jb.get("Msg").toString();
                            String ID = jb.get("id").toString();

                            //暂存
                            if (classid.equals("1")){
                                service1List.add(name);
                                price1List.add(yijia);
                                address1List.add(dis);
                                score1List.add(score);
                                phone1List.add(phone);
                                Msg1List.add(msg);
                                ID1List.add(ID);
                            }else if (classid.equals("2")){
                                service2List.add(name);
                                price2List.add(yijia);
                                address2List.add(dis);
                                score2List.add(score);
                                phone2List.add(phone);
                                Msg2List.add(msg);
                                ID2List.add(ID);
                            }

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                    //进行更新
                    new_handler.sendEmptyMessage(0);
                }else{
                    Log.i("bmob","失败"+e.getMessage()+","+e.getErrorCode());
                }
            }
        });




        /**
        * 自动定位 *
          **/
        currentlocal = (EditText) view.findViewById(R.id.LocationText);
        cityName = (TextView) view.findViewById(R.id.cityName);
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(currentlocal.getWindowToken(),0);

        //ImageButton btn = (ImageButton) view.findViewById(R.id.btn_request);
        ImageButton CityWeatherSearch = (ImageButton) view.findViewById(R.id.CityWeatherSearch);
        mLocationClient = new LocationClient(getContext()); // 声明LocationClient类
        mLocationClient.registerLocationListener(myListener); // 注册监听函数
        setLocationOption();
        mLocationClient.start();// 开始定位

        /**
         * 城市搜索并查询当前天气 *
         **/

        //textview_01 = (TextView) view.findViewById(R.id.weatherdetail);

        //注册广播
        IntentFilter dynamic_filter = new IntentFilter();
        dynamic_filter.addAction("android.intent.action.dynamicAction");//添加动态广播的Action
        getContext().registerReceiver(dynamicReceiver,dynamic_filter);

        final String path = "https://api.thinkpage.cn/v3/weather/now.json?" +
                "key=kpsgmop8lhpnqvh8&location=";
        CityWeatherSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {//创建子线程进行网络访问的操作
                    public void run() {
                        try {
                            StringBuffer buffer  = new StringBuffer(path);
                            location = currentlocal.getText().toString();
                            buffer.append(URLEncoder.encode(location, "utf-8"));
                            smap = getJSONObject(buffer.toString());
                            handler.sendEmptyMessage(0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });



        return view;//返回视图
    }



    /**
    * GPS定位 *
     **/
    private void setLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setOpenGps(true);
        option.setIsNeedAddress(true);// 返回的定位结果包含地址信息
        option.setCoorType("bd09ll");// 返回的定位结果是百度经纬度,默认值gcj02
        option.setScanSpan(5000);// 设置发起定位请求的间隔时间为5000ms
        option.disableCache(true);// 禁止启用缓存定位

        mLocationClient.setLocOption(option);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mLocationClient.stop();// 停止定位
    }

    public class MyLocationListener implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location == null)
                return;
            StringBuffer sb = new StringBuffer(256);
            StringBuffer sb1 = new StringBuffer(256);
           /* sb.append("当前时间 : ");
            sb.append(location.getTime());*/
            /*sb.append("\n错误码 : ");
            sb.append(location.getLocType());*/
/*            sb.append("\n纬度 : ");
            sb.append(location.getLatitude());
            sb.append("\n经度 : ");
            sb.append(location.getLongitude());
            sb.append("\n半径 : ");
            sb.append(location.getRadius());
            Log.i("dh",sb.toString());*/
            if (location.getLocType() == BDLocation.TypeGpsLocation) {
                sb1.append("\n速度 : ");
                sb1.append(location.getSpeed());
                sb1.append("\n卫星数 : ");
                sb1.append(location.getSatelliteNumber());
            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
                //sb.append("\n地址 : ");
                //sb.append(location.getAddrStr());
                sb.append(location.getCity());
            }
            cityName.setText(sb.toString().substring(0,sb.toString().length()-1));
            //Log.i("ttttttt",sb.toString());
            currentlocal.setHint("请正确输入您所查询的城市");
                  }
}

    /**
     * 天气查询
     * 获取网络中的JSON数据
     * @param path
     * @return
     * @throws Exception
     */
    public static Map<String, String> getJSONObject(String path)
            throws Exception {
        Map<String, String> map = null;
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(15 * 1000);// 单位为毫秒，设置超时时间为5秒
        conn.setRequestMethod("GET");
        map = new HashMap<String, String>();
        if (conn.getResponseCode() == 200) {// 判断请求码是否200，否则为失败
            InputStream is = conn.getInputStream(); // 获取输入流
            byte[] data = readStream(is); // 把输入流转换成字符串组
            String json = new String(data); // 把字符串组转换成字符串
            JSONObject jsonObject = new JSONObject(json);
            JSONObject now = jsonObject.getJSONArray("results").getJSONObject(0).getJSONObject("now");
            Log.i("fdf",now.toString());
            String text = now.getString("text");
            String tem = now.getString("temperature");
            map.put("text", text);
            map.put("tem", tem);
        }
        else map.put("text", "x");

        return map;
    }

    private static byte[] readStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            bout.write(buffer, 0, len);
        }
        bout.close();
        inputStream.close();
        return bout.toByteArray();
    }
}
