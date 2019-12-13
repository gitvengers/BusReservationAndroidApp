package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.adapter.TicketListAdapter;
import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.domain.TicketDetail;
import com.oreo.busreservation.retrofit.NetworkHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketListActivity extends AppCompatActivity {
    @BindView(R.id.recycler_ticket_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);

        Call<List<TicketDetail>> ticketList = NetworkHelper.getInstance().getApiService().getTicketList(Member.getInstance().getId());
        ticketList.enqueue(new Callback<List<TicketDetail>>() {
            @Override
            public void onResponse(Call<List<TicketDetail>> call, Response<List<TicketDetail>> response) {
                List<TicketDetail> body = response.body();
                TicketListAdapter ticketListAdapter = new TicketListAdapter(body);
                recyclerView.setAdapter(ticketListAdapter);
            }

            @Override
            public void onFailure(Call<List<TicketDetail>> call, Throwable t) {
                Toast.makeText(TicketListActivity.this,"network error",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
