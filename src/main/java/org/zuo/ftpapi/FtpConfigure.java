package org.zuo.ftpapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zuo.ftpapi.service.ftpService.FtpClientResolve;

@Configuration
public class FtpConfigure {
    @Value("${ftp.url}")
    public String url;
    @Value("${ftp.port}")
    public int port;
    @Value("${ftp.username}")
    public String username;
    @Value("${ftp.password}")
    public String password;

    @Bean
    public FtpClientResolve getClient() {
        try {
            FtpClientResolve resolve = new FtpClientResolve(url, port, username, password);
            resolve.connect();
            return resolve;
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }


}
