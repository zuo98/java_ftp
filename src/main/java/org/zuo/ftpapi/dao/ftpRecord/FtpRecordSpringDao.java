package org.zuo.ftpapi.dao.ftpRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zuo.ftpapi.dao.config.SpringDao;

@Component
public class FtpRecordSpringDao extends SpringDao<FtpRecordEntity> implements FtpRecordDao {

    //将FtpRecordRepository注入，重写FtpRecordDao的方法实现。
    private final FtpRecordRepository repository;

    @Autowired
    protected FtpRecordSpringDao(FtpRecordRepository repository) {
        super(repository);
        this.repository = repository;
    }


}
