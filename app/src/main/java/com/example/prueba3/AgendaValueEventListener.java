package com.example.prueba3;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public abstract class AgendaValueEventListener implements ValueEventListener {

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            AgendaItem agendaItem = snapshot.getValue(AgendaItem.class);
            onAgendaItemReceived(agendaItem);
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // Manejar el error en caso de que ocurra
    }

    public abstract void onAgendaItemReceived(AgendaItem agendaItem);
}
