package org.zuo.ftpapi.service.ftpService;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;

public class FtpClientResolve extends FTPClient{

    private String url;
    private int port;
    private String userName;
    private String passWord;

    public FtpClientResolve(String url, int port, String userName, String passWord) {
        this.url = url;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;
    }

    public void connect(){
        try{
            this.connect(this.url,this.port);
            this.login(this.userName,this.passWord);
            this.setConnectTimeout(50000);
            this.setControlEncoding("UTF-8");
            this.enterLocalPassiveMode();
            this.setFileType(FTPClient.BINARY_FILE_TYPE);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }

    public void close(){
        try{
            if(this.isConnected()){
                this.disconnect();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
