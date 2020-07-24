package org.zuo.ftpapi.contract.ftpContract;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import org.zuo.ftpapi.contract.Catalog;

import java.util.Date;

@Data
public class FtpRecordDescriptor extends Catalog {

    private String dataId;
    private String fileName;
    private String filePath;
    private Date createTime;
    private Date updateTime;
}
