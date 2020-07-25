package com.example.toread.ui.search_title;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.toread.R;
import com.example.toread.ui.search_isbn.SearchIsbnViewModel;

public class SearchTitleFragment extends Fragment {
    private SearchTitleViewModel searchTitleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchTitleViewModel =
                ViewModelProviders.of(this).get(SearchTitleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_title, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        searchTitleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
