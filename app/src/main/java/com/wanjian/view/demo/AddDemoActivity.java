package com.wanjian.view.demo;

import static com.wanjian.view.demo.utils.Utils.geneRandomData;
import static com.wanjian.view.demo.utils.Utils.showJson;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wanjian.view.ExpandableAdapter;
import com.wanjian.view.demo.adapter.AddAdapter;
import com.wanjian.view.demo.data.Shop;

import java.util.List;


/**
 * Created by wanjian on 2018/1/29.
 */
public class AddDemoActivity extends AppCompatActivity {
    List<Shop> shopList;
    ExpandableAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        shopList = geneRandomData();
        showJson(shopList);

        vertical(recyclerView);


        findViewById(R.id.refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Shop> newData = geneRandomData();
                shopList.clear();

                shopList.addAll(newData);
                showJson(shopList);
                adapter.notifyDataSetChanged();
            }
        });


    }


    private void vertical(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AddAdapter(shopList);
        recyclerView.setAdapter(adapter);

    }


}
