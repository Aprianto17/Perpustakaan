package com.example.aprianto.perpustakaan;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Data.Members;
import Data.User;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private Members members;
    private Button tb_login;
    private EditText et_mail , et_pass;
    private String id = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_mail = (EditText) findViewById(R.id.et_mail);
        et_pass = (EditText) findViewById(R.id.et_pass);
        tb_login = (Button) findViewById(R.id.tb_login);
        tb_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tb_login ) {
            String email = et_mail.getText().toString();
            String pass = et_pass.getText().toString();
            members = new Members(et_mail.getText().toString());
            //user = new User( email );
            if (email.equals(members.getEmail()) && pass.equals(members.getPass())) {
                // jika ya
                Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra ("members",members);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                LoginActivity.this.startActivity(intent);
                //finish();
            }else {
                // jika tidak
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Email atau Password Anda salah!")
                        .setNegativeButton("Retry", null).create().show();
            }
        }
    }
}
