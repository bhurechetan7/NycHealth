package com.nyc.health.Clinic.Repository;

import com.nyc.health.Clinic.EntityClinic.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic,Integer>
{


}
