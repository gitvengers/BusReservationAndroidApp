package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.adapter.BusListAdapter;
import com.oreo.busreservation.domain.Bus;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BusListActivity extends AppCompatActivity {
    @BindView(R.id.recycler_bus_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.input_text_departure)
    TextView departureText;

    @BindView(R.id.input_text_arrival)
    TextView arrivalText;

    @BindView(R.id.text_list_departure_date)
    TextView departureDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);
        ButterKnife.bind(this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        //todo retrofit으로 list를 받아와야 함.
//        List<Bus> buses = Arrays.asList(new Bus(new Timestamp(System.currentTimeMillis()), "대전", "서울"));
//        BusListAdapter busListAdapter = new BusListAdapter(buses);

        ArrayList<Bus> busList = (ArrayList<Bus>)getIntent().getSerializableExtra("busList");

        departureText.setText(getIntent().getStringExtra("listDeparture"));
        arrivalText.setText(getIntent().getStringExtra("listArrival"));
        departureDate.setText(getIntent().getStringExtra("departureDate"));

        BusListAdapter busListAdapter = new BusListAdapter(busList);

        mRecyclerView.setAdapter(busListAdapter);
    }
}
