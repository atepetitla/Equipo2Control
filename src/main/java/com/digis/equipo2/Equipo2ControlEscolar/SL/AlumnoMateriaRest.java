/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.SL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.DL.AlumnoMateria;
import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
import com.digis.equipo2.Equipo2ControlEscolar.JPARepository.AlumnoMateriaService;
import com.digis.equipo2.Equipo2ControlEscolar.JPARepository.AlumnoService;
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
@RequestMapping("/alumnoMateriaRest")
public class AlumnoMateriaRest {

    private AlumnoMateriaService alumnoMateriaService;
    private AlumnoService alumnoService;
    private MateriaService materiaService;

    public AlumnoMateriaRest(AlumnoMateriaService alumnoMateriaService, AlumnoService alumnoService, MateriaService materiaService) {
        this.alumnoMateriaService = alumnoMateriaService;
        this.alumnoService = alumnoService;
        this.materiaService = materiaService;
    }

    @GetMapping("/getbyid/{id}")
    public Optional<AlumnoMateria> get(@PathVariable int id) {

        return alumnoMateriaService.obtenerRelacionPorId(id);
    }

    @GetMapping("/getall")
    public List<AlumnoMateria> getall() {
        return alumnoMateriaService.obtenerRelaciones();
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody AlumnoMateria alumnoMateria) {
        
        //Requiere que en el body se manden los nombres de la materia y el nombre del alumno para hacer una busqueda por su nombre y asigarlo.
        ResponseEntity respo = null;
        Optional<Alumno> alumnoOptional = alumnoService.getbynombre(alumnoMateria.getAlumno().getNombre());
        Optional<Materia> materiaOptional = materiaService.getbynombre(alumnoMateria.getMateria().getNombre());

        try {
            if (alumnoOptional.isPresent() && materiaOptional.isPresent()) {
                Alumno alumno = alumnoOptional.get();
                Materia materia = materiaOptional.get();

                // Resto del código aquí...
                alumnoMateria.setAlumno(alumno);
                alumnoMateria.setMateria(materia);
                if (alumnoMateria.getIdalumnomateria() != 0) {
                    alumnoMateriaService.guardarRelacion(alumnoMateria);
                    respo = new ResponseEntity(HttpStatus.ACCEPTED);
                } else {
                    alumnoMateriaService.guardarRelacion(alumnoMateria);
                    respo = new ResponseEntity(HttpStatus.ACCEPTED);
                }
            } else {
                // Manejar el caso en el que no se encuentre el alumno o la materia
                respo = new ResponseEntity("Alumno o materia no encontrados", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            respo = new ResponseEntity("Revisa los datos ingresados", HttpStatus.CONFLICT);
        }
        return respo;
    }

}
