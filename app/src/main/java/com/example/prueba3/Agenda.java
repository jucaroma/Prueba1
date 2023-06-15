package com.example.prueba3;

public class Agenda {
    private String idAgenda;
    private String fecha;
    private String asunto;
    private String actividad;

    public Agenda() {
        // Constructor vacío requerido para Firebase
    }

    public Agenda(String idAgenda, String fecha, String asunto, String actividad) {
        this.idAgenda = idAgenda;
        this.fecha = fecha;
        this.asunto = asunto;
        this.actividad = actividad;
    }

    public String getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(String idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
