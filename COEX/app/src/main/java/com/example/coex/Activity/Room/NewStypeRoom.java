package com.example.coex.Activity.Room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.coex.R;

public class NewStypeRoom extends AppCompatActivity {
    EditText edtStyleRoom, edtAboutRoom, edtPrice, edtPer;
    Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_style_room);
        // init
        init();

    }

    // init
    public void init(){
        edtStyleRoom = findViewById(R.id.edtStyleRoom);
        edtAboutRoom = findViewById(R.id.edtAboutRoom);
        edtPrice = findViewById(R.id.edtPrice);
        edtPer = findViewById(R.id.edtMaxPer);
        btnCreate = findViewById(R.id.btnCreateStyle);
    }


}
