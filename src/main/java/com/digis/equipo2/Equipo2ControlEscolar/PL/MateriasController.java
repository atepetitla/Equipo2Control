/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.PL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
import com.digis.equipo2.Equipo2ControlEscolar.DL.Materia;
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
@RequestMapping("/materia")
public class MateriasController {

    @GetMapping("/getall")
    public String getall(Model model) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/materiarest/getall";
        ResponseEntity<List<Materia>> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Materia>>() {
        }
        );
        List<Materia> materias = response.getBody();
        model.addAttribute("materias", materias);
        model.addAttribute("materia", new Materia());
        return "Materia";
    }

    @GetMapping("/getbyid/{id}")
    public String getbyid(@PathVariable int id, Model model) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/materiarest/getbyid/" + id;
        Materia materia = rest.getForObject(url, Materia.class);

        model.addAttribute("materia", materia);
        return "Inicio";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/materiarest/delete/" + id;
            rest.getForObject(url, Materia.class);
            return "redirect:/materia/getall";
        } catch (Exception e) {
            return "Alumno";
        }

    }

    @GetMapping("/form/{id}")
    public String formulario(@PathVariable int id, Model model) {
        if (id != 0) {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/materiarest/getbyid/" + id;
            Alumno alumno = rest.getForObject(url, Alumno.class);
            model.addAttribute("alumno", alumno);
        } else {
            model.addAttribute("alumno", new Alumno());
        }
        return "Inicio";
    }

    @PostMapping("/form")
    public String guardar(@ModelAttribute("materia") Materia materia) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/materiarest/add";

            HttpEntity<Materia> reques = new HttpEntity<>(materia);
            rest.postForObject(url, reques, Materia.class);
            return "redirect:/materia/getall";
        } catch (Exception e) {
            return "inicio";
        }

    }

}
