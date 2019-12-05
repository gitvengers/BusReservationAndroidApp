package com.oreo.busreservation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.R;
import com.oreo.busreservation.domain.Bus;

import java.util.List;


public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.CustomViewHolder> {

    private List<Bus> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView departureTime;
        protected TextView departure;
        protected TextView arrival;


        public CustomViewHolder(View view) {
            super(view);
            this.departureTime = (TextView) view.findViewById(R.id.item_text_departure_time);
            this.departure = (TextView) view.findViewById(R.id.item_text_departure);
            this.arrival = (TextView) view.findViewById(R.id.item_text_arrival);
        }
    }

    public BusListAdapter(List<Bus> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus_list, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.departureTime.setText("9:00");
        holder.departure.setText(mList.get(position).getDeparture());
        holder.arrival.setText(mList.get(position).getArrival());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
