/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.AlumnoMateria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author digis
 */
public class AlumnoMateriaService {

    private final AlumnoMateriaRepository alumnoMateriaRepository;

    @Autowired
    public AlumnoMateriaService(AlumnoMateriaRepository alumnoMateriaRepository) {
        this.alumnoMateriaRepository = alumnoMateriaRepository;
    }

    public List<AlumnoMateria> obtenerRelaciones() {
        return alumnoMateriaRepository.findAll();
    }

    public AlumnoMateria obtenerRelacionPorId(Long id) {
        return alumnoMateriaRepository.findById(id).orElse(null);
    }

    public AlumnoMateria guardarRelacion(AlumnoMateria alumnoMateria) {
        return alumnoMateriaRepository.save(alumnoMateria);
    }

    public void eliminarRelacion(Long id) {
        alumnoMateriaRepository.deleteById(id);
    }

    public AlumnoMateria actualizarAlumno(Long id, AlumnoMateria relacionActualizado) {
        return alumnoMateriaRepository.findById(id)
                .map(relacion -> {
                    relacion.setAlumno(relacionActualizado.getAlumno());
                    relacion.setMateria(relacionActualizado.getMateria());
                    return alumnoMateriaRepository.save(relacion);
                })
                .orElse(null);
    }
}