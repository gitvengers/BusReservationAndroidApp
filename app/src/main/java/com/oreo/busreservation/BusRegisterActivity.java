package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.retrofit.NetworkHelper;

import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusRegisterActivity extends AppCompatActivity {
    @BindView(R.id.register_button)
    Button registerButton;

    @BindView(R.id.departure_edit_text)
    EditText departureText;

    @BindView(R.id.arrival_edit_text)
    EditText arrivalText;

    @BindView(R.id.depart_time_edit_text)
    EditText depart_timeText;

    @BindView(R.id.arrive_time_edit_text)
    EditText arrive_timeText;

    @BindView(R.id.bustype_edit_text)
    EditText bus_type;

    @BindView(R.id.company_edit_text)
    EditText bus_company;

    @BindView(R.id.price_edit_text)
    EditText bus_price;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_register);
        ButterKnife.bind(this);

        registerButton.setOnClickListener((V)->{
            String departure = departureText.getText().toString();
            String arrival = arrivalText.getText().toString();
            // TODO YYYY-MM-dd HH:mm:ss
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String depart_time = depart_timeText.getText().toString();
            String arrive_time = arrive_timeText.getText().toString();

            Timestamp departureDate = new Timestamp(System.currentTimeMillis());
            Timestamp arrivalDate = new Timestamp(System.currentTimeMillis());

            try {
                departureDate = new Timestamp(dateFormat.parse(depart_time).getTime());
                arrivalDate = new Timestamp(dateFormat.parse(arrive_time).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }


            String type = bus_type.getText().toString();
            String company = bus_company.getText().toString();
            int price = Integer.valueOf(bus_price.getText().toString());

            Call<Boolean> busRegister = NetworkHelper.getInstance().getApiService().busRegister(departure,arrival,departureDate,arrivalDate,type,company,price);
            busRegister.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(BusRegisterActivity.this,"success",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                    else{
                        Toast.makeText(BusRegisterActivity.this,"failed",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }
            });
        });
    }
}
