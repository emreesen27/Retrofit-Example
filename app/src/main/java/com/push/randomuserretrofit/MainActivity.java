package com.push.randomuserretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.push.randomuserretrofit.Models.Repository;
import com.push.randomuserretrofit.Models.ResultsItem;
import com.push.randomuserretrofit.RestApi.ManagerAll;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Repository list;
    private List<ResultsItem> resultsItem;
    private String pictureUrl;
    private ImageView userImage;
    private TextView txtName, txtEmail, txtPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineView();
        request();
    }

    private void defineView() {
        userImage = findViewById(R.id.user_image);
        txtName = findViewById(R.id.txt_name);
        txtEmail = findViewById(R.id.txt_email);
        txtPhone = findViewById(R.id.txt_phone);
    }

    private void setUserImage(String url) {
        Picasso.get().load(url).resize(120, 120).into(userImage);
    }

    public void randomUser(View view) {
        request();
    }

    private void request() {
        list = new Repository();
        Call<Repository> call = ManagerAll.getInstance().getCall();
        call.enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    resultsItem = list.getResults();
                    pictureUrl = resultsItem.get(0).getPicture().getLarge();
                    String first = resultsItem.get(0).getName().getFirst();
                    String last = resultsItem.get(0).getName().getLast();
                    String name = first + " " + last;
                    String email = resultsItem.get(0).getEmail();
                    String phone = resultsItem.get(0).getPhone();


                    setUserImage(pictureUrl);
                    txtName.setText(name);
                    txtEmail.setText(email);
                    txtPhone.setText(phone);
                }
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                Log.e("err", t.getMessage());
            }
        });
    }

}



