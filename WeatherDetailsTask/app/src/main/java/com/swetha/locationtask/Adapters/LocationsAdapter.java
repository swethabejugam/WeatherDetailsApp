package com.swetha.locationtask.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.swetha.locationtask.AdapterModel;
import com.swetha.locationtask.R;
import com.swetha.locationtask.databinding.ItemLocationBinding;

import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder> {
    private LiveData<List<AdapterModel>> locationsList;
    private LocationsAdapterListener listener;
    private LayoutInflater layoutInflater;

    public LocationsAdapter(LiveData<List<AdapterModel>> locationsList, LocationsAdapterListener listener) {
        this.listener = listener;
        this.locationsList = locationsList;
    }

    @NonNull
    @Override
    public LocationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemLocationBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_location, parent, false);
        return new LocationsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationsViewHolder holder, final int position) {
        holder.itemLocationBinding.setModel(locationsList.getValue().get(position));//location.setText(locationsList.get(position).getLocation().toString());
        holder.itemLocationBinding.location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (listener != null) {
                    listener.onLocationClicked(locationsList.getValue().get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        System.out.println("size:"+locationsList.getValue().size());
        return locationsList.getValue().size();
    }

    static class LocationsViewHolder extends RecyclerView.ViewHolder {

        ItemLocationBinding itemLocationBinding;

        LocationsViewHolder(@NonNull ItemLocationBinding itemView) {
            super(itemView.getRoot());
            this.itemLocationBinding = itemView;
        }
    }

//    public void setLocationsList(LiveData<List<AdapterModel>> locationsList) {
//        this.locationsList = locationsList;
//        notifyDataSetChanged();
//    }

    public interface LocationsAdapterListener {
        void onLocationClicked(AdapterModel model);
    }
}
