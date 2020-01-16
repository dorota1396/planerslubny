package com.example.planerlubny;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.planerlubny.SessionMenager.SessionManagerInspiracje;

public class inspiracje extends AppCompatActivity {

    private Button wroc;
    private Button btn_logout;
    SessionManagerInspiracje sessionManagerInspiracje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiracje);
        sessionManagerInspiracje=new SessionManagerInspiracje(this);
        sessionManagerInspiracje.checkLogin();

        btn_logout=findViewById(R.id.btn_logout);
        wroc=(Button)findViewById(R.id.wroc);

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inspiracje.this, StartActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManagerInspiracje.logout();
            }
        });
    }
}
