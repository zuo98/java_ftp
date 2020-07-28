package org.zuo.ftpapi;


import org.apache.commons.net.io.CopyStreamAdapter;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.zuo.ftpapi.service.ftpService.FtpClientResolve;
import org.zuo.ftpapi.service.ftpService.WebSocket;

import java.io.*;



@SpringBootApplication
public class FtpapiApplication {
    @Autowired
    private WebSocket websocket;

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }


    public static void main(String[] args) {

        String url = "114.215.145.37";
        int port = 21;
        String userName = "zuoliping";
        String passWord = "zuoliping";
        String path = "F:\\ThinkPad E530.pdf";

        FtpClientResolve client = new FtpClientResolve(url, port, userName, passWord);



        client.connect();

//        InputStream input = null;
//        try {
//            input = new FileInputStream(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//        try {
//            client.storeFile("think.pdf", input);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        int size;
//        String remote, local;

// do some work to initialize size, remote and local file path
// before saving remoteSource to local
//        OutputStream output = new FileOutputStream(local);
//        CountingOutputStream cos = new CountingOutputStream(output){
//            protected void beforeWrite(int n){
//                super.beforeWrite(n);
//
//                System.err.println("Downloaded "+getCount() + "/" + size);
//            }
//        };
//        ftp.retrieveFile(remote, cos);
//
//        output.close();

        //-----------------------------------------

        try {
//            OutputStream stO =
//                    new BufferedOutputStream(
//                            client.storeFileStream("fod1.pdf"));

//            InputStream stI = new FileInputStream(path);
//            File inputFile = new File(path);

//            copyStream(
//                    stI,
//                    stO,
//                    client.getBufferSize(),
//                    /* I'm using the UNKNOWN_STREAM_SIZE constant here, but you can use the size of file too */
//                    CopyStreamEvent.UNKNOWN_STREAM_SIZE,
////                    inputFile.length(),
//                    new CopyStreamAdapter() {
//                        public void bytesTransferred(long totalBytesTransferred,
//                                                     int bytesTransferred,
//                                                     long streamSize) {
//                            // Your progress Control code here
//
//                            int percent = (int) (totalBytesTransferred * 100 / inputFile.length());
//                            System.out.println(percent + "%");
//                        }
//                    });

            InputStream stI = new FileInputStream(path);
            File inputFile = new File(path);

            CopyStreamListener listener=new CopyStreamListener() {

                private long myfile = inputFile.length();



                @Override
                public void bytesTransferred(CopyStreamEvent copyStreamEvent) {

                }

                @Override
                public void bytesTransferred(long l, int i, long l1) {

                    int percent = (int) (l * 100 / myfile);
                    System.out.println(percent + "%");
                    System.out.println(i);
                    System.out.println(l1);


                }
            };
            client.setCopyStreamListener(listener);
            client.storeFile("test.pdf",stI);
//            client.completePendingCommand();
        } catch (Exception e) {
            e.printStackTrace();
        }
//-----------------------------------------------------

        SpringApplication.run(FtpapiApplication.class, args);
    }

}
