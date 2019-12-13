package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.dialog.CustomDialog;
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

    @BindView(R.id.payment_button)
    Button paymentButton;

    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        ButterKnife.bind(this);

        Bus bus = (Bus) getIntent().getSerializableExtra("busDetail");
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분");
        Date ticketDate = new Date(bus.getDepartureTime());
        String dateText = dateFormat.format(ticketDate);

        dateNtime.setText(dateText);
        busCompany.setText(bus.getCompany());
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();

        String priceText = String.valueOf(bus.getPrice());
        price.setText(priceText);
        paymentPrice.setText(priceText);

        paymentButton.setOnClickListener((v) -> {
            if (checkedRadioButtonId == 0) {
                Toast.makeText(this, "결제 방법을 선택해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                CustomDialog customDialog = new CustomDialog(PaymentActivity.this, bus);
                customDialog.callDialog();
            }
        });
    }
}
