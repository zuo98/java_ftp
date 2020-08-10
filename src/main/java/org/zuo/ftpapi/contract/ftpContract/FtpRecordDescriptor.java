package org.zuo.ftpapi.contract.ftpContract;

import lombok.Data;
import org.zuo.ftpapi.contract.catalogContract.Catalog;

import java.util.Date;

@Data
public class FtpRecordDescriptor extends Catalog {

    private String dataId;
    private String fileName;
    private String storeFileName;
    private String description;
    private int downloadCount;
    private Date createTime;
    
}
