package com.se.ed.calcengine;

public interface MathProcessing {
    String SEPARATOR = " ";
    String getKeyword();
    char getSymbol();
    double doCalculation(double leftVal, double rightVal);
}
