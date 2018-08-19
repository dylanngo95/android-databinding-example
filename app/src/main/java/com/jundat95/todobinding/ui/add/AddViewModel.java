package com.jundat95.todobinding.ui.add;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Debug;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.jundat95.todobinding.BR;

public class AddViewModel extends BaseObservable {

    private String title;
    private String content;

    public AddViewModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public TextWatcher getTitleTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    @Bindable
    public TextWatcher getContentTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setContent(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

}
