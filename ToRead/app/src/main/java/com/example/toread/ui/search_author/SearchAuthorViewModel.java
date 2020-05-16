package com.example.toread.ui.search_author;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchAuthorViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SearchAuthorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Search Author fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
