package org.zuo.ftpapi.dao.ftpRecord;

import org.zuo.ftpapi.dao.config.BaseRepository;

import java.util.List;

public interface FtpRecordRepository extends BaseRepository<FtpRecordEntity> {
    //基于jpa的数据库方法，将注入到FtpRecordSpringDao中，以实现FtpSpringDao中的方法。
    FtpRecordEntity findByDataId(String dataId);

    List<FtpRecordEntity> findAll();


}
