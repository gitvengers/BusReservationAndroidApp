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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusRegisterActivity extends AppCompatActivity {
    Button registerButton;
    EditText departureText;
    EditText arrivalText;
    EditText depart_timeText;
    EditText arrive_timeText;
    EditText bus_type;
    EditText bus_company;
    EditText bus_price;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_register);

        registerButton = findViewById(R.id.register_button);
        departureText = findViewById(R.id.departure_edit_text);
        arrivalText = findViewById(R.id.arrival_edit_text);
        depart_timeText = findViewById(R.id.depart_time_edit_text);
        arrive_timeText = findViewById(R.id.arrive_time_edit_text);
        bus_type = findViewById(R.id.bustype_edit_text);
        bus_company = findViewById(R.id.company_edit_text);
        bus_price = findViewById(R.id.price_edit_text);


        registerButton.setOnClickListener((V)->{
            String departure = departureText.getText().toString();
            String arrival = arrivalText.getText().toString();
            Timestamp depart_time = Timestamp.valueOf(depart_timeText.getText().toString());
            Timestamp arrive_time = Timestamp.valueOf(arrive_timeText.getText().toString());
            String type = bus_type.getText().toString();
            String company = bus_company.getText().toString();
            int price = Integer.valueOf(bus_price.getText().toString());

            Call<Boolean> busRegister = NetworkHelper.getInstance().getApiService().busRegister(departure,arrival,depart_time,arrive_time,type,company,price);
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
