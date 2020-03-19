package com.example.coex.Activity.Coo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.coex.Activity.Booking.Booking;
import com.example.coex.Activity.Room.MainCoo;
import com.example.coex.R;

public class DetailCoo extends AppCompatActivity {
    TextView txtViewMore;
    ImageButton imgBack;
    Button btnSeeDates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_coo);
        // init
        init();
        // back
        onBack();
        // next
        onSeeDates();
        // view service
        onViewMore();
    }

    // anh xa view
    public void init(){
        txtViewMore = findViewById(R.id.view_more);
        btnSeeDates = findViewById(R.id.btnSeeDates);
        imgBack = findViewById(R.id.imgBackList);
    }
    // back
    public void onBack(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    // view more
    public void onViewMore(){
        txtViewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }

    // on see date
    public void onSeeDates(){
        btnSeeDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), Booking.class);
                startActivity(intent);
            }
        });
    }

    //

}
