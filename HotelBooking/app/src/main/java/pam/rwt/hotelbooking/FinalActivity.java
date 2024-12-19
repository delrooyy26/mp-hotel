package pam.rwt.hotelbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import pam.rwt.hotelbooking.network.ApiInterface;
import pam.rwt.hotelbooking.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalActivity extends AppCompatActivity {
    String name, email, phone, address, numberofperson;
    String roomType, CheckinDate, CheckoutDate, numberOfRooms;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        TextView textView = findViewById(R.id.tv1);
         btnSubmit = findViewById(R.id.btnSubmit);

        Intent i = getIntent();
        name = i.getStringExtra("name");
        email = i.getStringExtra("email");
        phone = i.getStringExtra("phone");
        address = i.getStringExtra("address");
        numberofperson = i.getStringExtra("numberofperson");
        roomType = i.getStringExtra("roomType");
        CheckinDate = i.getStringExtra("checkin");
        CheckoutDate = i.getStringExtra("checkout");
        numberOfRooms = i.getStringExtra("num");

        textView.setText(
                "Name " + name +
                        "\nemail " + email +
                        "\nphone " + phone +
                        "\naddress " + address +
                        "\nnumberofperson " + numberofperson +
                        "\nroomType " + roomType +
                        "\nCheckinDate " + CheckinDate +
                        "\nCheckoutDate " + CheckoutDate +
                        "\nnumberOfRooms " + numberOfRooms
        );

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postSaversData();
            }
        });

    }


    public void postSaversData() {
       
            final ProgressDialog progressDialoglocation = new ProgressDialog(FinalActivity.this);
            progressDialoglocation.setMessage("please wait while..saving your data to server");
            progressDialoglocation.show();
            progressDialoglocation.setCancelable(false);
            Call<String> call = null;
            ApiInterface mapiClinet = RetrofitClientInstance.getApiClient();
            call = mapiClinet.postData(getPart(name), getPart(email), getPart(phone),
                    getPart(address), getPart(numberofperson), getPart(roomType), getPart(CheckinDate), 
                    getPart(CheckoutDate), getPart(numberOfRooms)
            );
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {


                    if (response.body() != null) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }else {
                        Log.e("response.errorBody()",response.errorBody().toString());
                        Toast.makeText(getApplicationContext(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                    progressDialoglocation.dismiss();
                    Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(i);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("t.getMessage()",t.getMessage());
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    progressDialoglocation.dismiss();

                }
            });
        }
    private RequestBody getPart(String name) {
        if (name == null) {
            return RequestBody.create(MediaType.parse("text/plain"), "");
        } else {
            return RequestBody.create(MediaType.parse("text/plain"), name);
        }
    }

}