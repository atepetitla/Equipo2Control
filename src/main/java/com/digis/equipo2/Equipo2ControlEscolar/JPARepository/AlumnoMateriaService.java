/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.AlumnoMateria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author digis
 */
@Service
public class AlumnoMateriaService {

    private AlumnoMateriaRepository alumnoMateriaRepository;

    @Autowired
    public AlumnoMateriaService(AlumnoMateriaRepository alumnoMateriaRepository) {
        this.alumnoMateriaRepository = alumnoMateriaRepository;
    }

    public List<AlumnoMateria> obtenerRelaciones() {
        return alumnoMateriaRepository.findAll();
    }

    public Optional<AlumnoMateria> obtenerRelacionPorId(int id) {
        return alumnoMateriaRepository.findById(id);
    }

    @Transactional
    public AlumnoMateria guardarRelacion(AlumnoMateria alumnoMateria) {
        return alumnoMateriaRepository.save(alumnoMateria);
    }

    @Transactional
    public void eliminarRelacion(int id) {
        alumnoMateriaRepository.deleteById(id);
    }

    @Transactional
    public void guardarRelacionSP(AlumnoMateria alumnoMateria) {
       
    }

    @Transactional
    public void eliminarRelacionsSP(int id) {
        alumnoMateriaRepository.EliminarRelacion(id);
    }

    @Transactional
    public void actualizarSP(AlumnoMateria alumnoMateria) {
        alumnoMateriaRepository.ActualizarRelacion(alumnoMateria.getIdalumnomateria(),
                alumnoMateria.getAlumno().getIdalumno(), alumnoMateria.getMateria().getIdmateria());
    }

}
