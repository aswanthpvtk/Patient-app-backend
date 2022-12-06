package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;

     @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String PatientAdd(@RequestBody Patient p)
      {
          dao.save(p);
    return "add patient";
      }

}
