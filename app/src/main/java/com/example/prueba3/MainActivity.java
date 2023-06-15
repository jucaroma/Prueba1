package com.example.prueba3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText etFecha, etAsunto, etActividad;
    private TextView tvResultado;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFecha = findViewById(R.id.etFecha);
        etAsunto = findViewById(R.id.etAsunto);
        etActividad = findViewById(R.id.etActividad);
        tvResultado = findViewById(R.id.tvResultado);

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void agregar(View view) {
        String fecha = etFecha.getText().toString();
        String asunto = etAsunto.getText().toString();
        String actividad = etActividad.getText().toString();

        String clave = mDatabase.child("agenda").push().getKey();

        AgendaItem agendaItem = new AgendaItem(clave, fecha, asunto, actividad);

        mDatabase.child("agenda").child(clave).setValue(agendaItem);

        etFecha.setText("");
        etAsunto.setText("");
        etActividad.setText("");
    }

    public void consultar(View view) {
        mDatabase.child("agenda").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StringBuilder resultado = new StringBuilder();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    AgendaItem agendaItem = snapshot.getValue(AgendaItem.class);
                    resultado.append("Fecha: ").append(agendaItem.getFecha()).append("\n")
                            .append("Asunto: ").append(agendaItem.getAsunto()).append("\n")
                            .append("Actividad: ").append(agendaItem.getActividad()).append("\n\n");
                }
                tvResultado.setText(resultado.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Manejar el error en caso de que ocurra
            }
        });
    }
}
