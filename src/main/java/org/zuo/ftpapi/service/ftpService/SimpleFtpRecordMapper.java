package org.zuo.ftpapi.service.ftpService;


import org.springframework.stereotype.Component;
import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordEntity;
import org.zuo.ftpapi.service.catalog.SimpleCatalogMapper;

@Component
public class SimpleFtpRecordMapper extends SimpleCatalogMapper<FtpRecordDescriptor, FtpRecordEntity>
        implements FtpRecordMapper {

    @Override
    public FtpRecordDescriptor _eTot(FtpRecordEntity entity, boolean lazy) throws Throwable {
        FtpRecordDescriptor desc = new FtpRecordDescriptor();


        return desc;
    }

    @Override
    public FtpRecordEntity _tToe(FtpRecordDescriptor desc) throws Throwable {
        FtpRecordEntity entity = new FtpRecordEntity();


        return entity;
    }
}
