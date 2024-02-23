package com.uaits.tests;

import java.util.List;

public class Test {
    String name;
    List<Object> inputs;
    Object output;
    Object expectedReturn;

    public Test(String name, List<Object> inputs, Object expectedReturn) {
        this.name = name;
        this.inputs = inputs;
        this.expectedReturn = expectedReturn;
    }

    public List<Object> getInputs() {
        return inputs;
    }

    public Object getOutput() {
        return output;
    }

    public Object getExpectedReturn() {
        return expectedReturn;
    }

    public String getName() {
        return name;
    }

    public boolean isPassed()  {

        if(!ArrayObject.isArrayObject(output))
            return output.equals(expectedReturn);
        else
            return ArrayObject.equalArray(output, expectedReturn);
    }
}
