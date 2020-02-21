package com.se.ed.myapp;

import com.se.ed.calcengine.Adder;
import com.se.ed.calcengine.CalculateBase;
import com.se.ed.calcengine.CalculateHelper;
import com.se.ed.calcengine.Divider;
import com.se.ed.calcengine.DynamicHelper;
import com.se.ed.calcengine.MathEquation;
import com.se.ed.calcengine.MathProcessing;
import com.se.ed.calcengine.MathStatementException;
import com.se.ed.calcengine.Multiplier;
import com.se.ed.calcengine.PowerOf;
import com.se.ed.calcengine.Subtracter;

public class Main {

    public static void main(String[] args) {

        String [] statements =
        {
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0",
                "power 5.0 2.0"
        };

        DynamicHelper dynamicHelper = new DynamicHelper( new MathProcessing[ ] {
                new Adder(), new Divider(), new Multiplier(), new Subtracter(), new PowerOf()
        });

        for (String statement:statements)
        {
            String output = dynamicHelper.process(statement);
            System.out.println(output);
        }
    }

    public void useCalculateHelper()
    {
        String [] statements =
                {
                        "add 1",
                        "add xx 25",
                        "junk 5 5",
                        "divide 20 0",
                        "divide 100.0 50.0",
                        "add 25.0 92.0",
                        "subtract 225.0 17.0",
                        "multiply 11.0 3.0"
                };

        CalculateHelper helper = new CalculateHelper();
        for (String statement:statements)
        {
            try {
                helper.process(statement);
                System.out.println(helper);
            }
            catch (MathStatementException ex)
            {
                System.out.println("Error occurred: " + ex);
                if (ex.getCause() != null)
                {
                    System.out.println(ex.getCause());
                }
            }
        }
    }

    public void useMathEquation()
    {
//        double [] leftvals = {100d, 25d, 225d, 11d};
//        double [] rightvals = {50d, 92d, 17d, 3d};
//        char [] opcodes = {'d', 'a','s','m'};
//        double [] results = new double [opcodes.length];
//        double val1 = 100d;
//        double val2 = 50d;
//        double result = 0d;
//        char opCode = 'a';

        MathEquation[] equations = new MathEquation[4];

        equations[0] = new MathEquation(100d, 50d, 'd');
        equations[1] = new MathEquation(25d, 92d, 'a');
        equations[2] = new MathEquation(225d, 17d, 's');
        equations[3] = new MathEquation(11d, 3d, 'm');

        for (MathEquation eq : equations) {
            eq.execute();
            System.out.print("result = ");
            System.out.println(eq.getResult());
        }
    }

    public void useCalculateBase()
    {
        CalculateBase[] calculators = {
                new Divider(100d, 50d),
                new Adder(25d, 92d),
                new Subtracter(225d, 17d),
                new Multiplier(11d, 3d)
        };

        for (CalculateBase calc : calculators)
        {
            calc.calculate();
            System.out.println(calc.getResult());
        }
    }
}
