/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis.equipo2.Equipo2ControlEscolar.PL;

import com.digis.equipo2.Equipo2ControlEscolar.DL.Alumno;
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
@RequestMapping("/alumno")
public class AlumnoController {

    @GetMapping("/getall")
    public String getall(Model model) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/alumnorest/getall";
        String urlSP = "http://localhost:8080/alumnorest/getallsp";
        ResponseEntity<List<Alumno>> response = rest.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Alumno>>() {
        }
        );
        ResponseEntity<List<Alumno>> responseSP = rest.exchange(
                urlSP,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Alumno>>() {
        }
        );
        List<Alumno> alumnos = response.getBody();
        List<Alumno> alumnosSP = responseSP.getBody();
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("alumnosSP", alumnosSP);
        model.addAttribute("alumno", new Alumno());
        return "Alumno";
    }

    @GetMapping("/getbyid/{id}")
    public String getbyid(@PathVariable int id, Model model) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/alumnorest/getbyid/" + id;
        Alumno alumno = rest.getForObject(url, Alumno.class);

        model.addAttribute("alumnos", alumno);
        return "Inicio";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/alumnorest/delete/" + id;
        rest.getForObject(url, Alumno.class);
        return "redirect:/alumno/getall";
    }

    @GetMapping("/deleteSP/{id}")
    public String deleteSP(@PathVariable int id) {
        RestTemplate rest = new RestTemplate();
        String url = "http://localhost:8080/alumnorest/deleteSP/" + id;
        rest.getForObject(url, Alumno.class);
        return "redirect:/alumno/getall";
    }

    @GetMapping("/form/{id}")
    public String formulario(@PathVariable int id, Model model) {
        String regreso;
        if (id != 0) {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnorest/getbyid/" + id;
            Alumno alumno = rest.getForObject(url, Alumno.class);
            model.addAttribute("alumno", alumno);
            regreso = "FormAlumno";
        } else {
            model.addAttribute("alumno", new Alumno());
            regreso = "FormAlumno";
        }
        return regreso;
    }

    @GetMapping("/formnormal/{id}")
    public String formularionormal(@PathVariable int id, Model model) {
        String regreso;
        if (id != 0) {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnorest/getbyid/" + id;
            Alumno alumno = rest.getForObject(url, Alumno.class);
            model.addAttribute("alumno", alumno);
            regreso = "FormAlumno_1";
        } else {
            model.addAttribute("alumno", new Alumno());
            regreso = "FormAlumno_1";
        }
        return regreso;
    }

    @PostMapping("/formnormal")
    public String guardar(@ModelAttribute("alumno") Alumno alumno) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnorest/add";

            HttpEntity<Alumno> reques = new HttpEntity<>(alumno);
            rest.postForObject(url, reques, Alumno.class);
            return "redirect:/alumno/getall";
        } catch (Exception e) {
            return "inicio";
        }
    }

    @PostMapping("/form")
    public String guardarSP(@ModelAttribute("alumno") Alumno alumno) {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:8080/alumnorest/addStored";

            HttpEntity<Alumno> reques = new HttpEntity<>(alumno);
            rest.postForObject(url, reques, Alumno.class);
            return "redirect:/alumno/getall";
        } catch (Exception e) {
            return "inicio";
        }
    }
}
