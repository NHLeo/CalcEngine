package com.se.ed.calcengine;

public class DynamicHelper {
    private MathProcessing [] handlers;

    public DynamicHelper (MathProcessing [] handlers)
    {
        this.handlers = handlers;
    }

    public String process (String statement)
    {
        String [] parts = statement.split(MathProcessing.SEPARATOR);

        String keyword = parts[0];

        MathProcessing theHandler = null;

        for (MathProcessing handler:this.handlers)
        {
            if (keyword.equalsIgnoreCase(handler.getKeyword()))
            {
                theHandler = handler;
                break;
            }
        }

        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);

        double calcResult = theHandler.doCalculation(leftValue, rightValue);

        return leftValue + " " + theHandler.getSymbol() + " " + rightValue + " = " + calcResult;
    }
}
