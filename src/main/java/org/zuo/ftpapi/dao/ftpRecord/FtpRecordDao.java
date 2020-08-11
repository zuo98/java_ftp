package org.zuo.ftpapi.dao.ftpRecord;

import org.zuo.ftpapi.dao.config.BaseDao;

public interface FtpRecordDao extends BaseDao<FtpRecordEntity> {
    //数据操作方法接口，由FtpRecordSpringDao继承实现。
    FtpRecordEntity findById(String dataId);

    Iterable<FtpRecordEntity> findAll();


}
