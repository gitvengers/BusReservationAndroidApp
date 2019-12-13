package com.oreo.busreservation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.adapter.PaymentHistoryListAdapter;
import com.oreo.busreservation.domain.Payment;

import java.sql.Timestamp;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentHistoryActivity extends AppCompatActivity {
    @BindView(R.id.recycler_payment_history_list)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);
        ButterKnife.bind(this);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment(new Timestamp(System.currentTimeMillis()).getTime(), "전북고속", 10000));
        PaymentHistoryListAdapter paymentHistoryListAdapter = new PaymentHistoryListAdapter(payments);

        mRecyclerView.setAdapter(paymentHistoryListAdapter);

    }
}
