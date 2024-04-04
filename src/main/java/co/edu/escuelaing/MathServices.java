package co.edu.escuelaing;

import static spark.Spark.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MathServices {

    public static void main(String... args){
        port(getPort());
        get("linearsearch", (req,res) -> {
            res.type("application/json");
            String result;
            String numbers = req.queryParams("list");
            String value = req.queryParams("value");
            try {
                String[] numbersList = numbers.split(",");
                int valueInt = Integer.parseInt(value);
                result = LinearSearch(numbersList, valueInt);
            } catch (Exception e) {
                result = e.getMessage();
            }
            return new Response("linearSearch", numbers, value, result);
        });

        get("binarysearch", (req,res) -> {
            res.type("application/json");
            String result;
            String numbers = req.queryParams("list");
            String value = req.queryParams("value");
            try {
                String[] numbersList = numbers.split(",");
                int valueInt = Integer.parseInt(value);
                result = BynarySearch(numbersList, valueInt);
            } catch (Exception e) {
                result = e.getMessage();
            }
            return new Response("binarySearch", numbers, value, result);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static String LinearSearch(String[] numbersList, int valueInt){
        for (int i = 0; i < numbersList.length; i++){
            if (Integer.parseInt(numbersList[i]) == valueInt) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }

    private static String BynarySearch(String[] numbersList, int valueInt){
        //Suponiendo que la lista esta ordenada de menor a mayor
        int head = 0;
        int tail = numbersList.length - 1;
        int current = numbersList.length / 2;

        for (int i = 0; i < numbersList.length; i++){
            if (Integer.parseInt(numbersList[current]) < valueInt) {
                head = current;
            } else if ( Integer.parseInt(numbersList[current]) > valueInt ) {
                tail = current;
            } else {
                return String.valueOf(current);
            }
            current = (head + tail) / 2;
        }
        return "-1";
    }

}