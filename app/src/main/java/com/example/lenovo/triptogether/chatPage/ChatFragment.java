package com.example.lenovo.triptogether.chatPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lenovo.triptogether.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ChatFragment extends Fragment {

    private ListviewAdapter adapter;
    private Integer[] GuiderImage = new Integer[]{R.mipmap.as,R.mipmap.qw,R.mipmap.er,
    R.mipmap.ty,R.mipmap.df,R.mipmap.ui};
    private List<Integer> GuiderImageList = new LinkedList<>();
    private String[] name = new String[]{"David","JT","Craze","肖姗姗","李成","旅游达人"};
    private List<String> name_List = new LinkedList<>();
    private String[] GuiderDetails = new String[]{"爱旅游，萌妹纸，带你玩遍广州景点","老城区的常客",
            "一个人的旅游需要一个人的陪伴","爱旅游，背包客","带你了解广交会","吃遍广州，走遍小巷"};
    private List<String> Details_List = new LinkedList<>();
    private String[] distance = new String[]{"<100m",">100m",">1千米","=800m","=3.2km","=300m"};
    private List<String> distance_List = new LinkedList<>();

    public ChatFragment() {
        // Required empty public constructor
    }

    public static ChatFragment newInstance(String param1) {
        ChatFragment fragment = new ChatFragment();
        Bundle args = new Bundle();
        args.putString("agrsl", param1);
        fragment.setArguments(args);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat,container, false);
        final List<Map<String,Object>> data = new ArrayList<>();
        for (int i=0; i<6; i++){
            Map<String,Object> temp = new LinkedHashMap<>();
            temp.put("Image",GuiderImage[i]);
            temp.put("Name",name[i]);
            temp.put("Details",GuiderDetails[i]);
            temp.put("Distance",distance[i]);
            data.add(temp);


        }
        //final SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(),data,R.layout.fragment_chat_item,
        //        new String[]{"Image","Name","Details","Distance"},
        //       new int[]{R.id.GuiderImage,R.id.GuiderName,R.id.GuiderDetails,R.id.GuiderDistance});
        final ListView listView = (ListView) view.findViewById(R.id.lv);
        //listView.setSelection();
        adapter = new ListviewAdapter(getActivity(),data);
        listView.setAdapter(adapter);

        /* 单击跳转 */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(getActivity(),ChatContent.class);
                Bundle bundle = new Bundle();
                bundle.putString("Name",name[i]);
                bundle.putString("Distance",distance[i]);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().finish();

            }
        });
        return view;
    }

}
