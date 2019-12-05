package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.retrofit.NetworkHelper;

import java.lang.reflect.Member;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText idEditText;
    EditText pwEditText;
    @BindView(R.id.signup_button)
    Button signupButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        loginButton = findViewById(R.id.next_button);
        idEditText = findViewById(R.id.id_edit_text);
        pwEditText = findViewById(R.id.password_edit_text);

        loginButton.setOnClickListener((V)->{
            String userId = idEditText.getText().toString();
            String userPw = pwEditText.getText().toString();

            Call<Member> member = NetworkHelper.getInstance().getApiService().getMember(userId, userPw);
            member.enqueue(new Callback<Member>() {
                @Override
                public void onResponse(Call<Member> call, Response<Member> response) {

                }

                @Override
                public void onFailure(Call<Member> call, Throwable t) {

                }
            });
        });

        signupButton.setOnClickListener(view->{
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });
    }
}
