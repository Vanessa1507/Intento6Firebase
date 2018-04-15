package com.example.user.intento6firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.intento6firebase.Objetos.Departamento;
import com.example.user.intento6firebase.Objetos.FirebaseReferences;
import com.example.user.intento6firebase.Objetos.Pais;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button botonPais;
    Button botonDepartamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonPais = findViewById(R.id.boton_Pais);
        botonDepartamentos = findViewById(R.id.boton_Departamentos);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myrefpais = database.getReference(FirebaseReferences.TB_PAISES);
        final DatabaseReference myrefDep = database.getReference(FirebaseReferences.TB_DEPARTAMETOS);

        botonPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myrefpais.child(FirebaseReferences.PAIS_REFERENCIA).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Pais pais1 = dataSnapshot.getValue(Pais.class);
                        Log.i("PAIS", dataSnapshot.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });

        botonDepartamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myrefDep.child(FirebaseReferences.DEPARTAMENTO_REFERENCIA).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Departamento departamento1 = dataSnapshot.getValue(Departamento.class);
                        Log.i("DEPARTAMENTO",dataSnapshot.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
