package com.example.lenovo.triptogether.mailPage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.triptogether.R;
import com.loopeer.itemtouchhelperextension.ItemTouchHelperExtension;

import java.util.ArrayList;
import java.util.List;

public class MailFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    private String[] contacter = new String[]{"长隆水上乐园","老王","JT","33","Craze","李成","害羞的猫",
    "Mew","阿祖","芭蕾鸡","乘风的kikyo","EagleWill","我随便打的","John","Kenny","大胸","小腿",
    "Josua","Joan仔","蝙蝠侠"};
    private String[] ChatContext = new String[] {"进门左拐","您好","你现在方便吗？","我是33！您好！","在广州塔的最高层有跳楼机可以玩耍","好的，希望下次可以再次找我",
            "我的微信是Craze", "我是来自广州海珠的Mew，很高兴为您导航","阿bbvbc祖",
            "芭awrgdhd蕾鸡","乘风ssss的kikyo","EaglesssssWill","我随便sssssss打的","Jodadahn","Kennbvnny","大gdfgfd胸","小nbv腿",
            "Josunbvnvbna","Joanvbcbbbnnb仔","nbnbvn蝙蝠侠"};
    private int[] contacterImage = new int[]{R.mipmap.as,R.mipmap.qw,R.mipmap.er,R.mipmap.ty,R.mipmap.ui,R.mipmap.df};
    public ItemTouchHelperExtension mItemTouchHelper;
    public ItemTouchHelperExtension.Callback mCallback;

    public static MailFragment newInstance(String param1) {
        MailFragment fragment = new MailFragment();
        Bundle args = new Bundle();
        args.putString("agrsl", param1);
        fragment.setArguments(args);
        return fragment;
    }


    public MailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mail, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new MainRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mAdapter.updateData(createTestDatas());
        mCallback = new ItemTouchHelperCallback();
        mItemTouchHelper = new ItemTouchHelperExtension(mCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
        mAdapter.setItemTouchHelperExtension(mItemTouchHelper);
        return view;
}

    private List<TestModel> createTestDatas () {
        List<TestModel> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            TestModel testModel = new TestModel(contacterImage[i],i, contacter[i].toString(),ChatContext[i].toString());
            result.add(testModel);
        }
        return result;
    }

/*    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }
*/
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId() == R.id.action_refresh) {
            mAdapter.updateData(createTestDatas());
        }
        return super.onOptionsItemSelected(item);
    }

}

