/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victor
 */
public class Alumno extends Usuario{
    private long id;
    private String dni;
    private double nota_media;
    private String nombre;
    private long id_tutor;
    private double nota_practica;
    private String informe;
    private String nombre_empresa_practicas = null;

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public double getNota_practica() {
        return nota_practica;
    }

    public void setNota_practica(double nota_practica) {
        this.nota_practica = nota_practica;
    }

    public String getNombre_empresa_practicas() {
        return nombre_empresa_practicas;
    }

    public void setNombre_empresa_practicas(String nombre_empresa_practicas) {
        this.nombre_empresa_practicas = nombre_empresa_practicas;
    }
  

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getNota_media() {
        return nota_media;
    }

    public void setNota_media(double nota_media) {
        this.nota_media = nota_media;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(long id_tutor) {
        this.id_tutor = id_tutor;
    }
    
    
}
