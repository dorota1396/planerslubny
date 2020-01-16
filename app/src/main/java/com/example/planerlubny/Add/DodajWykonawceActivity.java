package com.example.planerlubny.Add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.planerlubny.R;
import com.example.planerlubny.SessionMenager.SessionManagerDodajWykonawce;
import com.example.planerlubny.wykonawcy;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DodajWykonawceActivity extends AppCompatActivity {

    private Button btn_logout;
    private Button btn_dodaj;
    private Button wroc;
    private EditText usluga;
    private EditText numer;
    private EditText nazwa;
    String getId;
    SessionManagerDodajWykonawce sessionManager;
    private static String URL_DODAJ = "http://192.168.0.19/register/dodaj_wykonawce.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_wykonawce);
        sessionManager = new SessionManagerDodajWykonawce(this);
        sessionManager.checkLogin();

        // id=findViewById(R.id.id);
        btn_logout = findViewById(R.id.btn_logout);
        btn_dodaj=findViewById(R.id.btn_dodaj);
        numer=findViewById(R.id.numer);
        nazwa=findViewById(R.id.nazwa);
        usluga=findViewById(R.id.usluga);
        wroc=findViewById(R.id.wroc);
        // idd=findViewById(R.id.idd);

        HashMap<String, String> user =sessionManager.getUserDetail();
        getId = user.get(SessionManagerDodajWykonawce.ID);



        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DodajWykonawceActivity.this, wykonawcy.class);
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

                final String mNazwa =nazwa.getText().toString().trim();
                final String mUsluga =usluga.getText().toString().trim();
                final String mNumer =numer.getText().toString().trim();

                if(!mNazwa.isEmpty() || !mUsluga.isEmpty() || !mNumer.isEmpty()){

                add(mNazwa, mUsluga, mNumer);
                }
                else{

                    Toast.makeText(DodajWykonawceActivity.this, "Proszę uzupełnić wszystkie dane poprawnie", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void add(final String nazwa, final String usluga, final String numer){

        btn_dodaj.setVisibility(View.GONE);

        //final String nazwa =this.nazwa.getText().toString().trim();
        //final String usluga =this.usluga.getText().toString().trim();
        //final String numer =this.numer.getText().toString().trim();
        //final String id =this.id.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DODAJ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject =new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Toast.makeText(DodajWykonawceActivity.this, "Pomyślnie dodano wykonawce", Toast.LENGTH_SHORT).show();

                                btn_dodaj.setVisibility(View.VISIBLE);
                            }

                        } catch (JSONException e){

                            e.printStackTrace();
                            Toast.makeText(DodajWykonawceActivity.this, "Nie udało się pomyślnie dodać wykonawcy" + e.toString(), Toast.LENGTH_SHORT).show();

                            btn_dodaj.setVisibility(View.VISIBLE);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(DodajWykonawceActivity.this, "Brak połączenia sieciowego" + error.toString(), Toast.LENGTH_SHORT).show();

                        btn_dodaj.setVisibility(View.VISIBLE);

                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nazwa", nazwa);
                params.put("usluga", usluga);

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