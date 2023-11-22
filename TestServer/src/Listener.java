import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Listener extends Thread{
    private Socket socket;

    @Override
    public void run() {
        try {
            System.out.println("Connected from " + socket.getInetAddress().getHostAddress() +
                    " on " + this.getId());
            Scanner scan = new Scanner(socket.getInputStream());
            int number = scan.nextInt();
            PrintStream printout = new PrintStream(socket.getOutputStream());
            if ((number % 2) == 0) {
                printout.println("your number is even");
            } else {
                printout.println("your number is odd");
            }
            System.out.println("Connected with " + socket.getInetAddress().getHostAddress() + " finished");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public Listener(Socket socket) {
        this.socket = socket;
    }
}
