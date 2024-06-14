package kr.ac.uc.beverage_ordering_system.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.uc.beverage_ordering_system.MainActivity;
import kr.ac.uc.beverage_ordering_system.OnE_Activity;
import kr.ac.uc.beverage_ordering_system.R;
import kr.ac.uc.beverage_ordering_system.model.OrderModel;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<OrderModel> data;
    private OnButtonClickListener onButtonClickListener;

    public OrderAdapter(ArrayList<OrderModel> data) {
        this.data = data;
    }

    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerName, tvBeverageName, tvAmount;
        Button btnEdit, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerName = itemView.findViewById(R.id.tvCustomerName);
            tvBeverageName = itemView.findViewById(R.id.tvBeverageName);
            tvAmount = itemView.findViewById(R.id.tvAmount);
            btnEdit = itemView.findViewById(R.id.btnEdit);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

        public void bind(int position) {
            OrderModel orderData = data.get(position);
            tvCustomerName.setText(orderData.getCustomerName());
            tvBeverageName.setText(orderData.getBeverage());
            tvAmount.setText(String.valueOf(orderData.getAmount()));

            btnEdit.setOnClickListener(v -> onButtonClickListener.onEdit(position));

            btnDelete.setOnClickListener(v -> onButtonClickListener.onDelete(position));
        }
    }

    public interface OnButtonClickListener {
        void onEdit(int position);

        void onDelete(int position);
    }
}

