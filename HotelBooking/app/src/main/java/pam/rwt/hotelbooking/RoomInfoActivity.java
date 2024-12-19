package pam.rwt.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RoomInfoActivity extends AppCompatActivity {
    Calendar myCalendar;
    EditText edittext, edCheckout, edNum;
    String name, email, phone, address, numberofperson;
    Spinner spinnerType;
    Button btnPreview;
    String roomType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        address = i.getStringExtra("address");
        numberofperson = i.getStringExtra("numberofperson");


        myCalendar = Calendar.getInstance();

        edittext = (EditText) findViewById(R.id.edCheckin);
        edCheckout = (EditText) findViewById(R.id.edCheckout);
        spinnerType = findViewById(R.id.spinnerType);
        btnPreview = findViewById(R.id.btnPreview);
        edNum = findViewById(R.id.edNum);

        spinnerType.setSelection(MainActivity.roomType);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edittext.getText().toString().equals("")) {
                    Toast.makeText(RoomInfoActivity.this, "Please Enter Checkin Date", Toast.LENGTH_SHORT).show();
                } else if (edCheckout.getText().toString().equals("")) {
                    Toast.makeText(RoomInfoActivity.this, "Please Enter Checkout Date", Toast.LENGTH_SHORT).show();
                } else if (edNum.getText().toString().equals("")) {
                    Toast.makeText(RoomInfoActivity.this, "Please Enter Number of Rooms you want to Book", Toast.LENGTH_SHORT).show();
                } else if (spinnerType.getSelectedItem().toString().contains("Select")) {
                    Toast.makeText(RoomInfoActivity.this, "Please Enter Room Type", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(RoomInfoActivity.this, FinalActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("address", address);
                    i.putExtra("phone", phone);
                    i.putExtra("numberofperson", numberofperson);
                    i.putExtra("email", email);
                    i.putExtra("roomType", spinnerType.getSelectedItem().toString());
                    i.putExtra("checkin", edittext.getText().toString());
                    i.putExtra("checkout", edCheckout.getText().toString());
                    i.putExtra("num", edNum.getText().toString());
                    startActivity(i);
                }
            }
        });


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, edittext);
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RoomInfoActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(myCalendar, edCheckout);
            }

        };

        edCheckout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RoomInfoActivity.this, date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }


    private void updateLabel(Calendar myCalendar, EditText edittext) {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }
}