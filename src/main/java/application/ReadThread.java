package application;




import javafx.application.Platform;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReadThread implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;

    private BufferedWriter BW;




    public ReadThread(NetworkUtil networkUtil) throws IOException {
        this.networkUtil = networkUtil;
        BW = new BufferedWriter(new FileWriter("SMS.txt"));
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                String s = (String) networkUtil.read();



                System.out.println(s);


                if (BW != null) {
                    BW.close();
                }

                BW = new BufferedWriter(new FileWriter("SMS.txt"));

                try {
                    BW.write(s);
                    BW.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {

                if (BW != null) {
                    BW.close();
                }
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}



