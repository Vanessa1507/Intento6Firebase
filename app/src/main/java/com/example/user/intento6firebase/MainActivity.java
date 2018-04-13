package com.example.user.intento6firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.intento6firebase.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

Button botonPais;
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonPais = (Button) findViewById(R.id.boton_pais);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference(FirebaseReferences.TB_PAIS);
        
        botonPais= setOnClickListener(new View view){
            @Override
            public void onClick (View view){
                myref.child(FirebaseReferences.PAIS_REFERENCIA).addValueEventstener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valor = dataSnapshot.getValue(String.class);
                Log.i("Datos", valor+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR",databaseError.getMessage());
            }
        });
            }
        
        }):

    }
}
