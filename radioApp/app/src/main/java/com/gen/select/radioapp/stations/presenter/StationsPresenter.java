package com.gen.select.radioapp.stations.presenter;

import android.support.annotation.NonNull;

import com.gen.select.radioapp.R;
import com.gen.select.radioapp.UseCaseHandler;
import com.gen.select.radioapp.stations.StationsContract;
import com.gen.select.radioapp.stations.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by mohamed on 11/02/2017.
 */

public class StationsPresenter implements StationsContract.Presenter {

    private final StationsContract.View mStationsView;
    private final UseCaseHandler mUseCaseHandler;

    private boolean mFirstLoad = true;

    public StationsPresenter(@NonNull UseCaseHandler useCaseHandler,
                             @NonNull StationsContract.View stationsView) {
        mStationsView = checkNotNull(stationsView, "stationsView cannot be null!");
        mStationsView.setPresenter(this);
        mUseCaseHandler = checkNotNull(useCaseHandler, "useCaseHandler cannot be null!");
    }

    @Override
    public void start() {
        loadStations(false);
    }

    @Override
    public void loadStations(boolean forceUpdate) {
        // Simplification for sample: a network reload will be forced on first load.
        loadStations(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    public void loadStations(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mStationsView.setLoadingIndicator(true);
        }

        //GetStations.RequestValues requestValue = new GetStations.RequestValues(forceUpdate);

        if (!mStationsView.isActive()) {
            return;
        }
        if (showLoadingUI) {
            mStationsView.setLoadingIndicator(false);
        }

        mStationsView.showStations(initStations());
        /**
         mUseCaseHandler.execute(mGetStations, requestValue,
         new UseCase.UseCaseCallback<GetStations.ResponseValue>() {

        @Override public void onSuccess(GetStations.ResponseValue response) {
        List<Station> stations = response.getStations();
        // The view may not be able to handle UI updates anymore
        if (!mStationsView.isActive()) {
        return;
        }
        if (showLoadingUI) {
        mStationsView.setLoadingIndicator(false);
        }

        mStationsView.showStations(stations);
        }

        @Override public void onError() {
        // The view may not be able to handle UI updates anymore
        if (!mStationsView.isActive()) {
        return;
        }
        mStationsView.showNoConnexion();
        }
        });**/
    }


    private List<Station> initStations() {

        List<Station> stations = new ArrayList<>();
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        Station a = new Station("Medi 1", "Radio Maghreb", 0L, covers[0]);
        stations.add(a);

        Station b = new Station("Hit radio", "yoyo", 1L, covers[1]);
        stations.add(b);

        Station c = new Station("Maroon 5", "yoyo", 2L, covers[2]);
        stations.add(c);

        Station d = new Station("Medi 1", "Radio Maghreb", 3L, covers[3]);
        stations.add(d);

        Station e = new Station("Hit radio", "yoyo", 4L, covers[4]);
        stations.add(e);

        Station f = new Station("Maroon 5", "yoyo", 5L, covers[5]);
        stations.add(f);
        Station g = new Station("Medi 1", "Radio Maghreb", 6L, covers[6]);
        stations.add(g);

        Station h = new Station("Hit radio", "yoyo", 7L, covers[7]);
        stations.add(h);

        Station i = new Station("Maroon 5", "yoyo", 8L, covers[8]);
        stations.add(i);

        Station j = new Station("Medi 1", "Radio Maghreb", 9L, covers[9]);
        stations.add(j);

        Station k = new Station("Hit radio", "yoyo", 10L, covers[10]);
        stations.add(k);

        return stations;
    }

}
