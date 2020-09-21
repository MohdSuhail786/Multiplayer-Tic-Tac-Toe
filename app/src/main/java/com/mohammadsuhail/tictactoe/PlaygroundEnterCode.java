package com.mohammadsuhail.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.sip.SipSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class PlaygroundEnterCode extends AppCompatActivity {
    Button go;
    EditText code;
    String getcode;
    String mejoined = "False";
    TextView turntext;
    ImageView zz,zo,zt,oz,oo,ot,tz,to,tt;
    int[][] arr = new int[3][3];
    ProgressBar spinner;
    int turn = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground_enter_code);
        go = findViewById(R.id.button);
        code = findViewById(R.id.entercodeid);
        spinner = findViewById(R.id.progressBar2);
        spinner.setVisibility(View.GONE);
        zz = findViewById(R.id.zz);
        zo = findViewById(R.id.zo);
        zt = findViewById(R.id.zt);
        oz = findViewById(R.id.oz);
        oo = findViewById(R.id.oo);
        ot = findViewById(R.id.ot);
        tz = findViewById(R.id.tz);
        to = findViewById(R.id.to);
        tt = findViewById(R.id.tt);
        turntext = findViewById(R.id.turntextid);
        turntext.setVisibility(View.GONE);
        final MediaPlayer mp = MediaPlayer.create(PlaygroundEnterCode.this,R.raw.popup);
        final MediaPlayer win = MediaPlayer.create(PlaygroundEnterCode.this,R.raw.win);
        final MediaPlayer lose = MediaPlayer.create(PlaygroundEnterCode.this,R.raw.lose);
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
                if(zz.getDrawable() == null || zz.getDrawable() == getResources().getDrawable(android.R.color.transparent)){ zz.setImageResource(R.drawable.cross);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("zz2");
                    reference.child("Turn").setValue(turn);arr[0][0]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        zo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(zo.getDrawable() == null || zo.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {zo.setImageResource(R.drawable.cross);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("zo2");
                    reference.child("Turn").setValue(turn);arr[0][1]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }}
            }
        });
        zt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(zt.getDrawable() == null || zt.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {zt.setImageResource(R.drawable.cross);
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("zt2");
                    reference.child("Turn").setValue(turn);arr[0][2]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        oz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(oz.getDrawable() == null || oz.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {oz.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("oz2");
                    reference.child("Turn").setValue(turn);arr[1][0]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        oo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(oo.getDrawable() == null || oo.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {oo.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("oo2");
                    reference.child("Turn").setValue(turn);arr[1][1]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        ot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(ot.getDrawable() == null || ot.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {ot.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("ot2");
                    reference.child("Turn").setValue(turn);arr[1][2]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        tz.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(tz.getDrawable() == null || tz.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {tz.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("tz2");
                    reference.child("Turn").setValue(turn);arr[2][0]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        to.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(to.getDrawable() == null || to.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {to.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("to2");
                    reference.child("Turn").setValue(turn);arr[2][1]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
                }
            }
        });
        tt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if(tt.getDrawable() == null || tt.getDrawable() == getResources().getDrawable(android.R.color.transparent)) {tt.setImageResource(R.drawable.cross);
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(getcode);
                    reference.child("Playground").setValue("tt2");
                    reference.child("Turn").setValue(turn);arr[2][2]=1;
                    boolean done =checkWin();mp.start();
                    if(done) {
                        reference.child("Result").setValue("Player2");
                    }else if(turn == 10) { reference.child("Result").setValue("Tie"); }
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
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setVisibility(View.VISIBLE);
                getcode = code.getText().toString();
                final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild(getcode)) {
                                try {
                                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(Objects.requireNonNull(getCurrentFocus()).getWindowToken(), 0);
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }
                            ref.child(getcode).child("Player2").setValue("True");
                            mejoined  = "True";
                            code.setFocusable(false);
                            go.setEnabled(false);
                            spinner.setVisibility(View.GONE);
                            go.setVisibility(View.GONE);
                            turntext.setVisibility(View.VISIBLE);
                            DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child(getcode).child("Turn");
                            myref.addValueEventListener(new ValueEventListener() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(Integer.parseInt(Objects.requireNonNull(snapshot.getValue()).toString()) %2== 0) {
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
                                    if(get.length() == 3){if(get.charAt(2) == '1'){
                                    if(get.charAt(0) =='z') {
                                        if(get.charAt(1) == 'z') {
                                            zz.setImageResource(R.drawable.zero);mp.start();
//                                            arr[0][0]=1;
                                            zz.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 'o') {
                                            zo.setImageResource(R.drawable.zero);mp.start();
//                                            arr[0][1] = 1;
                                            zo.setEnabled(false);
                                        }
                                        if(get.charAt(1) == 't') {
                                            zt.setImageResource(R.drawable.zero);mp.start();
//                                            arr[0][2] = 1;
                                            zt.setEnabled(false);
                                        }
                                    }
                                        if(get.charAt(0) =='o') {
                                            if(get.charAt(1) == 'z') {
                                                oz.setImageResource(R.drawable.zero);mp.start();
//                                                arr[1][0]=1;
                                                oz.setEnabled(false);
                                            }
                                            if(get.charAt(1) == 'o') {
                                                oo.setImageResource(R.drawable.zero);mp.start();
//                                                arr[1][1] = 1;
                                                oo.setEnabled(false);
                                            }
                                            if(get.charAt(1) == 't') {
                                                ot.setImageResource(R.drawable.zero);mp.start();
//                                                arr[1][2] = 1;
                                                ot.setEnabled(false);
                                            }
                                        }
                                        if(get.charAt(0) =='t') {
                                            if(get.charAt(1) == 'z') {
                                                tz.setImageResource(R.drawable.zero);mp.start();
//                                                arr[2][0]=1;
                                                tz.setEnabled(false);
                                            }
                                            if(get.charAt(1) == 'o') {
                                                to.setImageResource(R.drawable.zero);mp.start();
//                                                arr[2][1] = 1;
                                                to.setEnabled(false);
                                            }
                                            if(get.charAt(1) == 't') {
                                                tt.setImageResource(R.drawable.zero);mp.start();
//                                                arr[2][2] = 1;
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
                            Toast.makeText(PlaygroundEnterCode.this, "Incorrect Code", Toast.LENGTH_SHORT).show();
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
                                    if(Objects.equals(snapshot.getValue(), "Player2")){

/*                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                finish();
                                                startActivity(new Intent(PlaygroundEnterCode.this,MainActivity.class));
                                            }
                                        },2000);*/

                                        AlertDialog.Builder builder = new AlertDialog.Builder(PlaygroundEnterCode.this);
                                        builder.setTitle("Yeh");
//                                        builder.setIcon(R.mipmap.ic_launcher);
                                        builder.setMessage("Congratulations You Win the game!!")
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
                                                        turn = 1;*/
                                                        Toast.makeText(PlaygroundEnterCode.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                                    }
                                                })
                                                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        dialog.cancel();
                                                        finish();
                                                        startActivity(new Intent(PlaygroundEnterCode.this,MainActivity.class));
                                                    }
                                                });
                                        AlertDialog alert = builder.create(); win.start();
                                        alert.show();

                                    }
                                    else if(Objects.equals(snapshot.getValue(), "Player1")) {

/*                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                finish();
                                                startActivity(new Intent(PlaygroundEnterCode.this,MainActivity.class));

                                            }
                                        },2000);*/

                                        AlertDialog.Builder builder = new AlertDialog.Builder(PlaygroundEnterCode.this);
                                        builder.setTitle("Ooh");
//                                        builder.setIcon(R.mipmap.ic_launcher);
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
                                                        turn = 1;*/
                                                        Toast.makeText(PlaygroundEnterCode.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                                    }
                                                })
                                                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        dialog.cancel();
                                                        finish();
                                                        startActivity(new Intent(PlaygroundEnterCode.this,MainActivity.class));
                                                    }
                                                });
                                        AlertDialog alert = builder.create(); lose.start();
                                        alert.show();

                                    }
                                    else if(snapshot.getValue().equals("Tie")) {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(PlaygroundEnterCode.this);
                                        builder.setTitle("Ooh");
//                                        builder.setIcon(R.mipmap.ic_launcher);
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
                                                        turn = 1;*/
                                                        Toast.makeText(PlaygroundEnterCode.this, "Work in progress", Toast.LENGTH_SHORT).show();
                                                    }
                                                })
                                                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog, int id) {
                                                        dialog.cancel();
                                                        finish();
                                                        startActivity(new Intent(PlaygroundEnterCode.this,MainActivity.class));
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
        });

    }

    private boolean checkWin() {
        for(int i=0;i<3;i++) {
            if(arr[i][0] == 1 && arr[i][1] == 1 && arr[i][2] == 1) return true;
            if(arr[0][i] == 1 && arr[1][i] == 1 && arr[2][i] == 1) return true;
        }
        if(arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) return true;
        return arr[0][2] == 1 && arr[1][1] == 1 && arr[2][0] == 1;
    }

}