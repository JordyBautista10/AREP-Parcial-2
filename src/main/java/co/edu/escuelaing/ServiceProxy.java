package co.edu.escuelaing;

import static spark.Spark.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ServiceProxy {

    static String[] servers = new String[]{"http://localhost:4567/", "http://localhost:4567/"};
    static int counter = 0;

    public static void main(String... args){

        port(getPort());
        staticFileLocation("public");
        get("search", (req,res) -> {
            String list = req.queryParams("list");
            String value = req.queryParams("value");
            String opt = req.queryParams("operation");
            System.out.println("->" + counter + " --- " + opt);
            return HttpConnection.call(RoundRobin()+ opt + "?list=" + list + "&value=" + value);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4566;
    }

    private static String RoundRobin(){
        counter += 1;
        counter = (counter == 2) ? 0 : 1;
        return servers[counter];
    }

}