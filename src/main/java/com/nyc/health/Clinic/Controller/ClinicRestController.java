package com.nyc.health.Clinic.Controller;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.nyc.health.Clinic.EntityClinic.Clinic;
import com.nyc.health.Clinic.Service.ServiceImpl;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/nycHealth")
@SecurityRequirement(name="clinicAPI")
public class ClinicRestController {

    @Autowired
     private ServiceImpl service;

      @GetMapping("/allClinic")
     public ResponseEntity<List<Clinic>> viewAllClinic(){
           String msg = "list of All Clinic";
          HttpHeaders headers = new HttpHeaders();
            headers.add("desc","it will give list of all Clinic");
         // service.getAllClinic();
          return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.getAllClinic());
     }

     @GetMapping("/clinic/{id}")
      public ResponseEntity<Clinic> getClinicById(@PathVariable(value="id") Integer id )
           {
                 HttpHeaders headers = new HttpHeaders();
                    headers.add( "dsc", "Record of Clinic with id :" + id);
                   return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.getClinicById(id));

           }


     @PostMapping("/registerClinic")
     public ResponseEntity<Clinic> saveClinic(@RequestBody @Valid Clinic newClinic){
           HttpHeaders headers = new HttpHeaders();
           headers.add("desc", "It will register new CLinic");
        // service.registerNewClinic(newClinic);
           return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.registerNewClinic(newClinic));
     }
      @PutMapping("/updateClinic/{id}")
     public  ResponseEntity<String> updateClinic(@PathVariable Integer id, @RequestBody @Valid Clinic newClinic){
                   service.updateClinicRecord(newClinic, id);
                   return new ResponseEntity<>("Clinic Record with id " + id + " has updated", HttpStatus.OK);
     }

     @DeleteMapping("/deleteClinic/{id}")
     public ResponseEntity<String> deleteClinic(@PathVariable(value="id") Integer id ){
               service.deleteClinic(id);
               return new ResponseEntity<>("Clinic Record with id " + id + " has deleted", HttpStatus.OK);

     }
}
