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
import com.oreo.busreservation.retrofit.NetworkHelper;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
                int adapterPosition = getAdapterPosition();
                int busId = mList.get(adapterPosition).getBusId();
                System.out.println("ID : " + busId);

                Call<Bus> busDetail = NetworkHelper.getInstance().getApiService().getBusDetail(busId);
                busDetail.enqueue(new Callback<Bus>() {
                    @Override
                    public void onResponse(Call<Bus> call, Response<Bus> response) {
                        System.out.println("BODY : " + response.body());
                        Intent intent = new Intent(view.getContext(), BusDetailActivity.class);
                        intent.putExtra("busDetail", response.body());
                        view.getContext().startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Bus> call, Throwable t) {

                    }
                });
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
        SimpleDateFormat departureTimeFormat = new SimpleDateFormat("HH:mm");
        Date departureDate = new Date(mList.get(position).getDepartureTime());
        String departureTime = departureTimeFormat.format(departureDate);

        holder.departureTime.setText(departureTime);
        holder.departure.setText(mList.get(position).getDeparture());
        holder.arrival.setText(mList.get(position).getArrival());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
