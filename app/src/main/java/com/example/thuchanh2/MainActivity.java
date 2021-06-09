package com.example.thuchanh2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String jsonstr = null;
    TextView tvuser;
    EditText pl_email, pl_password;
    Button btn_dangNhap;
    Button btn_getall, btn_update, btn_Insert;
    private FirebaseAuth mAuth;
    int index;
    ListView lvUsers;
    CustomUserAdapter adt;
    ArrayList<User> arrayList;
    String url = "https://60b6892117d1dc0017b8801c.mockapi.io/user/user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pl_email = findViewById(R.id.pl_email);
        pl_password = findViewById(R.id.pl_password);
        btn_dangNhap = findViewById(R.id.btn_dangNhap);
        btn_getall = findViewById(R.id.btn_getData);
        btn_update = findViewById(R.id.btn_Update);
        btn_Insert = findViewById(R.id.btn_Inser);
        mAuth = FirebaseAuth.getInstance();
        tvuser = findViewById(R.id.tvuser);
        lvUsers = findViewById(R.id.lvUser);
        adt = new CustomUserAdapter(this, R.layout.layout_item, arrayList);
        lvUsers.setAdapter(adt);



        btn_dangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = pl_email.getText().toString();
                String password = pl_password.getText().toString();
                    DangNhap(email,password);
                    if(TextUtils.isEmpty(email) |TextUtils.isEmpty(password)){
                        Toast.makeText(MainActivity.this, "Ko duoc rong", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        DangNhap(email, password);
                    }
            }
        });
        btn_getall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvuser.setText(jsonstr);
                //getData();
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void DangNhap(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Sucess", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    /*public void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://60b6892117d1dc0017b8801c.mockapi.io/user/user";
        JsonArrayRequest rq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                    for ( int i = 0; i < response.length(); i++){
                        try {
                            JSONObject user = response.getJSONObject(i);
                            String Email = user.getString("email");
                            String Password = user.getString("password");
                            jsonstr += "Email:" +Email+ "\n\n";
                            jsonstr += "Password:" +Password+"\n\n";

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Loi lay data", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(rq);
    }  */

}