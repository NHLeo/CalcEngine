package com.se.ed.calcengine;

public class Divider extends CalculateBase implements MathProcessing
{
    public Divider () {}
    public Divider (double leftVal, double rightVal)
    {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate ()
    {
        double value;
//        if (getRightVal() != 0) {
            value = getLeftVal() / getRightVal();
//        }
//        else
//        {
//            value = 0d;
//        }

        setResult(value);
    }

    public String getKeyword() {
        return "divide";
    }

    public char getSymbol() {
        return '/';
    }

    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}