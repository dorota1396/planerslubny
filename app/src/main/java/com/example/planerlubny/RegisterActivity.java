package com.example.planerlubny;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private Button register, ret ;
    private EditText name, email, password;

    private static String URL_REGISTER="http://192.168.0.19/register/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);


        // data=findViewById(R.id.data);
        register=findViewById(R.id.register);
        ret=findViewById(R.id.ret);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mName = name.getText().toString().trim();
                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();
                if(!mEmail.isEmpty() && !mPass.isEmpty() && !mName.isEmpty() ){


                    if(!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
                        Toast.makeText(RegisterActivity.this, "Nieprawidłowy email", Toast.LENGTH_SHORT).show();




                    } else {

                        Regist(mName, mEmail, mPass);
                    }



                } else {

                    Toast.makeText(RegisterActivity.this, "Proszę uzupełnić wszystkie dane", Toast.LENGTH_SHORT).show();

                }


            }
        });

        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void Regist(final String name, final String email, final String password) {

        register.setVisibility(View.GONE);

       // final String name =this.name.getText().toString().trim();
       // final String email =this.email.getText().toString().trim();
       // final String password =this.password.getText().toString().trim();
       //final String cm_password =this.cm_password.getText().toString().trim();



        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject =new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1")){
                                Toast.makeText(RegisterActivity.this, "Zarejstrowano pomyślnie", Toast.LENGTH_SHORT).show();


                            }

                        } catch (JSONException e){

                            e.printStackTrace();
                            Toast.makeText(RegisterActivity.this, "Nie udało się poprawnie zarejstrować użytkownika", Toast.LENGTH_SHORT).show();
                            register.setVisibility(View.VISIBLE);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(RegisterActivity.this, "Brak połączenia sieciowego", Toast.LENGTH_SHORT).show();
                        register.setVisibility(View.VISIBLE);

                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                return params;
                // return super.getParams();
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);




    }
}
