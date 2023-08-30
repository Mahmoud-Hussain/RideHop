package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;



public class Client {
    BufferedReader BR1;


    public Client(String serverAddress, int serverPort) {
        try {
             BR1 = new BufferedReader(new FileReader("onlyname.txt"));

             String User_name = BR1.readLine();

             System.out.print("Send Message: ");


            NetworkUtil networkUtil = new NetworkUtil(serverAddress, serverPort);

            networkUtil.write(User_name);

            new ReadThread(networkUtil);
            new WriteThreadClient(networkUtil, User_name);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public static void main(String args[]) {
//        String serverAddress = "127.0.0.1";
//        int serverPort = 33333;
//        Client client = new Client(serverAddress, serverPort);
//    }


}

