package com.example.lab4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Step 1: Declare ActivityResultLauncher to handle results from SecActivity
    private final ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // Step 12: Check if the result is RESULT_OK
                if (result.getResultCode() == Activity.RESULT_OK) {
                    // Step 13: Retrieve the returned Intent data
                    Intent intent = result.getData();
                    String drink = intent != null ? intent.getStringExtra("drink") : null;
                    String sugar = intent != null ? intent.getStringExtra("sugar") : null;
                    String ice = intent != null ? intent.getStringExtra("ice") : null;

                    // Step 14: Set the text of tvMeal
                    TextView tvMeal = findViewById(R.id.tvMeal);
                    tvMeal.setText("飲料：" + drink + "\n\n甜度：" + sugar + "\n\n冰塊：" + ice);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int leftInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int rightInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottomInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            v.setPadding(leftInset, topInset, rightInset, bottomInset);
            return insets;
        });

        // Step 2: Define component variables and use findViewById to retrieve components
        Button btnChoice = findViewById(R.id.btnChoice);

        // Step 3: Set an OnClickListener for btnChoice
        btnChoice.setOnClickListener(v -> {
            // Step 4: Declare an Intent to switch from MainActivity to SecActivity
            Intent intent = new Intent(MainActivity.this, SecActivity.class);
            // Step 5: Launch the Intent with startForResult
            startForResult.launch(intent);
        });
    }
}
