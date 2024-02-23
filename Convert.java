public class Convert {

    public static Object[] convertObjToArray(Object obj){

        if(obj instanceof int[]) {
            Integer[] integerArray = convertToInteger((int[]) obj);
            return convertToIntegerArrayObject(integerArray);
        }
        else
            return (Object[]) obj;
    }

    public static Integer[] convertToInteger(int[] intArray) {
        Integer[] integerArray = new Integer[intArray.length];
        for (int i = 0; i < intArray.length; i++) {
            integerArray[i] = intArray[i];
        }
        return integerArray;
    }

    public static Object[] convertToIntegerArrayObject(Integer[] integerArray) {
        return integerArray;
    }

}
