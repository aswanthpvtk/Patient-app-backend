package com.nest.patientapp_backend.dao;

import com.nest.patientapp_backend.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientDao extends CrudRepository<Patient,Integer> {
}
