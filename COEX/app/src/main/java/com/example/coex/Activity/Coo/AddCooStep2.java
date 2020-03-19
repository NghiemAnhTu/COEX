package com.example.coex.Activity.Coo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.coex.Activity.Room.MainCoo;
import com.example.coex.Activity.Room.NewStypeRoom;
import com.example.coex.R;

public class AddCooStep2 extends AppCompatActivity {
    Button btnNextStep, btnAddOther;
    Button btnAddRoom;
    CheckBox cW, cD, cA, cC,cP;
    EditText edtOther;
    ImageButton imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_coo_step_2);
        // init
        init();
        // back step 1
        onBack();
        // add other
        onAddOther();
        // add room
        onAddStyleRoom();
        // next step
        onNextStep();
    }

    // anh xa view
    public void init(){
        imgBack = findViewById(R.id.imgBackList);
        cW = findViewById(R.id.checkWifi);
        cD = findViewById(R.id.checkDrink);
        cC = findViewById(R.id.checkCon);
        cA = findViewById(R.id.checkAir);
        cP = findViewById(R.id.checkPrinter);
        edtOther = findViewById(R.id.edtAddOtherNew);
        btnAddOther = findViewById(R.id.btnAddOtherNew);
        btnAddRoom = findViewById(R.id.btnAddMoreStyleRoom);
        btnNextStep = findViewById(R.id.btnNextStep2);
    }

    // on click step 3
    public void onNextStep(){
        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), DetailCoo.class);
                startActivity(intent);
                // xu li
            }
        });
    }

    // on add style room
    public void onAddStyleRoom(){
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), NewStypeRoom.class);
                startActivity(intent);
                // xu li
            }
        });
    }

    // add other
    public void onAddOther(){
        btnAddOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = edtOther.getText().toString();
                if (tmp.length() > 0){
                    Toast.makeText(getApplication(), tmp, Toast.LENGTH_SHORT).show();
                }
            }
        });
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


}
