package com.example.lab5;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContentView(R.layout.activity_main);

        findViewById(R.id.main).setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // Convert WindowInsets to WindowInsetsCompat
                WindowInsetsCompat insetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, v);

                int leftInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left;
                int topInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
                int rightInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).right;
                int bottomInset = insetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;

                v.setPadding(leftInset, topInset, rightInset, bottomInset);

                // Return original insets to avoid consuming them
                return insets;
            }
        });

        Log.e("MainActivity", "onCreate");

        // Get the ViewPager2 component
        ViewPager2 viewPager2 = findViewById(R.id.viewPager2);

        // Create ViewPagerAdapter and set it to ViewPager2
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);
        viewPager2.setOffscreenPageLimit(1);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MainActivity", "onDestroy");
    }

    private void enableEdgeToEdge() {
        // Implement this method if needed
    }
}
