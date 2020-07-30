package org.zuo.ftpapi.service.ftpService;

import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordEntity;
import org.zuo.ftpapi.service.catalogService.CatalogMapper;

public interface FtpRecordMapper extends CatalogMapper<FtpRecordDescriptor, FtpRecordEntity> {
}
