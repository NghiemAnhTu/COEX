package com.example.coex.Activity.Coo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.coex.Activity.Room.MainCoo;
import com.example.coex.R;

public class AddCooStep1 extends AppCompatActivity {
    EditText edtNameSpace;
    EditText edtAddress;
    EditText edtAboutSpace;
    Button btnNextStep;
    ImageButton imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_coo_step_1);
        // anh xa
        init();
        // click next step 2
        onNextStep();
        // back
        onBack();

    }

    // anh xa
    public void init(){
        edtNameSpace = findViewById(R.id.edtNameSpace);
        edtAddress = findViewById(R.id.edtNewAddressCoo);
        edtAboutSpace = findViewById(R.id.edtAboutSpaceNew);
        btnNextStep = findViewById(R.id.btnStep1);
        imgBack = findViewById(R.id.imgBackList);

    }

    // on click button
    public void onNextStep(){
        btnNextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), AddCooStep2.class);
                startActivity(intent);
            }
        });
    }

    // on click back
    public void onBack(){
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainCoo.class);
                startActivity(intent);
            }
        });
    }
}
