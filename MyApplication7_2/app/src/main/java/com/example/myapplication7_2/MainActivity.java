package com.example.myapplication7_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private int year;
    private int day;
    private int month;

    private int minute;

    private int hour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       SetData();


    }

    public void SetData(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDayOfMonth) {
                TimeSet();
                year = selectedYear;
                month = selectedMonth;
                day = selectedDayOfMonth;
            }
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainActivity.this,
                dateSetListener,
                year, // текущий год
                month, // текущий месяц
                day); // текущий день
        datePickerDialog.show();
    }
    public void YouSure(){
        // Создание строителя диалоговых окон
        AlertDialog.Builder builder = new
                AlertDialog.Builder(MainActivity.this);
// Установка заголовка и сообщения диалогового окна
        builder.setTitle("Подтверждение");
        builder.setMessage("Вы уверены, что хотите выполнить это действие?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
// Установка кнопки "Да" и ее обработчика
        builder.setPositiveButton("Да", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MoveToFragment();
                    }
                });
// Установка кнопки "Отмена" и ее обработчика
        builder.setNegativeButton("Отмена", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        SetData();
                    }
                });
// Создание и отображение AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();}

    public void TimeSet() {
        // Создание и отображение TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int
                            hourOfDay, int minuteOfDay) {
                        hour = hourOfDay;
                        minute = minuteOfDay;
                        YouSure();
                    }
                }, hour, minute, true); // Использование 24- часового формата
        timePickerDialog.show();
    }

    public void YouSureSure(){
        // Создание диалога
        Dialog dialog = new Dialog(MainActivity.this);
// Установка макета для диалогового окна
        dialog.setContentView(R.layout.custom_dialog);
// Настройка элементов в макете
        Button buttonYes = dialog.findViewById(R.id.buttonYes);
        Button buttonNo = dialog.findViewById(R.id.buttonNo);
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                SetData();
            }
        });
// Отображение диалогового окна
        dialog.show();
    }

    public void MoveToFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment1 fragment1 = new Fragment1();
        fragment1.setDateInformation(year, month, day);
        fragment1.setTimeInformation(hour, minute);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        YouSureSure();
    }


}