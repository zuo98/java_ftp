package org.zuo.ftpapi.service.ftpService;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.contract.ftpContract.IFtpHandler;
import org.zuo.ftpapi.contract.ftpContract.IFtpRecordService;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordDao;
import org.zuo.ftpapi.dao.ftpRecord.FtpRecordEntity;
import org.zuo.ftpapi.service.catalogService.SimpleCatalogService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Override
    public List<FtpRecordDescriptor> getAllRecord() throws Throwable {
        List<FtpRecordDescriptor> descs = null;
        List<FtpRecordEntity> entities = this.dao.findAll();
        for (FtpRecordEntity entity : entities) {
            descs.add(this.mapper.eTot(entity));
        }
        return descs;

    }

    @Override
    public boolean upload(MultipartFile file, String description) throws Throwable {
        String fileName = file.getOriginalFilename();
        String dataId = UUID.randomUUID().toString();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newFileName = dataId + suffix;
        this.ftpHandler.upload(file, newFileName);

        Date date = new Date();
        FtpRecordDescriptor desc = new FtpRecordDescriptor();
        desc.setFileName(fileName);
        desc.setDescription(description);
        desc.setCreateTime(date);
        desc.setDataId(dataId);
        desc.setStoreFileName(newFileName);
        desc.setDownloadCount(0);
        this.dao.save(this.mapper.tToe(desc));
        return true;
    }

    @Override
    public boolean download(HttpServletResponse response, String dataId) {
        FtpRecordEntity entity = this.dao.findByDataId(dataId);
        String fileName = entity.getFileName();
        String storeFileName = entity.getStoreFileName();
        try{
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+fileName);
            OutputStream output = response.getOutputStream();
            this.ftpHandler.download(storeFileName, output);

            entity.setDownloadCount(entity.getDownloadCount()+1);
        }catch (IOException e){
            e.printStackTrace();
        }


        return true;
    }

    @Override
    public boolean delete(String dataId) {

        FtpRecordEntity entity = this.dao.findByDataId(dataId);
        if (entity != null) {
            String fileName = entity.getFileName();
            this.ftpHandler.delete(fileName);
            this.dao.delete(entity.getId());

        }
        return true;

    }


}
