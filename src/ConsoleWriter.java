public class ConsoleWriter implements Writer {
int count=0;
    @Override
    public void methodWriter(String message) {
    count++;
        System.out.println(message);
    }
}
