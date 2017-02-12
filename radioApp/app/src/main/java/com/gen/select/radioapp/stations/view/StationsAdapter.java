package com.gen.select.radioapp.stations.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gen.select.radioapp.R;
import com.gen.select.radioapp.stations.domain.model.Station;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by mohamed on 12/02/2017.
 */

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.StationViewHolder> {

    private Context mContext;
    private List<Station> stationList;

    public StationsAdapter(List<Station> stationList, Context mContext) {
        setList(stationList);
        this.mContext = mContext;
    }

    private void setList(List<Station> stationList) {
        this.stationList = checkNotNull(stationList);
    }

    public void replaceData(List<Station> stationList) {
        setList(stationList);
        notifyDataSetChanged();
    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.station_card, parent, false);

        return new StationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {
        Station station = stationList.get(position);
        holder.title.setText(station.getName());
        holder.description.setText(station.getDescription());
        Picasso.with(mContext).load(station.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    public class StationViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.overflow)
        ImageView overflow;

        public StationViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
