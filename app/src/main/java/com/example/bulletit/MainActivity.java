package com.example.bulletit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button dateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateBtn = findViewById(R.id.DateButton);
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("E, MMM dd");
        String dateString = dateFormat.format(currentTime);


        dateBtn.setText(dateString);

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