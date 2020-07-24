package org.zuo.ftpapi.dao.ftpRecord;

import org.zuo.ftpapi.dao.config.BaseRepository;

public interface FtpRecordRepository extends BaseRepository<FtpRecordEntity> {
    //基于jpa的数据库方法，将注入到FtpRecordSpringDao中，以实现FtpSpringDao中的方法。
}
