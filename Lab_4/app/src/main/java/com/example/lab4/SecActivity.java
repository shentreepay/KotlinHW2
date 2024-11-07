package com.example.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        // Apply window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int leftInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int rightInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottomInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

            v.setPadding(leftInset, topInset, rightInset, bottomInset);
            return insets;
        });

        // Step6: Define component variables and get the components using findViewById
        TextView edDrink = findViewById(R.id.edDrink);
        RadioGroup rgSugar = findViewById(R.id.rgSugar);
        RadioGroup rgIce = findViewById(R.id.rgIce);
        Button btnSend = findViewById(R.id.btnSend);

        // Step7: Set click listener for btnSend
        btnSend.setOnClickListener(v -> {
            // Step8: If edDrink is empty, show a toast message
            if (edDrink.getText().toString().isEmpty()) {
                Toast.makeText(SecActivity.this, "請輸入飲料名稱", Toast.LENGTH_SHORT).show();
            } else {
                // Step9: Create a bundle and add the drink name, sugar, and ice values to the bundle
                String drink = edDrink.getText().toString();
                String sugar = ((RadioButton) findViewById(rgSugar.getCheckedRadioButtonId())).getText().toString();
                String ice = ((RadioButton) findViewById(rgIce.getCheckedRadioButtonId())).getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("drink", drink);
                bundle.putString("sugar", sugar);
                bundle.putString("ice", ice);

                // Step10: Create an intent and put the bundle into the intent
                Intent intent = new Intent();
                intent.putExtras(bundle);

                // Step11: Set the result for the activity and finish the activity
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
