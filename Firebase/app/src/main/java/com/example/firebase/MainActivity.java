package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 1000;
    Button btn;
    EditText edNote;
    ListView lView;
    ArrayList<String> notes;
    FirebaseUser firebaseUser;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        edNote=findViewById(R.id.edNote);
        lView=findViewById(R.id.lView);

        //ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.item_row,R.id.lView,notes);

        lView.setAdapter(arrayAdapter);



        //final DatabaseReference dbRef = FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if(firebaseUser!=null){
            //when logged in
            final DatabaseReference dbRef = FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String note=edNote.getText().toString();
                    //Node n=new Node("hello","world");

                    //upload note to firebase
                    // FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference().push().setValue(note);
                    dbRef.child("note").child(firebaseUser.getUid()).push().setValue(note);
                    // dbRef.child("todo").push().setValue(note);
                }
            });
            dbRef.child("note").child(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //called when a new data node is inserted to the "note node"

                    String data=dataSnapshot.getValue(String.class);
                    notes.add(data);
                    arrayAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //an existed node data is changed
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    //when a data at subnode is removed
                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    //when the position of a subnode changes
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //when the read operation failed
                }
            });

           /* dbRef.child("note").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //get the entire database
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });*/
        }else{
            //not looged in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.GoogleBuilder().build(),
                                    new AuthUI.IdpConfig.EmailBuilder().build(),
                                    new AuthUI.IdpConfig.PhoneBuilder().build()))
                            .build(),
                    RC_SIGN_IN);
        }


      /*  btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note=edNote.getText().toString();
                //Node n=new Node("hello","world");

                //upload note to firebase
               // FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference().push().setValue(note);
                dbRef.child("note").push().setValue(note);
               // dbRef.child("todo").push().setValue(note);
            }
        });
        dbRef.child("note").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //called when a new data node is inserted to the "note node"

                String data=dataSnapshot.getValue(String.class);
                notes.add(data);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                  //an existed node data is changed
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                  //when a data at subnode is removed
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                       //when the position of a subnode changes
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                  //when the read operation failed
            }
        });

        dbRef.child("note").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //get the entire database
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                final DatabaseReference dbRef = FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String note=edNote.getText().toString();
                        //Node n=new Node("hello","world");

                        //upload note to firebase
                        // FirebaseDatabase.getInstance("https://fir-265f1-default-rtdb.firebaseio.com/").getReference().push().setValue(note);
                        dbRef.child("note").child(firebaseUser.getUid()).push().setValue(note);
                        // dbRef.child("todo").push().setValue(note);
                    }
                });
                dbRef.child("note").child(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        //called when a new data node is inserted to the "note node"

                        String data=dataSnapshot.getValue(String.class);
                        notes.add(data);
                        arrayAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        //an existed node data is changed
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                        //when a data at subnode is removed
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        //when the position of a subnode changes
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        //when the read operation failed
                    }
                });
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button

                    return;
                }

                if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {

                    return;
                }



            }
        }
    }
}