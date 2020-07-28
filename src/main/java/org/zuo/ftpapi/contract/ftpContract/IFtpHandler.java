package org.zuo.ftpapi.contract.ftpContract;

import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;

public interface IFtpHandler {

    boolean upload(MultipartFile file, String fileName);

    boolean download(String fileName , OutputStream out);

    boolean delete(String fileName);

}
