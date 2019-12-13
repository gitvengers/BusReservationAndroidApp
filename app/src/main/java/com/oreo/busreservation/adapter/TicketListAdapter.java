package com.oreo.busreservation.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.R;
import com.oreo.busreservation.TicketDetailActivity;
import com.oreo.busreservation.domain.TicketDetail;

import java.util.List;

public class TicketListAdapter extends RecyclerView.Adapter<TicketListAdapter.CustomViewHolder> {

    private List<TicketDetail> ticketDetails;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dateTime;
        protected TextView company;
        protected TextView price;
        protected Button infoDetail;

        public CustomViewHolder(View view) {
            super(view);
            this.dateTime = view.findViewById(R.id.ticket_item_date_and_time);
            this.company = view.findViewById(R.id.ticket_item_item_company);
            this.price = view.findViewById(R.id.ticket_item_price);
            this.infoDetail = view.findViewById(R.id.ticket_item_info_btn);

            infoDetail.setOnClickListener(v -> {
                int adapterPosition = getAdapterPosition();
                TicketDetail ticketDetail = ticketDetails.get(adapterPosition);

                Intent intent = new Intent(view.getContext().getApplicationContext(), TicketDetailActivity.class);
                intent.putExtra("ticket_detail", ticketDetail);
                view.getContext().startActivity(intent);

            });
        }
    }

    public TicketListAdapter(List<TicketDetail> ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket_list, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        String departTime = ticketDetails.get(position).getDepartTime();
        String time = departTime.split(",")[2];
        holder.dateTime.setText(time);
        holder.company.setText(ticketDetails.get(position).getCompany());
        holder.price.setText(ticketDetails.get(position).getPrice() + " 원");
    }

    @Override
    public int getItemCount() {
        return ticketDetails.size();
    }

}
