public class sampleHallo {

    String getString = "hola bro";

    public void getString(){
        System.out.println(this.getString);
    }

    public static void main(String args[]) {

        sampleHallo hay = new sampleHallo();
        hay.getString();
    }
}
