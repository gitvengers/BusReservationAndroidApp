package com.oreo.busreservation.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.oreo.busreservation.R;
import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.retrofit.NetworkHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomDialog {
    private Context context;
    private Bus bus;
    Button okBUtton;
    Button cancelButton;

    public CustomDialog(Context context, Bus bus) {
        this.context = context;
        this.bus = bus;
    }

    public void callDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_payment_confirm);
        dialog.show();

        okBUtton = dialog.findViewById(R.id.okButton);
        cancelButton = dialog.findViewById(R.id.cancelButton);

        okBUtton.setOnClickListener((v) -> {
            Toast.makeText(context, "결제중", Toast.LENGTH_SHORT).show();
            dialog.dismiss();

            Call<Boolean> result = NetworkHelper.getInstance().getApiService().insertTicket(this.bus.getBusId(), Member.getInstance().getId());
            result.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if (response.body()) {
                        Toast.makeText(context, "결제 완료", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "결제 실패", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Toast.makeText(context, "네트워크 오류", Toast.LENGTH_SHORT).show();
                }
            });

        });

        cancelButton.setOnClickListener((v) -> {
            Toast.makeText(context, "결제 취소", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });
    }
}
