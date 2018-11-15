package com.example.administrator.testwhat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<TestBean> list;
    private Context context;
    private LayoutInflater inflater;

    public TestAdapter(List<TestBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_view_adapter , viewGroup , false);
        return new TestAdapter_VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TestBean bean = list.get(i);
        if (viewHolder instanceof TestAdapter_VH){
            TestAdapter_VH holder = (TestAdapter_VH) viewHolder;
            Glide.with(context).load(bean.getImg()).into(holder.imageView);
            holder.textView.setText(bean.getTv());
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class TestAdapter_VH extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;

        public TestAdapter_VH(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_img);
            textView = itemView.findViewById(R.id.item_tv);
        }
    }
}
