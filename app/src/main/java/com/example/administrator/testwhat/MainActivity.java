package com.example.administrator.testwhat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<TestBean> list = new ArrayList<>();
    private TestAdapter testAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                if (i == 0 || i == 3 || i == 6){
                    return 2;
                }else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        testAdapter = new TestAdapter(list , this);
        recyclerView.setAdapter(testAdapter);
    }

    private void initData() {
        for (int i = 0 ; i < 10 ; i ++){
            TestBean bean = new TestBean();
            bean.setImg("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1954736582,1888618888&fm=11&gp=0.jpg");
            bean.setTv("name-->what:"+i);
            list.add(bean);
        }
    }
}
