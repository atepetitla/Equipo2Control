/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digis
 */
    public interface MateriaRepository extends JpaRepository<Materia, Integer> {

//    public Object findById(Long id);
    
}
