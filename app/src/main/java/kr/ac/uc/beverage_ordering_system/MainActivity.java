package kr.ac.uc.beverage_ordering_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btAddOrder;
    TextView tvCustomerName, tvBeverageName, tvAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

<<<<<<< Updated upstream
        btAddOrder = findViewById(R.id.btAddOrder);
        btAddOrder.setOnClickListener(v -> goOrder());
=======

>>>>>>> Stashed changes

        tvCustomerName = findViewById(R.id.tvCustomerName);
        tvBeverageName = findViewById(R.id.tvBeverageName);
        tvAmount = findViewById(R.id.tvAmount);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void goOrder() {
<<<<<<< HEAD
        Intent intent = new Intent(MainActivity.this, OnE_Activity.class);
=======
        Intent intent = new Intent(this, OnE_Activity.class);
        startActivity(intent);
        finish();
>>>>>>> 1108bceac19a35443cd967e39964b9b31f182175
    }
}