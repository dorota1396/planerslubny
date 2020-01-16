package com.example.planerlubny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerlubny.Add.DodajWykonawceActivity;
import com.example.planerlubny.SessionMenager.SessionManagerWykonawcy;

public class wykonawcy extends AppCompatActivity {

    private Button wroc;
    private Button dodaj;
    private Button btn_logout;
    SessionManagerWykonawcy sessionManagerWykonawcy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wykonawcy);

        sessionManagerWykonawcy=new SessionManagerWykonawcy(this);
        sessionManagerWykonawcy.checkLogin();

        btn_logout=findViewById(R.id.btn_logout);
        wroc=(Button)findViewById(R.id.wroc);
        dodaj=(Button)findViewById(R.id.dodaj);

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wykonawcy.this, StartActivity.class);
                startActivity(intent);
            }
        });
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(wykonawcy.this, DodajWykonawceActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagerWykonawcy.logout();
            }
        });

    }
}
