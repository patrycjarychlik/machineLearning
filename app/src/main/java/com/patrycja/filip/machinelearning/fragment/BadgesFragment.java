package com.patrycja.filip.machinelearning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.adapter.BadgesAdapter;
import com.patrycja.filip.machinelearning.adapter.BadgesViews;
import com.patrycja.filip.machinelearning.components.AppBadgesDialog;

/**
 * Created by zwsfke on 2017-11-27.
 */
public class BadgesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_badges, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Badges");

        BadgesAdapter adapter = new BadgesAdapter(getContext(), BadgesViews.getBadges());
        GridView gridView = (GridView) view.findViewById(R.id.badges_grid_view);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view1, position, id) -> {
            AppBadgesDialog.createDialog(getContext(), BadgesViews.getBadges().get(position).getText()).show();
        });
    }

}
