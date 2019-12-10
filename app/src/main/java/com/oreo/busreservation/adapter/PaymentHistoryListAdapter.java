package com.oreo.busreservation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.R;
import com.oreo.busreservation.domain.Payment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PaymentHistoryListAdapter extends RecyclerView.Adapter<PaymentHistoryListAdapter.CustomViewHolder> {

    private List<Payment> payments;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dateTime;
        protected TextView company;
        protected TextView price;


        public CustomViewHolder(View view) {
            super(view);
            this.dateTime = view.findViewById(R.id.payment_history_item_date_and_time);
            this.company = view.findViewById(R.id.payment_history_item_company);
            this.price = view.findViewById(R.id.payment_history_item_price);
        }
    }

    public PaymentHistoryListAdapter(List<Payment> payments) {
        this.payments = payments;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_payment_history_list, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        long dateTime = payments.get(position).getDateTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        holder.dateTime.setText(simpleDateFormat.format(new Date(dateTime)));
        holder.company.setText(payments.get(position).getCompany());
        holder.price.setText(payments.get(position).getPrice() + "");
    }

    @Override
    public int getItemCount() {
        return payments.size();
    }
}
