package kr.ac.uc.beverage_ordering_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class OnE_Activity extends AppCompatActivity {

    EditText etInsertName, etInsertJuice, etInsertAmount;
    Button btnCancel, btnSave;

    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modity);

        etInsertAmount = findViewById(R.id.etInsertAmount);
        etInsertJuice = findViewById(R.id.etInsertJuice);
        etInsertName = findViewById(R.id.etInsertName);
        btnCancel = findViewById(R.id.btnCancel);
        btnSave = findViewById(R.id.btnSave);

        btnCancel.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnSave.setOnClickListener(v -> {
            dataInsert();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void dataInsert(){
        data.add(etInsertName.getText().toString());
        data.add(etInsertJuice.getText().toString());
        data.add(etInsertAmount.getText().toString());
    }
}