package com.example.bulletit;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.view.View.OnClickListener;

import android.os.Bundle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MonthlyViewActivity extends AppCompatActivity {

    CalendarView calendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_view);

        CalendarView calendarView=(CalendarView) findViewById(R.id.calendarView3);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Calendar c = Calendar.getInstance();
                c.set(year, month, dayOfMonth, 0, 0);
                Date currentTime = c.getTime();
                DateFormat dateFormat = new SimpleDateFormat("E MMM dd");
                String dateString = dateFormat.format(currentTime);
                moveToDailyViewActivity(dateString);
            }
        });
    }

    private void moveToDailyViewActivity(String dateString){
        android.content.Intent intent = new android.content.Intent(MonthlyViewActivity.this, MainActivity.class);
        //Date currentTime = Calendar.getInstance().getTime();
        //DateFormat dateFormat = new SimpleDateFormat("E MMM dd");
        //String dateString = dateFormat.format(currentTime);
        intent.putExtra("date", dateString);
        startActivity(intent);
    }
}