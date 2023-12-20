/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.PL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.AlumnoMateria;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author digis
 */
@Controller
@RequestMapping("/alumnoMateria")
public class AlumnoMateriaController {

    @GetMapping("/getall")
    public String getall(Model model) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/alumnoMateriaRest/getall";
        ResponseEntity<List<AlumnoMateria>> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<AlumnoMateria>>() {
        }
        );
        List<AlumnoMateria> materias = response.getBody();
        model.addAttribute("alumnoMaterias", materias);
        model.addAttribute("alumnoMateria", new AlumnoMateria());
        return "Relacion";
    }

    @GetMapping("/deleteSP/{id}")
    public String deleteSP(@PathVariable int id) {
        try {
            String url = "http://localhost:8080/alumnoMateriaRest/deleteSP/" + id;
            RestTemplate rest = new RestTemplate();
            rest.getForObject(url, AlumnoMateria.class);
            return "redirect:/alumnoMateria/getall";
        } catch (Exception e) {
            return "inicio";
        }
    }

    @PostMapping("/form")
    public String guardar(@ModelAttribute("alumnoMateria") AlumnoMateria alumnoMateria) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnoMateriaRest/add";

            HttpEntity<AlumnoMateria> reques = new HttpEntity<>(alumnoMateria);
            rest.postForObject(url, reques, AlumnoMateria.class);
            return "redirect:/alumnoMateria/getall";
        } catch (Exception e) {
            return "inicio";
        }
    }
     @PostMapping("/formSP")
    public String guardarSP(@ModelAttribute("alumnoMateria") AlumnoMateria alumnoMateria) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnoMateriaRest/addSP";

            HttpEntity<AlumnoMateria> reques = new HttpEntity<>(alumnoMateria);
            rest.postForObject(url, reques, AlumnoMateria.class);
            return "redirect:/alumnoMateria/getall";
        } catch (Exception e) {
            return "inicio";
        }
    }

}
