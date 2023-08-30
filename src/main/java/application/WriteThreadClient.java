package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class  WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    String name;
    public String s;
    BufferedWriter BW2;



    public WriteThreadClient(NetworkUtil networkUtil, String name) throws IOException {
        this.networkUtil = networkUtil;
        this.name = name;
        BW2 = new BufferedWriter(new FileWriter("SMSWrite.txt"));
        this.thr = new Thread(this);
        thr.start();
    }

    public WriteThreadClient() {
        System.out.println("ok");
    }


    public void run() {



        try {
            Scanner input = new Scanner(System.in);
            while (true) {



                String s = input.nextLine();

                networkUtil.write(name + ":" + s);

                String data = name + ":" + s;



                if (BW2 != null) {
                    BW2.close();
                }

                BW2 = new BufferedWriter(new FileWriter("SMSWrite.txt"));

                try {
                    BW2.write(s);
                    BW2.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {

                if (BW2 != null) {
                    BW2.close();
                }
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    void informationpass(String msg){
        s=msg;
    }

}



