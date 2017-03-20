package com.example.lenovo.triptogether.homePage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.triptogether.R;

import java.util.ArrayList;

/**
 * Created by dell on 2016/12/15.
 */
public class MerchantAdapter2 extends RecyclerView.Adapter<MerchantAdapter2.ViewHolder>  implements View.OnClickListener{
    private ArrayList<Merchant>merchant_list;
    private LayoutInflater mInflater;
    int[] imageId2 = new int[]{R.mipmap.merchant2_2,R.mipmap.merchant2_3,R.mipmap.merchant2_1,R.mipmap.merchant2_4,R.mipmap.merchant2_5};
    public interface OnMyItemClickListener
    {
        void onItemClick(View view, int i, Merchant item);
    }
    private OnMyItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnMyItemClickListener mOnItemClickListener)
    {
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public MerchantAdapter2(Context context, ArrayList<Merchant> items)
    {
        super();
        merchant_list = items;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = mInflater.inflate(R.layout.entertainment_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        holder.Image = (ImageView)view.findViewById(R.id.merchantType2_image);
        holder.Service = (TextView)view.findViewById(R.id.merchantType2_service);
        holder.Price =(TextView)view.findViewById(R.id.merchantType2_price);
        holder.Address = (TextView)view.findViewById(R.id.merchantType2_address);
        return holder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i)
    {
        viewHolder.Image.setBackgroundResource(merchant_list.get(i).getImageId());
        viewHolder.Service.setText(merchant_list.get(i).getService());
        viewHolder.Price.setText(merchant_list.get(i).getPrice());
        viewHolder.Address.setText(merchant_list.get(i).getAddress());
        if (mOnItemClickListener != null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                // TODO Auto-generated method stub
                mOnItemClickListener.onItemClick(viewHolder.itemView, i,merchant_list.get(i));
            }
            });
        }
    }
    @Override
    public int getItemCount()
    {
        return merchant_list.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView)
        {
            super(itemView);
        }
        ImageView Image;
        TextView Service;
        TextView Price;
        TextView Address;
    }
    @Override
    public void onClick(View view){
        if (mOnItemClickListener != null){
            int i = (int) view.getTag();
            mOnItemClickListener.onItemClick(view,i,merchant_list.get(i));
        }
    }
}
