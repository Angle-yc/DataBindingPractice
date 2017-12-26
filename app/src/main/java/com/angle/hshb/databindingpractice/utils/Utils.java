package com.angle.hshb.databindingpractice.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.angle.hshb.databindingpractice.adapter.ListAdapter;

import java.util.List;

/**
 * Created by angle
 * 2017/12/26.
 * 工具类
 */

public class Utils {

    @BindingAdapter("data")
    public static void setData(RecyclerView recyclerView, List<String> data){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new ListAdapter(data));
    }
}
