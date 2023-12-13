/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.SL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.JPARepository.AlumnoRepository;
import com.digis.equipo2.Equipo2ControlEscolar.JPARepository.AlumnoService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digis
 */
@RestController
@RequestMapping("/alumnorest")
public class AlumnoRest {

    private AlumnoService alumnoservice;

    public AlumnoRest(AlumnoService alumnoservice) {
        this.alumnoservice = alumnoservice;
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Alumno> get(@PathVariable int id) {

        return alumnoservice.obtenerAlumnoPorId(id);
    }

    @GetMapping("/getall")
    public List<Alumno> getall() {
        return alumnoservice.obtenerTodosLosAlumnos();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Alumno alumno) {
        ResponseEntity respo = null;
        try {
            if (alumno.getIdalumno() != 0) {
                alumnoservice.guardarAlumno(alumno);
                respo = new ResponseEntity(HttpStatus.ACCEPTED);
            } else {
                alumnoservice.guardarAlumno(alumno);
                respo = new ResponseEntity(HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            respo = new ResponseEntity(HttpStatus.CONFLICT);
        }
        return respo;
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        ResponseEntity respo = null;
        try {
            alumnoservice.eliminarAlumno(id);
            respo = new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            respo = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return respo;
    }

}
