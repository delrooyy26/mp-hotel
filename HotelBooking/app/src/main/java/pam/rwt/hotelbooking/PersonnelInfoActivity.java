package pam.rwt.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PersonnelInfoActivity extends AppCompatActivity {
    EditText edAddress, edName, edPhone, edEmail, edNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personnel_info);
        Button btnSave = findViewById(R.id.button);
        edAddress = findViewById(R.id.edAddress);
        edName = findViewById(R.id.edName);
        edPhone = findViewById(R.id.edPhone);
        edEmail = findViewById(R.id.edEmail);
        edNum = findViewById(R.id.edNum);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edName.getText().toString().equals("")) {
                    Toast.makeText(PersonnelInfoActivity.this, "Please enter Name", Toast.LENGTH_SHORT).show();
                } else if (edEmail.getText().toString().equals("")) {
                    Toast.makeText(PersonnelInfoActivity.this, "Please enter Email", Toast.LENGTH_SHORT).show();
                } else if (edPhone.getText().toString().equals("")) {
                    Toast.makeText(PersonnelInfoActivity.this, "Please enter Phone", Toast.LENGTH_SHORT).show();
                } else if (edAddress.getText().toString().equals("")) {
                    Toast.makeText(PersonnelInfoActivity.this, "Please enter Address", Toast.LENGTH_SHORT).show();
                } else if (edNum.getText().toString().equals("")) {
                    Toast.makeText(PersonnelInfoActivity.this, "Please enter Number of Person", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(PersonnelInfoActivity.this, RoomInfoActivity.class);
                    i.putExtra("name", edName.getText().toString());
                    i.putExtra("address", edAddress.getText().toString());
                    i.putExtra("phone", edPhone.getText().toString());
                    i.putExtra("numberofperson", edNum.getText().toString());
                    i.putExtra("email", edEmail.getText().toString());
                    startActivity(i);
                }
            }
        });

    }
}