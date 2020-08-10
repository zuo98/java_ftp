package org.zuo.ftpapi.dao.ftpRecord;

import org.zuo.ftpapi.dao.config.BaseDao;
import java.util.List;

public interface FtpRecordDao extends BaseDao<FtpRecordEntity> {
    //数据操作方法接口，由FtpRecordSpringDao继承实现。
    FtpRecordEntity findByDataId(String dataId);

    List<FtpRecordEntity> findAll();



}
