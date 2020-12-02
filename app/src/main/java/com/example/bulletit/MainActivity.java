package com.example.bulletit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.format.Time;
        import android.view.Gravity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

public class MainActivity extends AppCompatActivity implements AddTodoItem.AddTodoItemListener,AddEventItem.AddEventItemListener  {

    private android.widget.Button dateBtn;
    private Object MainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateBtn = findViewById(R.id.DateButton);
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("E MMM dd");
        String dateString = dateFormat.format(currentTime);

        final TextView todoView = (TextView) findViewById(R.id.todo);
        todoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTodoItemDialog();
            }
        });

        final View eventView = (View) findViewById(R.id.addEvent);
        eventView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEventItemDialog();
            }
        });


        dateBtn.setText(dateString);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMonthlyViewActivity();
            }
        });
    }

    public void addTodoItemDialog(){
        AddTodoItem addTodoItem = new AddTodoItem();
        addTodoItem.show(getSupportFragmentManager(), "Add Todo Item");
    }

    @Override
    public void applyTodoItem(String todoItem) {
        TextView newTodoItem = new TextView(this);
        newTodoItem.setText(todoItem);
        newTodoItem.setGravity(Gravity.CENTER_VERTICAL);

        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) newTodoItem.getLayoutParams();
        newTodoItem.setHeight(getResources().getDimensionPixelSize(R.dimen.todo_text_view_height));
        newTodoItem.setPadding(25, 0, 0 , 0);

        LinearLayout todoBox = findViewById(R.id.todoBox);
        todoBox.addView(newTodoItem);
    }

    public void addEventItemDialog(){
        AddEventItem addEventItem = new AddEventItem();
        addEventItem.show(getSupportFragmentManager(), "Add Event Item");

    }

    @Override
    public void applyEventItem(String title_string, String startTime_hr, String startTime_min, String startTime_amPm, String duration_string) {

        System.out.println("Title: " + title_string);
        System.out.println("Start Time: " + startTime_hr + ":" + startTime_min+ " " + startTime_amPm);
        System.out.println("Duration: " + duration_string);

        TextView newEventItem = new TextView(this);
        newEventItem.setText(title_string);
        newEventItem.setGravity(Gravity.CENTER_VERTICAL);
        newEventItem.setPadding(25, 0, 0 , 0);

        float scale = getResources().getDisplayMetrics().density;


        int height = (int) ((Integer.parseInt(duration_string)) * scale);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
//        RelativeLayout.LayoutParams dummy_params = dummy.getLayoutParams();
//        params.set


        int hr = Integer.parseInt(startTime_hr);
        if (startTime_amPm == "PM") {
            if (hr < 12){
                hr = hr + 12;
            }
        } else if (startTime_amPm == "AM" && hr == 12) {
            hr = 0;
        }
        int total_minute = (hr * 60) + Integer.parseInt(startTime_min) - 30;
        int marginTop = (int) (total_minute * scale);
        System.out.println("minute: " + Integer.parseInt(startTime_min));
        System.out.println("margin_top: " + marginTop);
        System.out.println("scale: "+ scale);

        params.setMargins(0, marginTop, 0, 0 );
//        params.height = Integer.parseInt(duration_string);
        newEventItem.setLayoutParams(params);
        newEventItem.setHeight(height);
        newEventItem.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

        // set duration / the height of the text view
        // set startTime / the placement - android:layout_marginTop="60dp"


        RelativeLayout eventBox = findViewById(R.id.eventBox);
        eventBox.addView(newEventItem);


    }
    private void moveToMonthlyViewActivity(){
        android.content.Intent intent = new android.content.Intent(MainActivity.this, MonthlyViewActivity.class);
        startActivity(intent);
    }
}