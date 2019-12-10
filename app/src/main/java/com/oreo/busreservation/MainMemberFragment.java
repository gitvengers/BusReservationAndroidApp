package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.oreo.busreservation.domain.Member;


public class MainMemberFragment extends Fragment {
    Button buttonSearchBus;
    Button buttonMyPage;
    Button buttonPaymentHistory;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_member, container, false);

        buttonMyPage = view.findViewById(R.id.btn_member_my_page);
        buttonSearchBus = view.findViewById(R.id.btn_member_bus_search);
        buttonPaymentHistory = view.findViewById(R.id.confirm_payment_history);

        buttonMyPage.setText(Member.getInstance().toString());

        buttonSearchBus.setOnClickListener((v) -> {
            Intent intent = new Intent(getActivity(), SearchBusActivity.class);
            startActivity(intent);
        });

        buttonPaymentHistory.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PaymentHistoryActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
