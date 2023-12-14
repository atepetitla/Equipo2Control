/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.DL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Optional;

/**
 *
 * @author digis
 */
@Entity
@Table(name = "ALUMNOMATERIA")
public class AlumnoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idalumnomateria;

    @ManyToOne
    @JoinColumn(name = "idmateria")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "idalumno")
    private Alumno alumno;

    public AlumnoMateria() {
    }

    public AlumnoMateria(int idalumnomateria, Materia materia, Alumno alumno) {
        this.idalumnomateria = idalumnomateria;
        this.materia = materia;
        this.alumno = alumno;
    }

    public int getIdalumnomateria() {
        return idalumnomateria;
    }

    public void setIdalumnomateria(int idalumnomateria) {
        this.idalumnomateria = idalumnomateria;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
