package com.premsinghdaksha.volleyautomationparsing.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.premsinghdaksha.volleyautomationparsing.R;
import com.premsinghdaksha.volleyautomationparsing.model.DataResponse;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Context mContext;
    List<DataResponse> responseArrayList;

    public MainAdapter(Context mContext, List<DataResponse> responseArrayList) {
        this.mContext = mContext;
        this.responseArrayList = responseArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataResponse model = responseArrayList.get(position);
        holder.name.setText(model.getName());
        holder.description.setText(model.getDescription());
        holder.categorie.setText(model.getCategorie());

    }

    @Override
    public int getItemCount() {
        return responseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, description,categorie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            categorie = itemView.findViewById(R.id.categorie);
        }
    }
}
