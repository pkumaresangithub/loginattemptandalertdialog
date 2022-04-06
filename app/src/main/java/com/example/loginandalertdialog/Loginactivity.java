package com.example.loginandalertdialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity {
    EditText username,password;
    Button testverify;
    TextView attempts;
    int totalattempt=5;
    Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        testverify = findViewById(R.id.testverify);
        attempts = findViewById(R.id.attempts);

        testverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();

                if (USERNAME.isEmpty()){
                    username.setError(" Enter User Name");
                    username.requestFocus();
                    return;
                }

                if (PASSWORD.isEmpty()){
                    password.setError(" Enter Password ");
                    password.requestFocus();
                    return;
                }
                if (USERNAME.equals("admin") && PASSWORD.equals("123")){
//                    Intent intent2 = new Intent(Loginactivity.this,MainActivity.class);
//                    intent2.putExtra("userkey",USERNAME);
//                    startActivity(intent2);
                    finish();
                } else {
                    totalattempt=totalattempt-1;
                    Toast.makeText(Loginactivity.this,"Number of attampts"+totalattempt,Toast.LENGTH_SHORT).show();
                    attempts.setText(totalattempt);
                    if (totalattempt == 0 ) {
                        testverify.setVisibility(View.GONE);
                    } else {
                        username.setText("");
                        username.requestFocus();
                        return;
                    }

                }
            }
        });


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.logout: {
                Toast.makeText(Loginactivity.this,"log out",Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(Loginactivity.this);
                builder.setMessage(" Do you want to close this applicaiton ");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Alert");
                alertDialog.show();

                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }
}




