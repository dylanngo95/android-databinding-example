package com.jundat95.todobinding.ui.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jundat95.todobinding.BR;
import com.jundat95.todobinding.R;
import com.jundat95.todobinding.ui.add.AddViewModel;

import java.util.List;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<AddViewModel> addViewModels;

    public MainAdapter(List<AddViewModel> addViewModels) {
        this.addViewModels = addViewModels;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // create a new view
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.row_todo, viewGroup, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        final AddViewModel temperatureData = addViewModels.get(i);
        mainViewHolder.bin(temperatureData);
    }

    @Override
    public int getItemCount() {
        return addViewModels.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public  MainViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bin(Object obj){
            binding.setVariable(BR.item, obj);
            binding.executePendingBindings();
        }

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
