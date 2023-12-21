/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digis
 */
@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Optional<Alumno> findByNombre(String nombre);

    @Procedure(name = "InsertarAlumno")
    void InsertarAlumno(String p_Nombre, String p_ApellidoPaterno, String p_ApellidoMaterno);

    @Procedure(name = "ActualizarAlumno")
    void actualizarAlumno(@Param("p_idalumno") int p_idalumno, @Param("p_NuevoNombre") String p_NuevoNombre, @Param("p_NuevoApellidoPaterno") String p_NuevoApellidoPaterno, @Param("p_NuevoApellidoMaterno") String p_NuevoApellidoMaterno);

    @Procedure(name = "EliminarAlumno")
    void eliminarAlumno(@Param("p_idalumno") int p_idalumno);

    @Procedure(name = "GetAllAlumnoSP", refCursor = true)
    List<Alumno> GetAllAlumnoSP();
}
