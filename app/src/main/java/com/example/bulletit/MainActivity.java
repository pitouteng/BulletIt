package com.example.bulletit;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.Activity;
        import android.content.Context;
        import android.os.Bundle;
        import android.text.InputType;
        import android.util.Log;
        import android.view.Gravity;
        import android.view.KeyEvent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.inputmethod.EditorInfo;
        import android.view.inputmethod.InputMethodManager;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.PopupWindow;
        import android.widget.TextView;

        import org.w3c.dom.Text;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

public class MainActivity extends AppCompatActivity implements AddTodoitem.AddTodoItemListener {

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
        System.out.println(this.toString());
//        final TextView todoItem = new TextView(this.);

        todoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTodoItemDialog();
            }
        });

//        final EditText zoop = (EditText) findViewById(R.id.zoop);
//        zoop.setun


        dateBtn.setText(dateString);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMonthlyViewActivity();
            }
        });
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void addTodoItemDialog(){
        AddTodoitem addTodoitem = new AddTodoitem();
        addTodoitem.show(getSupportFragmentManager(), "Add Todo Item");
    }

    private void moveToMonthlyViewActivity(){
        android.content.Intent intent = new android.content.Intent(MainActivity.this, MonthlyViewActivity.class);
        startActivity(intent);
    }

    @Override
    public void applyTodoItemn(String todoItem) {
        TextView newTodoItem = new TextView(this);
        newTodoItem.setText(todoItem);
        newTodoItem.setGravity(Gravity.CENTER_VERTICAL);

        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) newTodoItem.getLayoutParams();
//        params.height = getResources().getDimensionPixelSize(R.dimen.todo_text_view_height);
        newTodoItem.setHeight(getResources().getDimensionPixelSize(R.dimen.todo_text_view_height));
        newTodoItem.setPadding(25, 0, 0 , 0);
//        newTodoItem.setLayoutParams(params);

        LinearLayout todoBox = findViewById(R.id.todoBox);
        todoBox.addView(newTodoItem);
    }
}