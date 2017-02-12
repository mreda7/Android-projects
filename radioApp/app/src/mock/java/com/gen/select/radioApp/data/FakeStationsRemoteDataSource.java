package com.gen.select.radioApp.data;

/**
 * Created by mohamed on 12/02/2017.
 */

import android.support.annotation.NonNull;

import com.gen.select.radioapp.R;
import com.gen.select.radioapp.data.source.StationsDataSource;
import com.gen.select.radioapp.stations.domain.model.Station;
import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of a remote data source with static access to the data for easy testing.
 */

public class FakeStationsRemoteDataSource implements StationsDataSource {

    private static FakeStationsRemoteDataSource INSTANCE;

    private static final Map<Long, Station> STATIONS_SERVICE_DATA = new LinkedHashMap<>();

    // Prevent direct instantiation.
    private FakeStationsRemoteDataSource() {

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
        STATIONS_SERVICE_DATA.put(a.getId(), a);

        Station b = new Station("Hit radio", "yoyo", 1L, covers[1]);
        STATIONS_SERVICE_DATA.put(b.getId(), b);

        Station c = new Station("Maroon 5", "yoyo", 2L, covers[2]);
        STATIONS_SERVICE_DATA.put(c.getId(), c);

        Station d = new Station("Medi 1", "Radio Maghreb", 3L, covers[3]);
        STATIONS_SERVICE_DATA.put(d.getId(), d);

        Station e = new Station("Hit radio", "yoyo", 4L, covers[4]);
        STATIONS_SERVICE_DATA.put(e.getId(), e);

        Station f = new Station("Maroon 5", "yoyo", 5L, covers[5]);
        STATIONS_SERVICE_DATA.put(f.getId(), f);
        Station g = new Station("Medi 1", "Radio Maghreb", 6L, covers[6]);
        STATIONS_SERVICE_DATA.put(g.getId(), g);

        Station h = new Station("Hit radio", "yoyo", 7L, covers[7]);
        STATIONS_SERVICE_DATA.put(h.getId(), h);

        Station i = new Station("Maroon 5", "yoyo", 8L, covers[8]);
        STATIONS_SERVICE_DATA.put(i.getId(), i);

        Station j = new Station("Medi 1", "Radio Maghreb", 9L, covers[9]);
        STATIONS_SERVICE_DATA.put(j.getId(), j);

        Station k = new Station("Hit radio", "yoyo", 10L, covers[10]);
        STATIONS_SERVICE_DATA.put(k.getId(), k);

    }

    public static FakeStationsRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FakeStationsRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getStations(@NonNull LoadStationsCallback callback) {
        callback.onStationsLoaded(Lists.newArrayList(STATIONS_SERVICE_DATA.values()));
    }

    @Override
    public void getStation(@NonNull Long stationId, @NonNull GetStationCallback callback) {
        Station station = STATIONS_SERVICE_DATA.get(stationId);
        callback.onStationLoaded(station);
    }

    @Override
    public void refreshStations() {
        // Not required because the {@link TasksRepository} handles the logic of refreshing the
        // tasks from all the available data sources.
    }
}

