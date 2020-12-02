package com.example.bulletit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.DecimalFormat;

public class AddEventItem extends AppCompatDialogFragment {
    private EditText editText_title;
    private TextView textView_startTime_hr;
    private TextView textView_startTime_min;
    private TextView textView_startTime_amPm;
    private View view_startTime_box;
    private EditText editText_duration;
    private AddEventItem.AddEventItemListener listener;
    private TimePickerDialog timePickerDialog;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_event_popup, null);

        builder.setView(view)
                .setTitle("Event")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = editText_title.getText().toString();
                        String startTime_hr = textView_startTime_hr.getText().toString();
                        String startTime_min = textView_startTime_min.getText().toString();
                        String startTime_amPm = textView_startTime_amPm.getText().toString();
                        String duration = editText_duration.getText().toString();
                        System.out.println("IN ADD EVENT ITEM: ");
                        System.out.println("title: " + title);
                        System.out.println("startime hr " + startTime_hr);

                        listener.applyEventItem(title, startTime_hr, startTime_min, startTime_amPm, duration);
                    }
                });

        editText_title = view.findViewById(R.id.editText_event_title);
        textView_startTime_hr = view.findViewById(R.id.hrTextView);
        textView_startTime_min = view.findViewById(R.id.minTextView);
        textView_startTime_amPm = view.findViewById(R.id.amPm);
        editText_duration = view.findViewById(R.id.editText_duration);
        view_startTime_box = view.findViewById(R.id.startTimeBox);
        view_startTime_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        DecimalFormat formatter = new DecimalFormat("00");
                        if (hourOfDay >= 12) {
                            textView_startTime_amPm.setText("PM");
                        } else {
                            textView_startTime_amPm.setText("AM");
                        }
                        int hr = hourOfDay;
                        int min = minute;

                        if (hourOfDay == 0) {
                            textView_startTime_hr.setText("12");
                        } else if (hourOfDay > 12) {
                            textView_startTime_hr.setText(formatter.format(hr-12));
                        } else {
                            textView_startTime_hr.setText(formatter.format(hr));
                            textView_startTime_min.setText(formatter.format(min));
                        }

                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }
        });


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (AddEventItem.AddEventItemListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement AddEventItemDialog");
        }


    }

    public interface AddEventItemListener{
        void applyEventItem(String title, String startTime_hr, String startTime_min, String startTime_amPm, String duration);
    }
}
