package console;

public interface Writer {
     static void methodWriter(String message) {
          System.out.println(message);
     }

     static void writeError(String message) {
          System.out.println(message);
     }

}
