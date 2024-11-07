package com.example.lab6;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            int leftInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int topInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int rightInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottomInset = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

            v.setPadding(leftInset, topInset, rightInset, bottomInset);
            return insets;
        });

        // Define component variables and get components by findViewById
        Button btnToast = findViewById(R.id.btnToast);
        Button btnSnackBar = findViewById(R.id.btnSnackBar);
        Button btnDialog1 = findViewById(R.id.btnDialog1);
        Button btnDialog2 = findViewById(R.id.btnDialog2);
        Button btnDialog3 = findViewById(R.id.btnDialog3);

        // Define the array of items to display in the dialog
        String[] items = {"選項 1", "選項 2", "選項 3", "選項 4", "選項 5"};

        // Set button click listeners
        btnToast.setOnClickListener(v -> showToast("預設 Toast"));

        btnSnackBar.setOnClickListener(v ->
                Snackbar.make(v, "按鈕式 Snackbar", Snackbar.LENGTH_SHORT)
                        .setAction("按鈕", view -> showToast("已回應"))
                        .show()
        );

        btnDialog1.setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("按鈕式 AlertDialog")
                        .setMessage("AlertDialog 內容")
                        .setNeutralButton("左按鈕", (dialogInterface, which) -> showToast("左按鈕"))
                        .setNegativeButton("中按鈕", (dialogInterface, which) -> showToast("中按鈕"))
                        .setPositiveButton("右按鈕", (dialogInterface, which) -> showToast("右按鈕"))
                        .show()
        );

        btnDialog2.setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("列表式 AlertDialog")
                        .setItems(items, (dialogInterface, i) -> showToast("你選的是" + items[i]))
                        .show()
        );

        btnDialog3.setOnClickListener(v -> {
            // Declare position to store the selected item
            final int[] position = {0}; // Needs to be an array for inner class access
            new AlertDialog.Builder(this)
                    .setTitle("單選式 AlertDialog")
                    .setSingleChoiceItems(items, 0, (dialogInterface, i) -> position[0] = i)
                    .setPositiveButton("確定", (dialog, which) -> showToast("你選的是" + items[position[0]]))
                    .show();
        });
    }

    // Create a showToast method to display Toast messages
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void enableEdgeToEdge() {
        // Implement this method if necessary
    }
}
