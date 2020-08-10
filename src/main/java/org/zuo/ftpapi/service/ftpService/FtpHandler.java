package org.zuo.ftpapi.service.ftpService;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.IFtpHandler;

import java.io.OutputStream;

@Component
public class FtpHandler implements IFtpHandler {

    private final FtpClientResolve client;
    private final WebSocket webSocket;


    @Autowired
    public FtpHandler(FtpClientResolve client, WebSocket webSocket) {
        this.client = client;
        this.webSocket = webSocket;

    }


    @Override
    public boolean upload(MultipartFile file, String fileName) {
        try {
            this.client.connect();
            int reply = this.client.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                this.client.disconnect();
            }
            this.client.setFileType(FTPClient.BINARY_FILE_TYPE);
            this.client.setCopyStreamListener(this.getListener(file.getSize()));
            return this.client.storeFile(fileName, file.getInputStream());
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            this.client.close();
        }
    }

    @Override
    public boolean download(String fileName, OutputStream out) {
        try {
            this.client.connect();
            this.client.setFileType(FTPClient.BINARY_FILE_TYPE);
            this.client.enterLocalPassiveMode();
            FTPFile[] files = this.client.listFiles(fileName);
            if(files!=null){
                this.client.setCopyStreamListener(this.getListener(files[0].getSize()));
            }
            this.client.retrieveFile(fileName,out);
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            this.client.close();
        }

    }

    @Override
    public boolean delete(String fileName) {
        try {
            return this.client.deleteFile(fileName);
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }


    private CopyStreamListener getListener(long fileSize){
        CopyStreamListener listener = new CopyStreamListener() {

            public int count = 1;
            @Override
            public void bytesTransferred(CopyStreamEvent copyStreamEvent) {

            }

            @Override
            public void bytesTransferred(long l, int i, long l1) {
                if(l==fileSize*count/100){
                    int percent = (int)(l*100/fileSize);
                    System.out.println(percent+"%");
                    webSocket.sendAllMessage(percent+"%");
                    count = count + 1;
                }
            }
        };
        return listener;
    }


}
