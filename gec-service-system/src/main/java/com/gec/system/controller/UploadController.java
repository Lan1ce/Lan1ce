package com.gec.system.controller;

import com.gec.system.common.Result;
import com.gec.system.util.OssTemplate;
import com.gec.system.util.VodTemplate;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping("/admin/system/upload")
@RestController
@Api(tags = "上传控制器")
@CrossOrigin
public class UploadController {


    @Autowired
    private OssTemplate ossTemplate;

    @Autowired
    private VodTemplate vodTemplate;

    // uploadImage
    @PostMapping("/uploadImage")
    public Result uploadImage(MultipartFile uploadImage) throws IOException {


        String imagePath = this.ossTemplate.upload(uploadImage.getOriginalFilename(), uploadImage.getInputStream());
        System.out.println(imagePath);
        return Result.ok(imagePath);
    }

    @RequestMapping(value = "/uploadVideo")
    public Result uploadVideo(MultipartFile uploadVideo) throws IOException {
        String videoId = this.vodTemplate.uploadVideo(uploadVideo.getOriginalFilename(), uploadVideo.getInputStream());
        System.out.println(videoId);
        return Result.ok(videoId);
    }
}
