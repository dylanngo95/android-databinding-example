package com.jundat95.todobinding.ui.main;

import com.jundat95.todobinding.ui.add.AddViewModel;

public interface MainContract {

    public interface Presenter {
        void addTodo();
        void onShowData(AddViewModel addViewModel);
    }

    public interface View {
        void addTodo();
        void onShowData(AddViewModel addViewModel);
    }
}
