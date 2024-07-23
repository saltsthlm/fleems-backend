package com.lans.fleems.error.exception;

import java.util.NoSuchElementException;

public class NoSuchVehicleException extends NoSuchElementException {
    public NoSuchVehicleException (){
        super("no vehicle with matching id found");
    }
}
