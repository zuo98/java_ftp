package org.zuo.ftpapi.service.ftpService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.contract.ftpContract.IFtpHandler;
import org.zuo.ftpapi.contract.ftpContract.IFtpRecordService;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordDao;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordEntity;
import org.zuo.ftpapi.service.SimpleCatalogService;

@Service
public class SimpleFtpRecordService extends SimpleCatalogService<FtpRecordDescriptor, FtpRecordEntity>
        implements IFtpRecordService {

    private final IFtpHandler ftpHandler;
    private final FtpRecordDao dao;
    private final FtpRecordMapper mapper;

    public SimpleFtpRecordService(FtpRecordDao dao, FtpRecordMapper mapper, IFtpHandler ftpHandler) {
        super(dao, mapper);
        this.ftpHandler = ftpHandler;
        this.dao = dao;
        this.mapper = mapper;
    }




}
