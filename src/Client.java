import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.Scanner;

class Client implements Runnable {
    Socket socket;

    Scanner in;
    PrintStream out;
    ChatServer server;

    public Client(Socket socket, ChatServer server){
        this.socket = socket;
        this.server = server;
        new Thread(this).start();

    }

    void receive(String message) {
        out.println(message);
    }

    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            in = new Scanner(is);
            out = new PrintStream(os);

            out.println("Welcome to chat!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                server.sendAll(input);
                input = in.nextLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
