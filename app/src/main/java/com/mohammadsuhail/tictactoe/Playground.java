package com.mohammadsuhail.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Playground extends AppCompatActivity {
    ImageView zz,zo,zt,oz,oo,ot,tz,to,tt;
    TextView code,turntext;
    int turn=0;
    String joined = "False";
    int[][] arr = new int[3][3];
    ProgressBar spinner;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        code = findViewById(R.id.codeid);
        Intent intent = getIntent();
        spinner = findViewById(R.id.progressBar);

        final String getcode = intent.getStringExtra("code");
        code.setText( code.getText().toString()  + " ( " +getcode + " )");
        turntext = findViewById(R.id.turntextid);
        turntext.setVisibility(View.GONE);
        zz = findViewById(R.id.zz);
        zo = findViewById(R.id.zo);
        zt = findViewById(R.id.zt);
        oz = findViewById(R.id.oz);
        oo = findViewById(R.id.oo);
        ot = findViewById(R.id.ot);
        tz = findViewById(R.id.tz);
        to = findViewById(R.id.to);
        tt = findViewById(R.id.tt);
        final MediaPlayer mp = MediaPlayer.create(Playground.this,R.raw.popup);
        final MediaPlayer win = MediaPlayer.create(Playground.this,R.raw.win);
        final MediaPlayer lose = MediaPlayer.create(Playground.this,R.raw.lose);
        arr[0][0]=0;
        arr[0][1]=0;
        arr[0][2]=0;
        arr[1][0]=0;
        arr[1][1]=0;
        arr[1][2]=0;
        arr[2][0]=0;
        arr[2][1]=0;
        arr[2][2]=0;

        zz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(zz.getDrawable() == null || zz.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {zz.setImageResource(R.drawable.zero);

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                reference.child("Playground").setValue("zz1");
                    reference.child("Turn").setValue(turn);
                    arr[0][0] = 1;
                boolean done =checkWin();
                    mp.start();
                if(done) {
                    reference.child("Result").setValue("Player1");
                }
                else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        zo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(zo.getDrawable() == null || zo.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {zo.setImageResource(R.drawable.zero);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                reference.child("Playground").setValue("zo1");
                    reference.child("Turn").setValue(turn);
                    arr[0][1] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        zt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(zt.getDrawable() == null || zt.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {zt.setImageResource(R.drawable.zero);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                reference.child("Playground").setValue("zt1");
                    reference.child("Turn").setValue(turn);
                    arr[0][2] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        oz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(oz.getDrawable() == null || oz.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {oz.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("oz1");
                    reference.child("Turn").setValue(turn);
                    arr[1][0] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        oo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(oo.getDrawable() == null || oo.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {oo.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("oo1");
                    reference.child("Turn").setValue(turn);
                    arr[1][1] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        ot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(ot.getDrawable() == null || ot.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {ot.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("ot1");
                    reference.child("Turn").setValue(turn);
                    arr[1][2] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        tz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(tz.getDrawable() == null || tz.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {tz.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("tz1");
                    reference.child("Turn").setValue(turn);
                    arr[2][0] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        to.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(to.getDrawable() == null || to.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {to.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("to1");
                    reference.child("Turn").setValue(turn);
                    arr[2][1] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        tt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(tt.getDrawable() == null || tt.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {tt.setImageResource(R.drawable.zero);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("tt1");
                    reference.child("Turn").setValue(turn);
                    arr[2][2] = 1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player1");
                    } else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        zz.setEnabled(false);
        zo.setEnabled(false);
        zt.setEnabled(false);
        oz.setEnabled(false);
        oo.setEnabled(false);
        ot.setEnabled(false);
        tz.setEnabled(false);
        to.setEnabled(false);
        tt.setEnabled(false);




        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey use this code to play Tic Tac Toe with me . ( "+ getcode +" )");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        assert getcode != null;
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(getcode).child("Player2");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    joined = (String) snapshot.getValue();

                    assert joined != null;
                    if(joined.equals("True")) {
//                        progressBar.dismiss();
                        spinner.setVisibility(View.GONE);
                        turntext.setVisibility(View.VISIBLE);
                        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child(getcode).child("Turn");
                        myref.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if(Integer.parseInt(Objects.requireNonNull(snapshot.getValue()).toString()) %2== 1) {
                                    turntext.setText("Your Turn");
                                    zz.setEnabled(true);
                                    zo.setEnabled(true);
                                    zt.setEnabled(true);
                                    oz.setEnabled(true);
                                    oo.setEnabled(true);
                                    ot.setEnabled(true);
                                    tz.setEnabled(true);
                                    to.setEnabled(true);
                                    tt.setEnabled(true);
                                    turn += 2;
                                }
                                else {
                                    turntext.setText("Opponent's Turn");
                                    zz.setEnabled(false);
                                    zo.setEnabled(false);
                                    zt.setEnabled(false);
                                    oz.setEnabled(false);
                                    oo.setEnabled(false);
                                    ot.setEnabled(false);
                                    tz.setEnabled(false);
                                    to.setEnabled(false);
                                    tt.setEnabled(false);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode).child("Playground");
                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                String get = Objects.requireNonNull(snapshot.getValue()).toString();
                                if(get.length() == 3){if(get.charAt(2) == '2'){
                                    if(get.charAt(0) =='z') {
                                        if(get.charAt(1) == 'z') {
                                            zz.setImageResource(R.drawable.cross);mp.start();
//                                            arr[0][0]=1;
                                            zz.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 'o') {
                                            zo.setImageResource(R.drawable.cross);mp.start();
//                                            arr[0][1] = 1;
                                            zo.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 't') {
                                            zt.setImageResource(R.drawable.cross);mp.start();
//                                            arr[0][2] = 1;
                                            zt.setEnabled(false);
                                        }
                                    }
                                    if(get.charAt(0) =='o') {
                                        if(get.charAt(1) == 'z') {
                                            oz.setImageResource(R.drawable.cross);mp.start();
//                                            arr[1][0]=1;
                                            oz.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 'o') {
                                            oo.setImageResource(R.drawable.cross);mp.start();
//                                            arr[1][1] = 1;
                                            oo.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 't') {
                                            ot.setImageResource(R.drawable.cross);mp.start();
//                                            arr[1][2] = 1;
                                            ot.setEnabled(false);
                                        }
                                    }
                                    if(get.charAt(0) =='t') {
                                        if(get.charAt(1) == 'z') {
                                            tz.setImageResource(R.drawable.cross);mp.start();
//                                            arr[2][0]=1;
                                            tz.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 'o') {
                                            to.setImageResource(R.drawable.cross);mp.start();
//                                            arr[2][1] = 1;
                                            to.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 't') {
                                            tt.setImageResource(R.drawable.cross);mp.start();
//                                            arr[2][2] = 1;
                                            tt.setEnabled(false);
                                        }
                                    }

                                }}
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

                    }
                    else {
//                        progressBar.show();
                        spinner.setVisibility(View.VISIBLE);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });

        final DatabaseReference resultRef = FirebaseDatabase.getInstance().getReference().child(getcode);
        resultRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("Result")) {
                    resultRef.child("Result").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(Objects.equals(snapshot.getValue(), "Player1")){

/*                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        finish();
                                        startActivity(new Intent(Playground.this,MainActivity.class));
                                    }
                                },2000);*/

                                AlertDialog.Builder builder = new AlertDialog.Builder(Playground.this);
                                builder.setTitle("Yeh");
                                builder.setMessage("Congratulations You Win the game!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                               /* arr[0][0]=0;
                                                arr[0][1]=0;
                                                arr[0][2]=0;
                                                arr[1][0]=0;
                                                arr[1][1]=0;
                                                arr[1][2]=0;
                                                arr[2][0]=0;
                                                arr[2][1]=0;
                                                arr[2][2]=0;
                                                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child(getcode);
                                                reff.child("Playground").setValue("");
                                                reff.child("Result").setValue("");
                                                reff.child("Turn").setValue("1");
                                                zz.setImageResource(android.R.color.transparent);
                                                zo.setImageResource(android.R.color.transparent);
                                                zt.setImageResource(android.R.color.transparent);
                                                oz.setImageResource(android.R.color.transparent);
                                                oo.setImageResource(android.R.color.transparent);
                                                ot.setImageResource(android.R.color.transparent);
                                                tz.setImageResource(android.R.color.transparent);
                                                to.setImageResource(android.R.color.transparent);
                                                tt.setImageResource(android.R.color.transparent);
                                                turn = 1;
                                                zz.setEnabled(true);
                                                zo.setEnabled(true);
                                                zt.setEnabled(true);
                                                oz.setEnabled(true);
                                                oo.setEnabled(true);
                                                ot.setEnabled(true);
                                                tz.setEnabled(true);
                                                to.setEnabled(true);
                                                tt.setEnabled(true);*/
                                                Toast.makeText(Playground.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                finish();
                                                startActivity(new Intent(Playground.this,MainActivity.class));
                                            }
                                        });
                                AlertDialog alert = builder.create(); win.start();
                                alert.show();
                            }
                            else if(Objects.equals(snapshot.getValue(), "Player2")) {

/*                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        finish();
                                        startActivity(new Intent(Playground.this,MainActivity.class));
                                    }
                                },2000);*/
                                AlertDialog.Builder builder = new AlertDialog.Builder(Playground.this);
                                builder.setTitle("Ooh");
//                                builder.setIcon(R.mipmap.ic_launcher);
                                builder.setMessage(" You Lose the game!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                /*arr[0][0]=0;
                                                arr[0][1]=0;
                                                arr[0][2]=0;
                                                arr[1][0]=0;
                                                arr[1][1]=0;
                                                arr[1][2]=0;
                                                arr[2][0]=0;
                                                arr[2][1]=0;
                                                arr[2][2]=0;
                                                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child(getcode);
                                                reff.child("Playground").setValue("");
                                                reff.child("Result").setValue("");
                                                reff.child("Turn").setValue("1");
                                                zz.setImageResource(android.R.color.transparent);
                                                zo.setImageResource(android.R.color.transparent);
                                                zt.setImageResource(android.R.color.transparent);
                                                oz.setImageResource(android.R.color.transparent);
                                                oo.setImageResource(android.R.color.transparent);
                                                ot.setImageResource(android.R.color.transparent);
                                                tz.setImageResource(android.R.color.transparent);
                                                to.setImageResource(android.R.color.transparent);
                                                tt.setImageResource(android.R.color.transparent);
                                                turn = 1;
                                                zz.setEnabled(true);
                                                zo.setEnabled(true);
                                                zt.setEnabled(true);
                                                oz.setEnabled(true);
                                                oo.setEnabled(true);
                                                ot.setEnabled(true);
                                                tz.setEnabled(true);
                                                to.setEnabled(true);
                                                tt.setEnabled(true);*/
                                                Toast.makeText(Playground.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                finish();
                                                startActivity(new Intent(Playground.this,MainActivity.class));
                                            }
                                        });
                                AlertDialog alert = builder.create(); lose.start();
                                alert.show();

                            }
                            else if(snapshot.getValue().equals("Tie")) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Playground.this);
                                builder.setTitle("Ooh");
//                                builder.setIcon(R.mipmap.ic_launcher);
                                builder.setMessage(" Its a tie!!")
                                        .setCancelable(false)
                                        .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                /*arr[0][0]=0;
                                                arr[0][1]=0;
                                                arr[0][2]=0;
                                                arr[1][0]=0;
                                                arr[1][1]=0;
                                                arr[1][2]=0;
                                                arr[2][0]=0;
                                                arr[2][1]=0;
                                                arr[2][2]=0;
                                                DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child(getcode);
                                                reff.child("Playground").setValue("");
                                                reff.child("Result").setValue("");
                                                reff.child("Turn").setValue("1");
                                                zz.setImageResource(android.R.color.transparent);
                                                zo.setImageResource(android.R.color.transparent);
                                                zt.setImageResource(android.R.color.transparent);
                                                oz.setImageResource(android.R.color.transparent);
                                                oo.setImageResource(android.R.color.transparent);
                                                ot.setImageResource(android.R.color.transparent);
                                                tz.setImageResource(android.R.color.transparent);
                                                to.setImageResource(android.R.color.transparent);
                                                tt.setImageResource(android.R.color.transparent);
                                                turn = 0;
                                                zz.setEnabled(true);
                                                zo.setEnabled(true);
                                                zt.setEnabled(true);
                                                oz.setEnabled(true);
                                                oo.setEnabled(true);
                                                ot.setEnabled(true);
                                                tz.setEnabled(true);
                                                to.setEnabled(true);
                                                tt.setEnabled(true);*/
                                                Toast.makeText(Playground.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                finish();
                                                startActivity(new Intent(Playground.this,MainActivity.class));
                                            }
                                        });
                                AlertDialog alert = builder.create(); lose.start();
                                alert.show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    private boolean checkWin() {
        for(int i=0;i<3;i++) {
            if(arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1) return true;
            if(arr[0][i] == 1 && arr[1][i] == 1 && arr[2][i] == 1) return true;
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return true;
        return (arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1);
    }


}