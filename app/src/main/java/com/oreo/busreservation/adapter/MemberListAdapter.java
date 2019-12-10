package com.oreo.busreservation.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oreo.busreservation.BusDetailActivity;
import com.oreo.busreservation.R;
import com.oreo.busreservation.domain.Bus;
import com.oreo.busreservation.domain.Member;
import com.oreo.busreservation.retrofit.NetworkHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.CustomViewHolder> {

    private List<Member> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView memberID;
        protected TextView memberName;
        protected TextView memberEmail;


        public CustomViewHolder(View view) {
            super(view);
            this.memberID = view.findViewById(R.id.item_text_member_id);
            this.memberName = view.findViewById(R.id.item_text_member_name);
            this.memberEmail = view.findViewById(R.id.item_text_member_email);
        }
    }

    public MemberListAdapter(List<Member> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bus_list, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        // TODO : 여기도 마찬가지로, 백엔드를 건드리지 않게 하는 방법이 있으려나?
        holder.memberID.setText(mList.get(position).getId());
        holder.memberName.setText(mList.get(position).getName());
        holder.memberEmail.setText(mList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
