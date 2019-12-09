package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.adapter.BusListAdapter;
import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.domain.Member;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class MemberListActivity extends AppCompatActivity {
    @BindView(R.id.recycler_member_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ButterKnife.bind(this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);

//        ArrayList<Bus> busList = (ArrayList<Bus>)getIntent().getSerializableExtra("busList");

//        departureText.setText(getIntent().getStringExtra("listDeparture"));
//        arrivalText.setText(getIntent().getStringExtra("listArrival"));
//
        BusListAdapter busListAdapter = new BusListAdapter(busList);

        Call<List<>>

        mRecyclerView.setAdapter(busListAdapter);
    }
}
