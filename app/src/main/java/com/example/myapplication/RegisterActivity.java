package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
         EditText email;
         EditText password;
         Button register;
         FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.mail);
        password=findViewById(R.id.pass);
        register=findViewById(R.id.register);
        mauth=FirebaseAuth.getInstance();


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_mail=email.getText().toString();
                String user_pass=password.getText().toString();
                if(TextUtils.isEmpty(user_mail)|| TextUtils.isEmpty(user_pass)){
                    Toast.makeText(RegisterActivity.this,"Empty Credentials",Toast.LENGTH_LONG).show();
            }else if(user_pass.length()<6){
                    Toast.makeText(RegisterActivity.this,"Password is short",Toast.LENGTH_LONG).show();
                }else{
                    registerUser(user_mail , user_pass);
                }
            }
        });
        }
            private void registerUser(String email,String password){
                mauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"Registeration Successful",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"Registeration Failed",Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
    }

