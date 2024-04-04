package co.edu.escuelaing;

import java.util.ArrayList;
import java.util.Arrays;

import static spark.Spark.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MathServices {

    public static void main(String... args){
        port(getPort());
        get("linearsearch", (req,res) -> {
            res.type("application/json");
            String result = "";
            String numbers = req.queryParams("list");
            String value = req.queryParams("value");
            try {
                String[] numbersList = numbers.split(",");
                int valueInt = Integer.parseInt(value);
                result = LinearSearch(numbersList, valueInt);
            } catch (Exception e) {
                result = e.getMessage();
            }
            Response response = new Response("linearSearch", numbers, value, result);
            return response;
        });

        get("binarysearch", (req,res) -> {
            String result = "";
            String numbers = req.queryParams("list");
            String value = req.queryParams("value");
            try {
                String[] numbersList = numbers.split(",");
                int valueInt = Integer.parseInt(value);
                result = BynarySearch(numbersList, valueInt);
            } catch (Exception e) {
                result = e.getMessage();
            }
            Response response = new Response("linearSearch", numbers, value, result);
            return response.toString();
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
        for (int i = 0; i < numbersList.length; i++){
            if (Integer.parseInt(numbersList[i]) == valueInt) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }

}