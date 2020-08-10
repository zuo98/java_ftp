package org.zuo.ftpapi.dao.ftpRecord;


import lombok.Data;
import org.zuo.ftpapi.dao.config.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "ftp_form_record")
public class FtpRecordEntity extends AbstractEntity {

    @Column(name = "dataId", length = 64, nullable = false)
    private String dataId;

    @Column(name = "fileName", length = 64, nullable = false)
    private String fileName;

    @Column(name = "storeFileName", length = 64, nullable = false)
    private String storeFileName;

    @Column(name = "description", length = 64, nullable = false)
    private String description;

    @Column(name = "downloadCount", nullable = false)
    private int downloadCount;

    @Column(name = "createTime", length = 64, nullable = false)
    private Date createTime;

}
