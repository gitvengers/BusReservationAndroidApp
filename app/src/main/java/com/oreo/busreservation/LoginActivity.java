package com.oreo.busreservation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oreo.busreservation.domain.Admin;
import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.retrofit.NetworkHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.oreo.busreservation.domain.Member.setMember;

public class LoginActivity extends AppCompatActivity {
    Button loginButton;
    EditText idEditText;
    EditText pwEditText;
    @BindView(R.id.signup_button)
    Button signupButton;
    Switch adminSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        loginButton = findViewById(R.id.next_button);
        idEditText = findViewById(R.id.id_edit_text);
        pwEditText = findViewById(R.id.password_edit_text);
        adminSwitch = findViewById(R.id.admin_switch);


        loginButton.setOnClickListener((V)->{
            String userId = idEditText.getText().toString();
            String userPw = pwEditText.getText().toString();

            if(adminSwitch.isChecked()) {
                Call<Admin> adminCall = NetworkHelper.getInstance().getApiService().getAdmin(userId,userPw);
                adminCall.enqueue(new Callback<Admin>() {
                    @Override
                    public void onResponse(Call<Admin> call, Response<Admin> response) {
                        //TODO : ADMIN 로그인
                        Admin admin = response.body();
                        if (admin == null) {

                        } else {
                            System.out.println("GOOD : " + admin.getId());
                            Admin.setAdmin(admin);
                            Intent intent = new Intent(getApplication(), MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<Admin> call, Throwable t) {

                    }
                });
            }
            else {
                Call<Member> member = NetworkHelper.getInstance().getApiService().getMember(userId, userPw);
                member.enqueue(new Callback<Member>() {
                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        Member member = response.body();
                        if (member == null) {

                        } else {
                            Member.setMember(member);
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
            }
        });

        signupButton.setOnClickListener(view->{
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });
    }
}
