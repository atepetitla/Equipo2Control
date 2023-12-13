/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author digis
 */
@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno obtenerAlumnoPorId(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno actualizarAlumno(Long id, Alumno alumnoActualizado) {
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombre(alumnoActualizado.getNombre());
                    alumno.setApellidopaterno(alumnoActualizado.getApellidopaterno());
                    alumno.setApellidomaterno(alumnoActualizado.getApellidomaterno());
                    return alumnoRepository.save(alumno);
                })
                .orElse(null); 
    }
}
