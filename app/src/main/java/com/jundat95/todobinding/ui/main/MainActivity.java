package com.jundat95.todobinding.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jundat95.todobinding.R;
import com.jundat95.todobinding.databinding.ActivityMainBinding;
import com.jundat95.todobinding.ui.add.AddActivity;
import com.jundat95.todobinding.ui.add.AddViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        AddViewModel addViewModel = new AddViewModel("test title", "test content");
        MainPresenter mainPresenter = new MainPresenter(this, getApplicationContext());

        binding.setPresenter(mainPresenter);

        recyclerView = (RecyclerView)findViewById(R.id.rcvTodo);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<AddViewModel> items = Arrays.asList(
                new AddViewModel("Title 1", "Content 1"),
                new AddViewModel("Title 2", "Content 2"),
                new AddViewModel("Title 3", "Content 3"),
                new AddViewModel("Title 4", "Content 4"),
                new AddViewModel("Title 5", "Content 5"),
                new AddViewModel("Title 6", "Content 6")
        );

        adapter = new MainAdapter(items);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void addTodo() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void onShowData(AddViewModel addViewModel) {
    }
}
