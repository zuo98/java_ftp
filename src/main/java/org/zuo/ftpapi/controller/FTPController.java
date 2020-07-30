package org.zuo.ftpapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zuo.ftpapi.contract.ftpContract.IFtpHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


@RestController
public class FTPController {


    private final IFtpHandler ftpHandler;
    @Autowired
    public FTPController(IFtpHandler ftpHandler){
        this.ftpHandler = ftpHandler;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String upload(@RequestPart(name = "file") MultipartFile file)  {
        String fileName = file.getOriginalFilename();
        this.ftpHandler.upload(file,fileName);
        return "ok";

    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public String download(@RequestParam(name = "file") String fileName, HttpServletResponse response){
        try{
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+fileName);
            OutputStream output = response.getOutputStream();
            this.ftpHandler.download(fileName,output);
            return "ok";
        }catch (Throwable e){
            e.printStackTrace();
            return "no";
        }


    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String delete(@RequestParam(name = "file") String fileName, HttpServletResponse response){
        try{
            this.ftpHandler.delete(fileName);
            return "ok";
        }catch (Throwable e){
            e.printStackTrace();
            return "no";
        }


    }





}
