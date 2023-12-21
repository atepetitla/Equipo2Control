/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.DL.AlumnoMateria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface AlumnoMateriaRepository extends JpaRepository<AlumnoMateria, Integer> {

    @Procedure(name = "InsertarRelacion")
    void InsertarRelacion(@Param("p_idalumno") int p_idalumno, @Param("p_idmateria") int p_idmateria);

    @Procedure(name = "ActualizarRelacion")
    void ActualizarRelacion(@Param("p_idalumnomateria") int p_idalumnomateria, @Param("p_idalumno") int p_idalumno, @Param("p_idmateria") int p_idmateria);

    @Procedure(name = "EliminarRelacion")
    void EliminarRelacion(@Param("p_idalumnomateria") int p_idalumnomateria);

    @Procedure(name = "GetAllRelacionSP", refCursor = true)
    List<AlumnoMateria> GetAllRelacionSP();

}
