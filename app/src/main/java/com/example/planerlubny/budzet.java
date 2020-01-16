package com.example.planerlubny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerlubny.Add.DodajBudzetActivity;
import com.example.planerlubny.SessionMenager.SessionManagerBudzet;

public class budzet extends AppCompatActivity {

    private Button wroc;
    private Button btn_logout;
    private Button dodaj;
    SessionManagerBudzet sessionManagerBudzet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budzet);

        sessionManagerBudzet=new SessionManagerBudzet(this);
        sessionManagerBudzet.checkLogin();

        btn_logout=findViewById(R.id.btn_logout);
        wroc=(Button)findViewById(R.id.wroc);
        dodaj=findViewById(R.id.dodaj);

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(budzet.this, StartActivity.class);
                startActivity(intent);
            }
        });

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(budzet.this, DodajBudzetActivity.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagerBudzet.logout();
            }
        });
    }
}
