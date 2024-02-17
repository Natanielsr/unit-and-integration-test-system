/*
Author: Nataniel Soares Rodrigues
Date: 16/02/2024
github: https://github.com/Natanielsr
*/
package com.uaits.tests;

import com.uaits.utils.Console;
import com.uaits.utils.ConsoleColor;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implement a unit and integration test system;
 * extend this class to your class;
 * use Add() method to add your tests in a Test object type;
 * override Execute() method with your logic test and return the output result;
 * Use RunTests() to Run all tests and will return a testList with the outputs;
 * Use PrintTests() to see the result in a friendly view format;
 */
public abstract class TestController {

    private List<Test> testsList;

    public TestController(){
        testsList = new ArrayList<>();
    }

    public void testSetup(List<Test> tests){
        this.testsList = tests;
    }

    /**Add Test to the testList**/
    public void Add(Test obj){
        testsList.add(obj);
    }

    /**Implements Execute with the test Logic and return the output result
     * @param test individual test with input values and other data
     * @return Return the output result value of the logic**/
    protected abstract Object execute(Test test);

    /**Run All tests from the testList**/
    public void runTests() {
        for( Test obj : testsList){
            try {
                //Run the test
                obj.output = this.execute(obj);
            }catch (Exception e){
                // Catch and handle the exception
                obj.output = e.getMessage();
            }

        }
    }

    /** a ez way to create your Test object**/
    public static Test makeTest(
            String name,
            List<Object> inputs,
            Object expectedReturn){

        return new Test(
                name,
                inputs,
                expectedReturn
        );
    }

    /** a method thats print all your tests results with pass or did not pass **/
    public void printTests(){
        int failedCount = 0;
        int successCount = 0;
        int total = testsList.size();
        for(Test obj : testsList){
            Console.Log("Name Test: " + obj.getName());
            Console.Log("Input: " + obj.getInputs());
            Console.Log("Output: " + obj.getOutput());
            Console.Log("Expected: " + obj.getExpectedReturn());

            String passed;
            ConsoleColor color;
            if(obj.isPassed()){
                passed = "Passed ✔\uFE0F";
                color = ConsoleColor.GREEN;
                successCount ++;
            }
            else{
                passed = "Did Not Pass ❌";
                color = ConsoleColor.RED;
                failedCount ++;
            }
            Console.Log("Result: " + passed, color);

            System.out.println();
        }
        ConsoleColor colorResult;
        if(failedCount > 0){
            colorResult = ConsoleColor.RED;
            Console.Log("Finished with "+failedCount+" failed of "+total, colorResult);
        }
        else{
            colorResult = ConsoleColor.GREEN;
            Console.Log("Finished with "+successCount+" success of "+total, colorResult);
        }
    }
}
