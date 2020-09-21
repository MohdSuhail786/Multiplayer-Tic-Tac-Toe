package com.mohammadsuhail.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button newgame,entercode,exit;
    Button newgameplay,joingameplay,resumebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newgame = findViewById(R.id.newgameid);
        entercode = findViewById(R.id.entercodeid);
        exit = findViewById(R.id.exitid);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });




        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getcode = codeGenerator();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode).child("Player1");
                reference.setValue("true");
                DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child(getcode).child("Player2");
                reference1.setValue("false");
                DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child(getcode).child("Turn");
                reference2.setValue(1);
                DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child(getcode).child("Playground");
                reference3.setValue("");
                Intent intent = new Intent(MainActivity.this,Playground.class);
                intent.putExtra("code",getcode);
                startActivity(intent);
            }
        });

        entercode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlaygroundEnterCode.class);
                startActivity(intent);
            }
        });
    }
    public String codeGenerator() {
        String code="";
        Random random = new Random();
        int a,b,c,d;
        a=random.nextInt(9);
        b=random.nextInt(9);
        c=random.nextInt(9);
        d=random.nextInt(9);
        code += String.valueOf(a) + b + c + d;
        return code;
    }
}

//shift reduce                            accept              error
//push  replace handle at top of stack    input $ stack S     input $ stack not start symbol