package kr.ac.uc.beverage_ordering_system.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter, RecyclerView.ViewHolder> {

    Context context;
    ArrayList<String> data = new ArrayList<>();


    @NonNull
    @Override
    public OrderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
