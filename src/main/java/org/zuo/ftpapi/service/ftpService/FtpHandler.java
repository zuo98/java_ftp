package org.zuo.ftpapi.service.ftpService;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.IFtpHandler;

import java.io.OutputStream;

public class FtpHandler implements IFtpHandler {

    private final FtpClientResolve client;

    @Autowired
    public FtpHandler(FtpClientResolve client) {
        this.client = client;
    }


    @Override
    public boolean upload(MultipartFile file, String fileName) {
        try {
            this.client.connect();
            int reply = this.client.getReply();
            if(!FTPReply.isPositiveCompletion(reply)){
                this.client.disconnect();
            }
            this.client.setFileType(FTPClient.BINARY_FILE_TYPE);
            return this.client.storeFile(fileName,file.getInputStream());
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

            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        } finally {
            this.client.close();
        }

    }

    @Override
    public boolean delete(String fileName){
        try{
            return this.client.deleteFile(fileName);
        }catch (Throwable e){
            e.printStackTrace();
            return false;
        }
    }


}
