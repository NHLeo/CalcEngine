package com.se.ed.calcengine;

public class Subtracter extends CalculateBase implements  MathProcessing
{
    public Subtracter () {}
    public Subtracter (double leftVal, double rightVal)
    {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate ()
    {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }

    public String getKeyword() {
        return "subtract";
    }

    public char getSymbol() {
        return '-';
    }

    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
