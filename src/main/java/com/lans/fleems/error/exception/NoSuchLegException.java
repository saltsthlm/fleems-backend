package com.lans.fleems.error.exception;

import java.util.NoSuchElementException;


public class NoSuchLegException extends NoSuchElementException {
    public NoSuchLegException (){
        super("no Leg with matching id found");
    }
}
