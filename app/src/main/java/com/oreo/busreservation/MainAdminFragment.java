package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class MainAdminFragment extends Fragment {
    Button buttonSearchBus;
    Button myPageButton;
    Button registerBusButton;
    Button managementMemberButton;
    Button confirmPaymentButton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_admin, container, false);

        myPageButton = view.findViewById(R.id.btn_my_page);
        buttonSearchBus = view.findViewById(R.id.btn_admin_bus_search);
        registerBusButton = view.findViewById(R.id.register_bus);
        managementMemberButton = view.findViewById(R.id.management_member_info);
        confirmPaymentButton = view.findViewById(R.id.confirm_payment_history);

        buttonSearchBus.setOnClickListener((v) -> {
            Intent intent = new Intent(getActivity(), SearchBusActivity.class);
            startActivity(intent);
        });

        registerBusButton.setOnClickListener((v) -> {
            Intent intent = new Intent(getActivity(), BusRegisterActivity.class);
            startActivity(intent);
        });

        managementMemberButton.setOnClickListener((v) -> {
            Intent intent = new Intent(getActivity(), MemberListActivity.class);
            startActivity(intent);
        });

        confirmPaymentButton.setOnClickListener((v) -> {

        });

        return view;
    }
}
