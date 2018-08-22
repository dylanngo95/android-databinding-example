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

        binding.rcvTodo.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        binding.rcvTodo.setLayoutManager(layoutManager);

        List<AddViewModel> items = Arrays.asList(
                new AddViewModel("What is Lorem Ipsum?", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. "),
                new AddViewModel("Why do we use it?", "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."),
                new AddViewModel("Where does it come from?", "Where does it come from?\n" +
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "),
                new AddViewModel("Where does it come from?", "Where does it come from?\n" +
                        "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. "),
                new AddViewModel("Where can I get some?", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable."),
                new AddViewModel("Where can I get some?", "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.")
        );

        adapter = new MainAdapter(items);
        binding.rcvTodo.setAdapter(adapter);

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
