package com.oreo.busreservation.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.BusDetailActivity;
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
            this.departureTime = view.findViewById(R.id.item_text_departure_time);
            this.departure = view.findViewById(R.id.item_text_departure);
            this.arrival = view.findViewById(R.id.item_text_arrival);

            view.setOnClickListener(v -> {
                Intent intent = new Intent(view.getContext(), BusDetailActivity.class);
                view.getContext().startActivity(intent);
            });
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

        return new CustomViewHolder(view);
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
