package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.Bus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentActivity extends AppCompatActivity {
    @BindView(R.id.edit_ticket_date_N_time)
    TextView dateNtime;

    @BindView(R.id.edit_ticket_bus_company)
    TextView busCompany;

    @BindView(R.id.edit_ticket_price)
    TextView price;

    @BindView(R.id.edit_ticket_payment_price)
    TextView paymentPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        Bus bus = (Bus) getIntent().getSerializableExtra("busDetail");
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분");
        System.out.println("PayMent TIme : " + bus.getDepartureTime());
        Date ticketDate = new Date(bus.getDepartureTime());
        String dateText = dateFormat.format(ticketDate);

        dateNtime.setText(dateText);
        busCompany.setText(bus.getCompany());

        String priceText = String.valueOf(bus.getPrice());
        price.setText(priceText);
        paymentPrice.setText(priceText);
    }
}
