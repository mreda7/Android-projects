package com.gen.select.radioapp.stations;

import com.gen.select.radioapp.BasePresenter;
import com.gen.select.radioapp.BaseView;
import com.gen.select.radioapp.stations.domain.model.Station;

import java.util.List;

/**
 * Created by mohamed on 11/02/2017.
 */

public interface StationsContract {

    interface View extends BaseView<Presenter> {

        void showNoConnexion();

        void showStations(List<Station> stationList);

        void setLoadingIndicator(boolean active);

        boolean isActive();

    }

    interface Presenter extends BasePresenter {

        void loadStations(boolean forceUpdate);

    }
}
