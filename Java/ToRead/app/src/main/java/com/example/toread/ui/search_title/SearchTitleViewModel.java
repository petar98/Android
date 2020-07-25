package com.example.toread.ui.search_title;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchTitleViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SearchTitleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Search Title fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
