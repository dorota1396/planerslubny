package com.example.planerlubny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerlubny.SessionMenager.SessionManager;

import java.util.HashMap;

public class StartActivity extends AppCompatActivity {

    private Button goscie;
    private Button wykonawcy;
    private Button budzet;
    private Button inspiracje;
    private TextView name;
    private Button btn_logout;
    SessionManager sessionManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        sessionManager=new SessionManager(this);
        sessionManager.checkLogin();

        btn_logout=findViewById(R.id.btn_logout);
        goscie=findViewById(R.id.goscie);
        wykonawcy=findViewById(R.id.wykonawcy);
        budzet=findViewById(R.id.budzet);
        inspiracje=findViewById(R.id.inspiracje);

        name=findViewById(R.id.name);

        HashMap<String, String> user =sessionManager.getUserDetail();
        String mName = user.get(SessionManager.NAME);

        name.setText(mName);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });



        goscie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, goscie.class);
                startActivity(intent);
            }
        });

        wykonawcy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, wykonawcy.class);
                startActivity(intent);
            }
        });

        budzet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, budzet.class);
                startActivity(intent);
            }
        });

        inspiracje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, inspiracje.class);
                startActivity(intent);
            }
        });


    }



}
