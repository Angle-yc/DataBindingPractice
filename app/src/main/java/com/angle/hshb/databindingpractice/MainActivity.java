package com.angle.hshb.databindingpractice;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.angle.hshb.databindingpractice.adapter.ListAdapter;
import com.angle.hshb.databindingpractice.bean.User;
import com.angle.hshb.databindingpractice.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding  dataBinding;

    User user = new User("angle,绑定类数据","25,绑定类数据");
    private ArrayList<String> mData = new ArrayList<String>(){
        {
            for (int i = 0; i < 70; i++) {
                add("第"+(i+1)+"条数据,绑定list中的数据");
            }
        }
    };

    private HashMap<String,String> mMap = new HashMap<String,String>(){
        {
            for (int i = 0; i < 10; i++) {
                put("user"+(i+1),"Hello"+(i+1)+",绑定Map中数据");
            }
        }
    };

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            user.setName("我是后面赋值的姓名,数据更新");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         dataBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_main);

        //绑定类数据
        dataBinding.setUser(user);

        //根据id绑定数据
        dataBinding.id.setText("通过ID赋值");

        //绑定List集合数据
        dataBinding.setListKey(5);
        dataBinding.setList(mData);

        //绑定Map集合数据
        dataBinding.setMapKey("user5");
        dataBinding.setMap(mMap);

        //更新数据
        handler.sendEmptyMessageDelayed(100,5000);

        //点击事件
        dataBinding.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
