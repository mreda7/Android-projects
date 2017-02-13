package com.gen.select.radioapp.stations.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gen.select.radioapp.R;
import com.gen.select.radioapp.stations.StationsContract;
import com.gen.select.radioapp.stations.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by mohamed on 11/02/2017.
 */

public class StationsFragment extends Fragment implements StationsContract.View {

    private StationsContract.Presenter mPresenter;
    private Unbinder unbinder;
    private StationsAdapter mStationsAdapter;

    @BindView(R.id.stationsRecyclerView)
    RecyclerView mStationsRecyclerView;


    public StationsFragment() {
        // Requires empty public constructor
    }

    public static StationsFragment newInstance() {
        return new StationsFragment();
    }

    @Override
    public void setPresenter(StationsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStationsAdapter = new StationsAdapter(new ArrayList<Station>(0), getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.frag_stations, container, false);
        unbinder = ButterKnife.bind(this, root);

        // Set recyclerView
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        mStationsRecyclerView.setLayoutManager(mLayoutManager);
        mStationsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mStationsRecyclerView.setAdapter(mStationsAdapter);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showNoConnexion() {
        mStationsRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void showStations(List<Station> stationList) {
        mStationsAdapter.replaceData(stationList);
        mStationsRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
