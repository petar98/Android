package com.example.toread.ui.search_isbn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.toread.R;
import com.example.toread.requestor.FetchBookByIsbn;

public class SearchIsbnFragment extends Fragment {
    private SearchIsbnViewModel searchIsbnViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchIsbnViewModel =
                ViewModelProviders.of(this).get(SearchIsbnViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search_isbn, container, false);
        final TextView textView = root.findViewById(R.id.text_search_isbn);
        searchIsbnViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Button searchButton = root.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    new FetchBookByIsbn(textView).execute("https://openlibrary.org/api/books?bibkeys=ISBN:9780980200447&jscmd=data&format=json");
            }
        });

        return root;
    }
}
