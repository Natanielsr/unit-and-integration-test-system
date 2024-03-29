package com.uaits.tests;

import java.util.ArrayList;
import java.util.List;

public class Example extends TestController { //extends TestControler
    public void start() {

        Test test01 = TestFactory(
                "Test 01", //name of the test
                InputFactory(1, 1), //inputs list
                2); //output expected

        Test test02 = TestFactory(
                "Test 02",
                InputFactory(2, 2),
                4);

        Test test03 = TestFactory(
                "Test 03",
                InputFactory(3,3),
                6);

        List<Test> tests = new ArrayList<>();
        tests.add(test01);
        tests.add(test02);
        tests.add(test03);

        testSetup(tests);
        runTests();
        printTests();

    }

    protected Integer Execute(Test test){ //implement you logic test
        //params
        Integer input1 = ((Character) test.getInputs().get(0)); //convert Object to Character
        Integer input2 = (Integer) test.getInputs().get(1); // convert Object to Integer

        Integer result = input1 + input2;

        //output
        return result;
    }

    List<Object> InputFactory(Integer input1, Integer input2){
        List<Object> inputs = new ArrayList<>();
        inputs.add(input1);
        inputs.add(input2);

        return inputs;
    }
}
