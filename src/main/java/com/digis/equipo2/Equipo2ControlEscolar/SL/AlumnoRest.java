/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.SL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/alumnorest")
public class AlumnoRest {
    
    @GetMapping("/add")
    public Alumno get(){
        Alumno alumno= new Alumno();
        return alumno;
    }
    
    
}
