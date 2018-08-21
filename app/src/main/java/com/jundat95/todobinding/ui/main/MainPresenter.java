package com.jundat95.todobinding.ui.main;

import android.content.Context;

import com.jundat95.todobinding.ui.add.AddViewModel;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private Context context;

    public MainPresenter(MainContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void addTodo() {
        view.addTodo();
    }

    @Override
    public void onShowData(AddViewModel addViewModel) {
        view.onShowData(addViewModel);
    }
}
