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

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchBusActivity extends AppCompatActivity {
    final Calendar cal = Calendar.getInstance();

    @BindView(R.id.edit_text_departure_date)
    EditText editText;

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
                editText.setText(msg);
            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

            dialog.getDatePicker().setMinDate(new Date().getTime());    //입력한 날짜 이후로 클릭 안되게 옵션
            dialog.show();
        });

        searchBus.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), BusListActivity.class);
            startActivity(intent);
        });

    }
}
