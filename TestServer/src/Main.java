import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(1211)){
            while (true) {
                new Listener(server.accept()).start();
            }
        }

    }
}