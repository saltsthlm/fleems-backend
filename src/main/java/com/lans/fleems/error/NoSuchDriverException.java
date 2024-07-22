package com.lans.fleems.error;

import java.util.NoSuchElementException;

public class NoSuchDriverException extends NoSuchElementException {
    public NoSuchDriverException (){
        super("no driver with matching id found");
    }
}
