package com.lans.fleems.error.exception;

import java.util.NoSuchElementException;

public class NoSuchClientException extends NoSuchElementException {
    public NoSuchClientException (){
        super("no client with matching id found");
    }
}
