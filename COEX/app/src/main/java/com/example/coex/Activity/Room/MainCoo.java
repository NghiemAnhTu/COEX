package com.example.coex.Activity.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.coex.R;

public class MainCoo extends AppCompatActivity {
    TextView txtAddRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_coo);
        // init
        init();
        // add room
        onAddRoom();
    }

    // anh xa view
    public void init(){
        txtAddRoom = findViewById(R.id.addRoom);
    }

    // add
    public void onAddRoom(){
        txtAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), NewStypeRoom.class);
                startActivity(intent);
            }
        });
    }
}
