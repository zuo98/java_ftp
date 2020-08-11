package org.zuo.ftpapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.FtpRecordDescriptor;
import org.zuo.ftpapi.contract.ftpContract.IFtpRecordService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(path = "/ftp/v1")
public class FTPController {


    private final IFtpRecordService service;

    @Autowired
    public FTPController(IFtpRecordService service) {
        this.service = service;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String upload(@RequestPart(name = "file") MultipartFile file,
                         @RequestPart(name = "description") String description) throws Throwable {
        if (this.service.upload(file, description)) {
            return "yes";
        } else {
            return "no";
        }


    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public String download(@RequestParam(name = "id") String id, HttpServletResponse response) {
        if (this.service.download(response, id)) {
            return "yes";

        } else {
            return "no";
        }


    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String delete(@RequestParam(name = "id") String id) {
        try {
            this.service.delete(id);
            return "ok";
        } catch (Throwable e) {
            e.printStackTrace();
            return "no";
        }


    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<FtpRecordDescriptor> list() throws Throwable {
        List<FtpRecordDescriptor> descs = this.service.list();
        return descs;
    }

}
