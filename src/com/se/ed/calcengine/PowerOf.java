package com.se.ed.calcengine;

public class PowerOf extends CalculateBase implements MathProcessing{
    public PowerOf() {}
    public PowerOf(double leftVal, double rightVal)
    {
        super(leftVal, rightVal);
    }

    @Override
    public void calculate ()
    {
        double value = Math.pow(getLeftVal(), getRightVal());
        setResult(value);
    }

    public String getKeyword() {
        return "power";
    }

    public char getSymbol() {
        return '^';
    }

    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();
        return getResult();
    }
}
