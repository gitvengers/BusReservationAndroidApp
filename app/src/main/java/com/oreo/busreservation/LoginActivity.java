package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.retrofit.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText idEditText;
    EditText pwEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
                    Member member = response.body();
                    if (member == null) {

                    } else {
                        Member.getInstance().setMember(member);
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }

                }

                @Override
                public void onFailure(Call<Member> call, Throwable t) {

                }
            });
        });
    }
}
