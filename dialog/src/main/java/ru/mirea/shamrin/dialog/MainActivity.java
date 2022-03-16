package ru.mirea.shamrin.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickShowDialog(View view) {
        AlertDialogFragment dialogFragment = new AlertDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();

    }
    // Кнопка вызова диалогового окна Time
    public void onClickShowTime(View view) {
        MyTimeDialogFragment timeDialogFragment = new MyTimeDialogFragment();
        new TimePickerDialog(MainActivity.this, timeDialogFragment.t,
                timeDialogFragment.time.get(Calendar.HOUR_OF_DAY),
                timeDialogFragment.time.get(Calendar.MINUTE), true)
                .show();
    }
    // Кнопка вызова диалогового окна Date
    public void onClickShowDate(View view)
    {
        MyDateDialogFragment dateDialogFragment = new MyDateDialogFragment();
        new DatePickerDialog(MainActivity.this, dateDialogFragment.d,
                dateDialogFragment.date.get(Calendar.YEAR),
                dateDialogFragment.date.get(Calendar.MONTH),
                dateDialogFragment.date.get(Calendar.DAY_OF_MONTH))
                .show();
    }
    // Кнопка вызова диалогового окна Progress
    public void onCLickShowProgress(View view)
    {
        ProgressDialog progressDialogFragment = new ProgressDialog(MainActivity.this);
        progressDialogFragment.setTitle("Progress");
        progressDialogFragment.setMessage("Please wait");
        progressDialogFragment.setButton(Dialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which) { }
        });
        progressDialogFragment.show();
    }
}