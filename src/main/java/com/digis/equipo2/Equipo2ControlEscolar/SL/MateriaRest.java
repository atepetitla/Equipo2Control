/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.SL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import com.digis.equipo2.Equipo2ControlEscolar.JPARepository.MateriaService;
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
@RequestMapping("/materiarest")
public class MateriaRest {

    private MateriaService materiaService;

    public MateriaRest(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @GetMapping("/getall")
    public List<Materia> getall() {
        return materiaService.Getall();
    }

    @GetMapping("/getbyid/{id}")
    public Optional<Materia> getbyid(@PathVariable int id) {
        return materiaService.byid(id);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Materia materia) {
        ResponseEntity respo = null;
        try {
            if (materia.getIdmateria() != 0) {
                materiaService.guardarMateria(materia);
                respo = new ResponseEntity(HttpStatus.ACCEPTED);
            } else {
                materiaService.guardarMateria(materia);
                respo = new ResponseEntity(HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            respo = new ResponseEntity(HttpStatus.CONFLICT);
        }
        return respo;
    }

    @GetMapping("/i/{nombre}")
    public Optional<Materia> obtenerAlumnoPorNombre(@PathVariable String nombre) {
        return materiaService.getbynombre(nombre);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        ResponseEntity respo = null;
        try {
            materiaService.eliminarMateria(id);
            respo = new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            respo = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return respo;
    }

}
