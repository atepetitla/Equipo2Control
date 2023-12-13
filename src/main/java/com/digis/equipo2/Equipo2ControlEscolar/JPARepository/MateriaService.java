/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Materia> Getall() {
        return materiarepository.findAll();
    }

    public Optional<Materia> byid(int id) {
        return materiarepository.findById(id);
    }

    @Transactional
    public Materia guardarMateria(Materia materia) {
        return materiarepository.save(materia);
    }

    @Transactional
    public void eliminarMateria(int id) {
        materiarepository.deleteById(id);
    }
}