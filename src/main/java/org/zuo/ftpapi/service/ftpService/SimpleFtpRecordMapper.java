package org.zuo.ftpapi.service.ftpService;


import org.springframework.stereotype.Component;
import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordEntity;
import org.zuo.ftpapi.service.catalogService.SimpleCatalogMapper;

@Component
public class SimpleFtpRecordMapper extends SimpleCatalogMapper<FtpRecordDescriptor, FtpRecordEntity>
        implements FtpRecordMapper {

    @Override
    public FtpRecordDescriptor _eTot(FtpRecordEntity entity, boolean lazy) throws Throwable {
        FtpRecordDescriptor desc = new FtpRecordDescriptor();
        desc.setDataId(entity.getDataId());
        desc.setCreateTime(entity.getCreateTime());
        desc.setDescription(entity.getDescription());
        desc.setFileName(entity.getFileName());
        desc.setStoreFileName(entity.getStoreFileName());
        desc.setDownloadCount(entity.getDownloadCount());
        return desc;
    }

    @Override
    public FtpRecordEntity _tToe(FtpRecordDescriptor desc) throws Throwable {
        FtpRecordEntity entity = new FtpRecordEntity();
        entity.setCreateTime(desc.getCreateTime());
        entity.setDataId(desc.getDataId());
        entity.setDescription(desc.getDescription());
        entity.setFileName(desc.getFileName());
        entity.setDownloadCount(desc.getDownloadCount());
        entity.setStoreFileName(desc.getStoreFileName());

        return entity;
    }
}
