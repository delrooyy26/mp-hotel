package pam.rwt.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBookNowSingle, btnBookNowDouble, btnBookNowDeluxe;
    public static int roomType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBookNowSingle = findViewById(R.id.btnBookNowSingle);
        btnBookNowDouble = findViewById(R.id.btnBookNowDouble);
        btnBookNowDeluxe = findViewById(R.id.btnBookNowDeluxe);
        btnBookNowSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PersonnelInfoActivity.class);
                roomType = 1;
                startActivity(i);
            }
        });
        btnBookNowDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PersonnelInfoActivity.class);
                roomType = 2;
                startActivity(i);
            }
        });
        btnBookNowDeluxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PersonnelInfoActivity.class);
                roomType = 3;
                startActivity(i);
            }
        });

    }
}