package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.Bus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusDetailActivity extends AppCompatActivity {
    @BindView(R.id.detail_departure_text)
    TextView detailDeparture;

    @BindView(R.id.detail_arrival_text)
    TextView detailArrival;

    @BindView(R.id.text_bus_detail_departure_time)
    TextView detailDepartureTime;

    @BindView(R.id.text_bus_detail_arrival_time)
    TextView detailArrivalTime;

    @BindView(R.id.text_bus_detail_company)
    TextView detailBusCompany;

    @BindView(R.id.text_bus_detail_price)
    TextView detailTicketPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_detail);
        ButterKnife.bind(this);

        Bus busDetail = (Bus) getIntent().getSerializableExtra("busDetail");
        detailDeparture.setText(busDetail.getDeparture());
        detailArrival.setText(busDetail.getArrival());


        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date(busDetail.getDepartureTime());
        String time = timeFormat.format(date);
        detailDepartureTime.setText(time);

        date = new Date(busDetail.getArrivalTime());
        time = timeFormat.format(date);
        detailArrivalTime.setText(time);

        detailBusCompany.setText(busDetail.getCompany());
        detailTicketPrice.setText(busDetail.getPrice()+" ");
    }
}
