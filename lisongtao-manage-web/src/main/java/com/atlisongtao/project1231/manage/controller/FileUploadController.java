package com.atlisongtao.project1231.manage.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @RequestMapping(value = "fileUpload", method = RequestMethod.POST)
    public String fileUpload(@RequestParam("file") MultipartFile[] files) {
        if (files.length != 0) {
            System.out.println("multipartFile=" + files[0].getName() + "|" + files[0].getSize());
        }
        return "";
    }
}
