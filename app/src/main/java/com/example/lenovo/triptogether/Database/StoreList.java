package com.example.lenovo.triptogether.Database;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;

/**
 * Created by lenovo on 2017/1/13.
 */
public class StoreList extends BmobObject {
    private String StoreName;
    private Number ClassId;
    private Number Distance;
    private String Yijia;
    private Number Score;
    private String Phone;
    private String Msg;

    public String getStoreName(){ return StoreName; }
    public Number getClassId(){ return ClassId; }
    public Number getDistance(){ return Distance; }
    public String getYijia(){ return Yijia; }
    public Number getScore(){ return Score; }
    public String getPhone(){ return Phone; }
    public String getMsg(){ return Msg; }
    //public String classNum[][] ;
    public String content = "xx";
    public JSONArray ar;


    /*查询所有数据
    public void queryData(){

        BmobQuery query = new BmobQuery("StoreList");
        query.findObjectsByTable(new QueryListener<JSONArray>() {
            @Override
            public void done(JSONArray jsonArray, BmobException e) {
                if (e == null){
                    for(int i=0;i<jsonArray.length();i++){
                        try {
                            JSONObject jb = (JSONObject)jsonArray.get(i);
                            StoreName[i] = jb.get("StoreName").toString();
                            ClassId[i] = (Number) jb.get("ClassId");

                            Log.i("bmob",ClassId[i].toString());
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                    //content = jsonArray.toString();
                    /*
                    JSONObject jb = (JSONObject)jsonArray.get(1);
                    Log.i("xx",content);
                    Log.i("xx",jsonArray.toString());
                    ar = jsonArray;
                    Log.i("xx",ar.toString());
                }else{
                    Log.i("bmob","失败"+e.getMessage()+","+e.getErrorCode());
                }
            }
        });

    }
        */
}
