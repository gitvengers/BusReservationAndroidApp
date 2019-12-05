package com.oreo.busreservation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.retrofit.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    Button signUpButton;
    EditText idEditText;
    EditText pwEditText;
    EditText nameEditText;
    EditText emailEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUpButton = findViewById(R.id.signup_button);
        idEditText = findViewById(R.id.id_edit_text);
        pwEditText = findViewById(R.id.password_edit_text);
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);


        signUpButton.setOnClickListener((V)->{
            String userId = idEditText.getText().toString();
            String userPw = pwEditText.getText().toString();
            String name = nameEditText.getText().toString();
            String email = emailEditText.getText().toString();

            Call<java.lang.Boolean> memberCall = NetworkHelper.getInstance().getApiService().insertMember(userId, userPw, name, email);
            memberCall.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.isSuccessful() == true){
                        Toast.makeText(SignUpActivity.this,"success",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                    else{
                        Toast.makeText(SignUpActivity.this,"failed",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }
            });
        });
    }
}
