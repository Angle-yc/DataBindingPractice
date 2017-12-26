package com.angle.hshb.databindingpractice.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.angle.hshb.databindingpractice.R;
import com.angle.hshb.databindingpractice.databinding.TextviewBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by angle
 * 2017/12/26.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private List<String> mData = new ArrayList<>();

    public ListAdapter(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextviewBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()
        ), R.layout.textview, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.binding.setStr(mData.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
       private TextviewBinding binding;

        public MyViewHolder(TextviewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
