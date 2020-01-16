package com.example.planerlubny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerlubny.Add.DodajActivity;
import com.example.planerlubny.Edit.EdytujActivity;
import com.example.planerlubny.Remove.UsunActivity;
import com.example.planerlubny.SessionMenager.SessionManagerGoscie;

public class goscie extends AppCompatActivity {

    private Button wroc;
    private Button dodaj;
    private Button edytuj;
    private Button usun;
    private Button btn_logout;
    private ListView listView;

    private TextView imie;




    SessionManagerGoscie sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goscie);

        sessionManager = new SessionManagerGoscie(this);
        sessionManager.checkLogin();

        btn_logout = findViewById(R.id.btn_logout);
        imie = findViewById(R.id.imie);
        wroc = (Button) findViewById(R.id.wroc);
        dodaj = (Button) findViewById(R.id.dodaj);
        edytuj = (Button) findViewById(R.id.edytuj);
        usun = (Button) findViewById(R.id.usun);




        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(goscie.this, StartActivity.class);
                startActivity(intent);
            }
        });

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(goscie.this, DodajActivity.class);
                startActivity(intent);
            }
        });

        edytuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(goscie.this, EdytujActivity.class);
                startActivity(intent);
            }
        });
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(goscie.this, UsunActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });



    }



}
