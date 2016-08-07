package com.example.a0180600.fragmentbestpratice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by a0180600 on 16-8-7.
 */
public class NewsContentFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_frag, container, false);
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        // find the IDs of object
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newContentText = (TextView) view.findViewById(R.id.news_content);
        // refresh the 'Title' and 'Content'
        newsTitleText.setText(newsTitle);
        newContentText.setText(newsContent);
    }

}
