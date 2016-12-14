package com.example.koen.powderguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText userinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userinput = (EditText) findViewById(R.id.userinput);

//        DatabaseReference mDatabase;
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        FirebaseAuth.AuthStateListener mAuthListener = new FirebaseAuth.AuthStateListener() { // op internet: mauthlistener = alsdfjlsdf
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    String uid = user.getUid();
//                    Log.d("geen null", uid);
//                } else {
//                    System.out.println("user is null");
//                }
//            }
//        };

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null){
//            String uid = user.getUid();
//            Log.d("geen null", uid);
//        } else {
//            System.out.println("user is null");
//        }

    }

    public void seeSpots (View view){
        Intent Spots = new Intent(this, Spots_activity.class);
        startActivity(Spots);
    }

    public void search(View view){
        String input = userinput.getText().toString();

        if (input.isEmpty()){
            Toast.makeText(this, "Please enter a city", Toast.LENGTH_LONG).show();
        }
        else{
            input = input.replace(" ", "+");
            new SnowAsynctasks(MainActivity.this, input).execute();

        }
    }



}
