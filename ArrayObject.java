public class ArrayObject {
    public static boolean equalArray(Object obj1, Object obj2) {
        // Verificar se o objeto é um array
        if (isArrayObject(obj1) && isArrayObject(obj1)) {
            // Converter o objeto para um array de objetos
            Object[] array1 = Convert.convertObjToArray(obj1);
            Object[] array2 = Convert.convertObjToArray(obj2);

            return compareArrays(array1, array2);

        } else {
            // O objeto não é um array
            return false;
        }
    }

    public static boolean isArrayObject(Object obj){
        return obj.getClass().isArray();
    }

    private static boolean compareArrays(Object[] array1, Object[] array2){
        if (equalSizeArray(array1, array2))
            return equalArrayValues(array1, array2);
        else
            return false;
    }

    private static boolean equalSizeArray(Object[] array1, Object[] array2){
        return array1.length == array2.length;
    }

    private static boolean equalArrayValues(Object[] array1, Object[] array2){
        // Comparar cada elemento dos arrays
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
}
