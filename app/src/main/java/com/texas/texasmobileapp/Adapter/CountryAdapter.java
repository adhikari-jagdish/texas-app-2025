package com.texas.texasmobileapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.texas.texasmobileapp.Model.CountryModel;
import com.texas.texasmobileapp.R;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    ArrayList<CountryModel> countryList;

    public CountryAdapter (Context activityContext, ArrayList<CountryModel> countryList){
        this.context = activityContext;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_country_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int index) {
        final CountryModel countryModel = countryList.get(index);
        holder.customCountryCardImage.setImageResource(countryModel.getIcon());
        holder.customCountrycardTextView.setText(countryModel.getName());
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{
    ImageView customCountryCardImage;
    TextView customCountrycardTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        customCountryCardImage = itemView.findViewById(R.id.iv_custom_country_card);
        customCountrycardTextView = itemView.findViewById(R.id.tv_custom_country_card);
    }
}
