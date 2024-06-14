package kr.ac.uc.beverage_ordering_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.ac.uc.beverage_ordering_system.adapter.OrderAdapter;
import kr.ac.uc.beverage_ordering_system.model.OrderModel;

public class MainActivity extends AppCompatActivity {

    public static final String NEW_ORDER_KEY = "NEW_ORDER";
    public static final String EDIT_ORDER_KEY = "EDIT_ORDER_KEY";
    public static final String POSITION = "POSITION";

    Button btAddOrder;
    RecyclerView recyclerView;
    ArrayList<OrderModel> data = new ArrayList<>();
    OrderAdapter adapter;

    ActivityResultLauncher<Intent> launcher; // Activity 간 데이터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAddOrder = findViewById(R.id.btAddOrder);
        recyclerView = findViewById(R.id.recyclerView);

        btAddOrder.setOnClickListener(v -> goOrder());

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent dataIntent = result.getData();
                        int position = dataIntent.getIntExtra(POSITION, -1);
                        if (position != -1) {
                            OrderModel setOrder = (OrderModel) dataIntent.getSerializableExtra(EDIT_ORDER_KEY);
                            data.set(position, setOrder);
                            adapter.notifyItemChanged(position);
                        } else {
                            OrderModel newOrder = (OrderModel) dataIntent.getSerializableExtra(NEW_ORDER_KEY);
                            data.add(newOrder);
                            adapter.notifyItemInserted(data.size() - 1);
                        }
                    }
                }
        );

        adapter = new OrderAdapter(data);
        adapter.setOnButtonClickListener(new OrderAdapter.OnButtonClickListener() {
            @Override
            public void onEdit(int position) { // 수정
                Intent intent = new Intent(MainActivity.this, OnE_Activity.class);
                intent.putExtra(EDIT_ORDER_KEY, data.get(position));
                intent.putExtra(POSITION, position);
                launcher.launch(intent);
            }

            @Override
            public void onDelete(int position) { // 삭제
                data.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void goOrder() {
        Intent intent = new Intent(this, OnE_Activity.class);
        launcher.launch(intent);
    }
}
