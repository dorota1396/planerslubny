package com.example.planerlubny.Add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.planerlubny.R;
import com.example.planerlubny.SessionMenager.SessionManagerDodajGoscia;
import com.example.planerlubny.StartActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DodajActivity extends AppCompatActivity {

    private Button btn_dodaj;
    private Button wroc;
    private EditText nazwisko;
    private EditText numer;
    private EditText imie;
    private Button btn_logout;
    private TextView idd;
    String getId;
    SessionManagerDodajGoscia sessionManager;
    private static String URL_DODAJ = "http://192.168.0.19/register/dodaj_goscia.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj);

        sessionManager = new SessionManagerDodajGoscia(this);
        sessionManager.checkLogin();

       // id=findViewById(R.id.id);
        btn_logout = findViewById(R.id.btn_logout);
        btn_dodaj=findViewById(R.id.btn_dodaj);
        numer=findViewById(R.id.numer);
        nazwisko=findViewById(R.id.nazwisko);
        imie=findViewById(R.id.imie);
        wroc=findViewById(R.id.wroc);
      // idd=findViewById(R.id.idd);

        HashMap<String, String> user =sessionManager.getUserDetail();
        getId = user.get(SessionManagerDodajGoscia.ID);



        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DodajActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });

        btn_dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String mImie =imie.getText().toString().trim();
                final String mNazwisko =nazwisko.getText().toString().trim();
                final String mNumer =numer.getText().toString().trim();

                if(!mImie.isEmpty() &&  !mNazwisko.isEmpty() || !mNumer.isEmpty()) {

                    dodaj(mImie, mNazwisko, mNumer);
                }
                else{
                    Toast.makeText(DodajActivity.this, "Proszę uzupełnić wszystkie dane poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void dodaj(final String imie, final String nazwisko, final String numer){

        btn_dodaj.setVisibility(View.GONE);

        //final String imie =this.imie.getText().toString().trim();
       // final String nazwisko =this.nazwisko.getText().toString().trim();
       // final String numer =this.numer.getText().toString().trim();
        //final String id =this.id.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DODAJ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject =new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Toast.makeText(DodajActivity.this, "Pomyślnie dodano gościa", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e){

                            e.printStackTrace();
                            Toast.makeText(DodajActivity.this, "Nie udało się pomyślnie dodać gościa ", Toast.LENGTH_SHORT).show();

                            btn_dodaj.setVisibility(View.VISIBLE);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(DodajActivity.this, "Brak połączenia sieciowego ", Toast.LENGTH_SHORT).show();

                        btn_dodaj.setVisibility(View.VISIBLE);

                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("imie", imie);
                params.put("nazwisko", nazwisko);
                params.put("numer", numer);
                params.put("id", getId);
               // params.put("id", id);
                return params;
                // return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}