/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digis
 */
@Service
public class MateriaService {

    private MateriaRepository materiarepository;

    @Autowired
    public MateriaService(MateriaRepository materiarepository) {
        this.materiarepository = materiarepository;
    }

    public List<Materia> obtenerTodosLasMaterias() {
        return materiarepository.findAll();
    }

    public Materia obtenerMateriaPorId(Long id) {
        return materiarepository.findById(id).orElse(null);
    }

    public Materia guardarMateria(Materia materia) {
        return materiarepository.save(materia);
    }

    public void eliminarMateria(Long id) {
        materiarepository.deleteById(id);
    }

    public Materia actualizarMateria(Long id, Materia actualizarMateria) {
        return materiarepository.findById(id)
                .map(materia -> {
                    materia.setNombre(actualizarMateria.getNombre());
                    materia.setCosto(actualizarMateria.getCosto());
                    return materiarepository.save(materia);
                })
                .orElse(null);
    }
}
