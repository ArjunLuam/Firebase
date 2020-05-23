package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
        Button signout;
        private FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signout=findViewById(R.id.out);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this,"Signed out sucessfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        HashMap<String,Object>map=new HashMap<>();
        map.put("Name","Email");
        map.put("Email","arjunluam0732@gmail.com");
        FirebaseDatabase.getInstance().getReference().child("Arjun").updateChildren(map);
    }
}
