package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;
@CrossOrigin(origins = "*")
     @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> PatientAdd(@RequestBody Patient p)
      {

          System.out.println(p.getDate().toString());
          dao.save(p);
          HashMap<String,String> map =new HashMap<>();
          map.put("status","success");
          return map;

      }

    @CrossOrigin(origins = "*")
      @GetMapping("/view")
      public List<Patient> View()
      {
          return (List<Patient>) dao.findAll();
      }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Patient> Search(@RequestBody Patient s)
    {

        String pcode=String.valueOf(s.getPcode());

        return(List<Patient>)dao.SearchPatient(s.getPcode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> Delete(@RequestBody Patient e)
    {

        String pcode=String.valueOf(e.getId());
        System.out.println(pcode);
        dao.deletePatient(e.getId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");

        return map;
    }

}
