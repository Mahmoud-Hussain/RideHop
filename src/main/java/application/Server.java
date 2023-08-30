package application;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private ServerSocket serverSocket;




    Server() {

        try {


            serverSocket = new ServerSocket(33333);
            System.out.println("Server Start......");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("found");
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException, ClassNotFoundException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);

        String clientName = (String) networkUtil.read();

        new ReadThread(networkUtil);
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}
