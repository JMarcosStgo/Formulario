package com.jmarcos.formulario;

public class VariablesFormulario {

    private String nombre;
    private String telefono;
    private String fecha;
    private String email;
    private String DescripcionContacto;

    public VariablesFormulario(String nombre, String telefono, String fecha, String email, String descripcionContacto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fecha = fecha;
        this.email = email;
        this.DescripcionContacto = descripcionContacto;
    }
    public VariablesFormulario(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcionContacto() {
        return DescripcionContacto;
    }

    public void setDescripcionContacto(String descripcionContacto) {
        this.DescripcionContacto = descripcionContacto;
    }
}
