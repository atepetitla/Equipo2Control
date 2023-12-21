/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.JPARepository;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author digis
 */
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    Optional<Materia> findByNombre(String nombre);

    @Procedure(name = "InsertarMateria")
    void InsertarMateria(String p_Nombre, int Costo);

    @Procedure(name = "ActualizarMateria")
    void ActualizarMateria(@Param("p_idmateria") int p_idmateria, @Param("p_NuevoNombre") String p_NuevoNombre, @Param("p_NuevoCosto") int p_NuevoCosto);

    @Procedure(name = "EliminarMateria")
    void eliminarMateria(@Param("p_idmateria") int p_idmateria);
    
     @Procedure(name = "GetAllMateriaSP", refCursor = true)
    List<Materia> GetAllMateriaSP();

}
