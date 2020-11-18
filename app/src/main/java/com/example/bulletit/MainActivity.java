package com.example.bulletit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button dateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateBtn = findViewById(R.id.DateButton);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMonthlyViewActivity();
            }
        });
    }

    private void moveToMonthlyViewActivity(){
        android.content.Intent intent = new android.content.Intent(MainActivity.this, MonthlyViewActivity.class);
        startActivity(intent);
    }
}