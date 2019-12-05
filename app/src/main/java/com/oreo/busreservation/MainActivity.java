package com.oreo.busreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.oreo.busreservation.domain.Member;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }

        if (Member.getInstance().getUserId() != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new MainMemberFragment())
                    .commit();
        }
    }
}
