package com.lans.fleems.error.exception;

import java.util.NoSuchElementException;

public class NoSuchTaskException extends NoSuchElementException {
    public NoSuchTaskException (){
        super("no Task with matching id found");
    }
}
