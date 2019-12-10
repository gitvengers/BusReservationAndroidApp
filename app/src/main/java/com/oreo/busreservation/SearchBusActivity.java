package com.oreo.busreservation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.retrofit.NetworkHelper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBusActivity extends AppCompatActivity {
    final Calendar cal = Calendar.getInstance();

    @BindView(R.id.edit_departure_text)
    EditText departureText;

    @BindView(R.id.edit_arrival_text)
    EditText arrivalText;

    @BindView(R.id.edit_text_departure_date)
    EditText dateText;

    @BindView(R.id.btn_select_departure_date)
    ImageButton selectDepartureDate;

    @BindView(R.id.btn_search_bus)
    Button searchBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bus);

        ButterKnife.bind(this);

        selectDepartureDate.setOnClickListener(view -> {

            DatePickerDialog dialog = new DatePickerDialog(SearchBusActivity.this, (datePicker, year, month, date) -> {

                String msg = String.format("%d 년 %d 월 %d 일", year, month + 1, date);
                Toast.makeText(SearchBusActivity.this, msg, Toast.LENGTH_SHORT).show();
                dateText.setText(msg);
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

            dialog.getDatePicker().setMinDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
            dialog.show();
        });

        searchBus.setOnClickListener(view -> {
            SimpleDateFormat date = new SimpleDateFormat("yyyy 년 MM 월 dd 일", Locale.KOREAN);
            String departure = departureText.getText().toString();
            String arrival = arrivalText.getText().toString();
            Timestamp deparetureDate = new Timestamp(System.currentTimeMillis());

            try {
                String inputDate = dateText.getText().toString();
                deparetureDate = new Timestamp(date.parse(inputDate).getTime());
                System.out.println("Search Time : " + deparetureDate.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Call<List<Bus>> busList = NetworkHelper.getInstance().getApiService().getBusList(departure, arrival, deparetureDate);
            busList.enqueue(new Callback<List<Bus>>() {
                @Override
                public void onResponse(Call<List<Bus>> call, Response<List<Bus>> response) {
                    Intent intent = new Intent(getApplication(), BusListActivity.class);
                    intent.putExtra("busList", (ArrayList<Bus>)response.body());
                    intent.putExtra("listDeparture", departure);
                    intent.putExtra("listArrival", arrival);

                    intent.putExtra("departureDate", dateText.getText().toString());
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<List<Bus>> call, Throwable t) {

                }
            });
        });

    }
}
