package com.se.ed.calcengine;

public class MathStatementException extends Exception {
    public MathStatementException (String errorMessage)
    {
        super(errorMessage);
    }

    public MathStatementException(String errorMessage, Throwable cause)
    {
        super(errorMessage, cause);
    }
}

