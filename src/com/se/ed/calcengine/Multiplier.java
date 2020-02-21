package com.se.ed.calcengine;

public class Multiplier extends CalculateBase implements MathProcessing
{
    public Multiplier () {}
    public Multiplier (double leftVal, double rightVal)
    {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate ()
    {
        double value = getLeftVal() * getRightVal();
        setResult(value);
    }

    public String getKeyword() {
        return "multiply";
    }

    public char getSymbol() {
        return '*';
    }

    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}