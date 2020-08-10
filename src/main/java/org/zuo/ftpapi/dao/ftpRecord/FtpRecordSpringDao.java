package org.zuo.ftpapi.dao.ftpRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.zuo.ftpapi.dao.config.SpringDao;

import java.util.List;

@Component
public class FtpRecordSpringDao extends SpringDao<FtpRecordEntity> implements FtpRecordDao {

    //将FtpRecordRepository注入，重写FtpRecordDao的方法实现。
    private final FtpRecordRepository repository;

    @Autowired
    protected FtpRecordSpringDao(FtpRecordRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public FtpRecordEntity findByDataId(String dataId){
        FtpRecordEntity entity = this.repository.findByDataId(dataId);
        return entity;
    }

    @Override
    public List<FtpRecordEntity> findAll(){
        List<FtpRecordEntity>  entities = this.findAll();
        return entities;
    }





}
