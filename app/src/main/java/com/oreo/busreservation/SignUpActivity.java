package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.retrofit.NetworkHelper;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    Button signUpButton;
    EditText idEditText;
    EditText pwEditText;
    EditText nameEditText;
    EditText emailEditText;
    Button cancelButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.signup_button);
        idEditText = findViewById(R.id.id_edit_text);
        pwEditText = findViewById(R.id.password_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        cancelButton = findViewById(R.id.cancel_button);

        signUpButton.setOnClickListener((V)->{
            String userId = idEditText.getText().toString();
            String userPw = pwEditText.getText().toString();
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();

            Call<Boolean> memberCall = NetworkHelper.getInstance().getApiService().insertMember(userId, userPw, name, email);
            memberCall.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(@NotNull Call<Boolean> call, @NotNull Response<Boolean> response) {
                    if(response.body()){
                        Toast.makeText(SignUpActivity.this,"회원가입이 환료되었습니다.",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                    else{
                        Toast.makeText(SignUpActivity.this,"회원가입이 실패했습니다.",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                }

                @Override
                public void onFailure(@NotNull Call<Boolean> call, @NotNull Throwable t) {

                }
            });
        });

        cancelButton.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}
