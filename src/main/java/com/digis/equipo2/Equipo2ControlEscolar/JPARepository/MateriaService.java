/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
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
@Repository
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
    public Optional<Materia> getbynombre(String nombre){
       return materiarepository.findByNombre(nombre);
    }
    
    //SP
    @Transactional
    public void agregarMateriaSP(String nombre, int costo) {
        materiarepository.InsertarMateria(nombre, costo);
    }
     @Transactional
    public void actualizarMateriaSP(int idMateria, String nuevoNombre, int nuevoCosto) {
        materiarepository.ActualizarMateria(idMateria, nuevoNombre, nuevoCosto);
    }
    
    @Transactional
    public void eliminarMateriaSP(int idMateria) {
        materiarepository.eliminarMateria(idMateria);
    }
}
