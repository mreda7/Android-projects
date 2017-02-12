package com.gen.select.radioApp;

import android.content.Context;
import android.support.annotation.NonNull;

import com.gen.select.radioApp.data.FakeStationsRemoteDataSource;
import com.gen.select.radioapp.UseCaseHandler;
import com.gen.select.radioapp.data.source.StationsRepository;
import com.gen.select.radioapp.data.source.local.StationsLocalDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by mohamed on 12/02/2017.
 */

public class Injection {

    public static StationsRepository provideTasksRepository(@NonNull Context context) {
        checkNotNull(context);
        return StationsRepository.getInstance(FakeStationsRemoteDataSource.getInstance(),
                StationsLocalDataSource.getInstance(context));
    }

    public static GetStations provideGetStations(@NonNull Context context) {
        return new GetStations(provideTasksRepository(context));
    }

    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

    public static GetStations provideGetStation(@NonNull Context context) {
        return new GetStations(Injection.provideTasksRepository(context));
    }

}

