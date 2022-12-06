package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;
@CrossOrigin(origins = "*")
     @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String PatientAdd(@RequestBody Patient p)
      {

          System.out.println(p.getDate().toString());
          dao.save(p);
    return "add patient";
      }

    @CrossOrigin(origins = "*")
      @GetMapping("/view")
      public List<Patient> View()
      {
          return (List<Patient>) dao.findAll();
      }

}
