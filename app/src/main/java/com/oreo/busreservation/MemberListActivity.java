package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.adapter.BusListAdapter;
import com.oreo.busreservation.adapter.MemberListAdapter;
import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.retrofit.NetworkHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        Call<List<Member>> memberArrayList = NetworkHelper.getInstance().getApiService().getMemberList();
        memberArrayList.enqueue(new Callback<List<Member>>() {
            @Override
            public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                MemberListAdapter memberListAdapter = new MemberListAdapter((List<Member>) memberArrayList);
                mRecyclerView.setAdapter(memberListAdapter);
            }

            @Override
            public void onFailure(Call<List<Member>> call, Throwable t) {

            }
        });

    }
}
