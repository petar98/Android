package com.example.toread.ui.search_isbn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchIsbnViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public SearchIsbnViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Enter ISBN of the book you are searching");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
