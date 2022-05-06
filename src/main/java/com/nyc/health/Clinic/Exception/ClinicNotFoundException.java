package com.nyc.health.Clinic.Exception;

public class ClinicNotFoundException extends RuntimeException{

       public ClinicNotFoundException(String msg){
            super(msg);
       }
}
