package kr.ac.uc.beverage_ordering_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import kr.ac.uc.beverage_ordering_system.model.OrderModel;

public class OnE_Activity extends AppCompatActivity {

    EditText etInsertCustomerName, etInsertBeverage, etInsertAmount;
    Button btnCancel, btnSave;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_and_edit);

        etInsertAmount = findViewById(R.id.etInsertAmount);
        etInsertBeverage = findViewById(R.id.etInsertBeverage);
        etInsertCustomerName = findViewById(R.id.etInsertCustomerName);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);


        Intent intent = getIntent();

        // 수정 모드 Effect
        if (intent != null && intent.hasExtra(MainActivity.EDIT_ORDER_KEY)) {
            OrderModel order = (OrderModel) intent.getSerializableExtra(MainActivity.EDIT_ORDER_KEY);
            position = intent.getIntExtra(MainActivity.POSITION, -1);
            if (order != null) {
                etInsertCustomerName.setText(order.getCustomerName());
                etInsertBeverage.setText(order.getBeverage());
                etInsertAmount.setText(String.valueOf(order.getAmount()));
            }
        }

        // 취소 기능
        btnCancel.setOnClickListener(v -> finish());

        // 저장 기능(수정, 생성 동일)
        btnSave.setOnClickListener(v -> {
            // 입력된 정보 받아오기
            String customerName = etInsertCustomerName.getText().toString();
            String beverage = etInsertBeverage.getText().toString();
            int amount = Integer.parseInt(etInsertAmount.getText().toString());


            OrderModel setOrder = new OrderModel(customerName, beverage, amount);

            Intent resultIntent = new Intent();

            if (position >= 0) {// 수정기능
                resultIntent.putExtra(MainActivity.EDIT_ORDER_KEY, setOrder);
                resultIntent.putExtra(MainActivity.POSITION, position);
            } else { // 생성기능
                resultIntent.putExtra(MainActivity.NEW_ORDER_KEY, setOrder);
            }

            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
