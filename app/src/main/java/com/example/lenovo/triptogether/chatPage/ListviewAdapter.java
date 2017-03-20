package com.example.lenovo.triptogether.chatPage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.triptogether.R;

import java.util.List;
import java.util.Map;

public class ListviewAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ViewHolder holder;
    private int index = 0;
    private Context c;
    private String string[];
    private Integer[] GuiderImage = new Integer[]{R.mipmap.tourist1,R.mipmap.tourist2,R.mipmap.tourist3,
            R.mipmap.tourist4,R.mipmap.tourist5,R.mipmap.tourist6};
    private List<Map<String,Object>> data;

    public ListviewAdapter(Context c, List<Map<String,Object>> data){
        super();
        this.c = c;
        this.data = data;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        holder = new ViewHolder();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.fragment_chat_item, null);
            holder.titleRight = (TextView)convertView.findViewById(R.id.GuiderNameRight);
            holder.titleLeft = (TextView)convertView.findViewById(R.id.GuiderNameLeft);
            holder.ImageLeft = (ImageView)convertView.findViewById(R.id.GuiderImage_left);
            holder.ImageRight = (ImageView)convertView.findViewById(R.id.GuiderImage_right);
            holder.DetailsLeft = (TextView)convertView.findViewById(R.id.GuiderDetailsLeft);
            holder.DetailsRight = (TextView)convertView.findViewById(R.id.GuiderDetailsRight);
            holder.DistanceLeft = (TextView)convertView.findViewById(R.id.GuiderDistanceLeft);
            holder.DistanceRight = (TextView)convertView.findViewById(R.id.GuiderDistanceRight);
            holder.iv_left = (RelativeLayout)convertView.findViewById(R.id.GuiderLeft);
            holder.iv_right = (RelativeLayout)convertView.findViewById(R.id.GuiderRight);
            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();
//        holder.title.setText(string[position]);
        holder.titleLeft.setText(data.get(position).get("Name").toString());
        holder.titleRight.setText(data.get(position).get("Name").toString());
        holder.ImageLeft.setBackgroundResource(GuiderImage[position]);
        holder.ImageRight.setBackgroundResource(GuiderImage[position]);
        holder.DetailsLeft.setText(data.get(position).get("Details").toString());
        holder.DetailsRight.setText(data.get(position).get("Details").toString());
      holder.DistanceLeft.setText(data.get(position).get("Distance").toString());
        holder.DistanceRight.setText(data.get(position).get("Distance").toString());



        if(position % 2 == 0){
            holder.iv_left.setVisibility(View.GONE);
            holder.iv_right.setVisibility(View.VISIBLE);
        }
        else{
            holder.iv_left.setVisibility(View.VISIBLE);
            holder.iv_right.setVisibility(View.GONE);
        }
        return convertView;
    }

    public class ViewHolder{
        public ImageView ImageLeft;
        public ImageView ImageRight;
        public TextView titleLeft;
        public TextView titleRight;
        public TextView DetailsLeft;
        public TextView DetailsRight;
        public TextView DistanceLeft;
        public TextView DistanceRight;
        public RelativeLayout iv_left;
        public RelativeLayout iv_right;
    }

}
