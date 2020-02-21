package com.se.ed.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private char opcode;
    private double result;

    public MathEquation(double left, double right, char op)
    {
        leftVal = left;
        rightVal = right;
        opcode = op;
    }

    public double getLeftVal () {return this.leftVal;}
    public double getRightVal () {return this.rightVal;}
    public double getResult () {return this.result;}
    public double getOpcode () {return this.opcode;}

    public void execute ()
    {
        switch (opcode) {
            case ('a'):
                result = leftVal + rightVal;
                break;
            case ('s'):
                result = leftVal - rightVal;
                break;
            case('m'):
                result = leftVal * rightVal;
                break;
            case('d'):
                result = rightVal != 0 ? leftVal / rightVal : 0d;
//                if (rightVal == 0)
//                {
//                    System.out.println("Error - division by 0");
//                    result = 0d;
//                }
//                else
//                {
//                    result = leftVal / rightVal;
//                }
                break;
            default:
                System.out.println("Error - invalid opcode");
                result = 0d;
                break;
        }
    }
}
