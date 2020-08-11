package org.zuo.ftpapi.contract.ftpContract;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IFtpRecordService {

    boolean download(HttpServletResponse response, String dataId);

    boolean delete(String dataId);

    boolean upload(MultipartFile file, String description) throws Throwable;

    List<FtpRecordDescriptor> list() throws Throwable;


}
