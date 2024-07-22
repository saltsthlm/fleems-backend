package com.lans.fleems.error;

import java.util.NoSuchElementException;

public class NoSuchTaskException extends NoSuchElementException {
    public NoSuchTaskException (){
        super("no Task with matching id found");
    }
}
