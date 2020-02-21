package com.se.ed.calcengine;

public class CalculateHelper {
    private MathCommand command;
    private double leftValue;
    private double rightValue;
    private double result;

    public void process (String statement) throws MathStatementException
    {
        String [] parts = statement.split(" ");
        if (parts.length != 3)
        {
            throw new MathStatementException("Invalid number of parts in statement [" + statement + "]");
        }

        String commandString = parts[0];
        try {
            leftValue = Double.parseDouble(parts[1]);
            rightValue = Double.parseDouble(parts[2]);
        }
        catch (Exception parseException)
        {
            throw new MathStatementException("Error parsing doubles [" + statement + "]", parseException);
        }

        setCommandFromString(commandString);
        CalculateBase calculator = null;

        switch (command) {
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtracter(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            default:
                throw new MathStatementException("Invalid operation in statement [" + statement + "]");
        }

        try {
            calculator.calculate();
            this.result = calculator.getResult();
        }
        catch (Exception e)
        {
            throw new MathStatementException("Error during calculate", e);
        }
    }

    public void setCommandFromString (String commandString) throws MathStatementException
    {
        if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
        {
            command = MathCommand.Add;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
        {
            command = MathCommand.Subtract;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
        {
            command = MathCommand.Multiply;
        }
        else if (commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
        {
            command = MathCommand.Divide;
        }
        else
        {
            throw new MathStatementException("Invalid operation - " + commandString);
        }
    }

    @Override
    public String toString()
    {
        String operation = "";

        switch (command)
        {
            case Add:
                operation = "+";
                break;
            case Subtract:
                operation = "-";
                break;
            case Multiply:
                operation = "*";
                break;
            case Divide:
                operation = "/";
                break;
            default:
                operation = "unknown";
                break;
        }

        return leftValue + " " + operation + " " + rightValue + " = " + result;
    }
}
