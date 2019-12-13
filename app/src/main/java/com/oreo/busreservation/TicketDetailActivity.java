package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.TicketDetail;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TicketDetailActivity extends AppCompatActivity {
    @BindView(R.id.ticket_detail_ticket_id)
    TextView id;

    @BindView(R.id.ticket_detail_departure)
    TextView departure;

    @BindView(R.id.ticket_detail_departure_time)
    TextView departureTime;

    @BindView(R.id.ticket_detail_departure_date)
    TextView departureDate;

    @BindView(R.id.ticket_detail_price)
    TextView price;

    @BindView(R.id.ticket_detail_arrival)
    TextView arrival;

    @BindView(R.id.ticket_detail_seat_number)
    TextView seatNumber;

    @BindView(R.id.ticket_detail_type)
    TextView type;

    @BindView(R.id.ticket_detail_company)
    TextView company;

    @BindView(R.id.ticket_detail_confirm_btn)
    Button confirmButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        TicketDetail ticketDetail = (TicketDetail) intent.getSerializableExtra("ticket_detail");

        id.setText(String.valueOf(ticketDetail.getId()));

        departure.setText(ticketDetail.getDeparture());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = ticketDetail.getDepartTime().split(",")[1];
        departureDate.setText(date);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String time = ticketDetail.getDepartTime().split(",")[2];
        departureTime.setText(time);

        price.setText(ticketDetail.getPrice()+" 원");

        arrival.setText(ticketDetail.getArrival());

        seatNumber.setText(String.valueOf(ticketDetail.getInfo()));

        type.setText(ticketDetail.getType());

        company.setText(ticketDetail.getCompany());

        confirmButton.setOnClickListener(v->{
            onBackPressed();
        });
    }
}
