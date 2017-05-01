package com.elysewarren.elyseemma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;

    private EditText loginUN;
    private EditText loginPW;
    private Button playGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null)
                    startActivity(new Intent(MainActivity.this, SignUp.class));
            }
        };


        loginUN = (EditText) findViewById(R.id.username_fillin);
        loginPW = (EditText) findViewById(R.id.password_fillin);
        playGame = (Button) findViewById(R.id.play_button);

    }


    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        Toast.makeText(MainActivity.this, dataSnapshot.getValue(MainActivity.class) + " has changed", Toast.LENGTH_SHORT).show();
    }

    public void onChildRemoved(DataSnapshot dataSnapshot) {
        Toast.makeText(MainActivity.this, dataSnapshot.getValue(MainActivity.class) + " is removed", Toast.LENGTH_SHORT).show();
    }

    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
    }

    public void onCancelled(DatabaseError databaseError) {
    }


    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        auth.removeAuthStateListener(authListener);
    }

    public void addSomething(View view) {
        FirebaseUser user = auth.getCurrentUser();
        DatabaseReference userRef = database.getReference(user.getUid());
        Layout infoText = null;
        userRef.push().setValue(infoText.getText().toString());
    }

    public void signOut(View view) {
        auth.signOut();

    }


    public void openSignUpScreen(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

    public void openCharacterScreen(View view) {
        Intent i = new Intent(this, CharacterScreen.class);
        startActivity(i);
    }
}
