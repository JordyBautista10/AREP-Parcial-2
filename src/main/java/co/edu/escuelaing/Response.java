package co.edu.escuelaing;

public class Response {
    String operation;
    String inputlist;
    String value;
    String output;

    public Response(String operation, String inputlist, String value, String output){
        this.operation = operation;
        this.inputlist = inputlist;
        this.value = value;
        this.output = output;
    }

    @Override
    public String toString() {
        return "{" +
                "operation:'" + operation + '\'' +
                ", inputlist:'" + inputlist + '\'' +
                ", value:'" + value + '\'' +
                ", output:'" + output + '\'' +
                '}';
    }
}
