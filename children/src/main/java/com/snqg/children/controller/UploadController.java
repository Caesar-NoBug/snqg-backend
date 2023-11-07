package com.snqg.children.controller;

import cn.hutool.core.io.FileUtil;
import com.snqg.common.exception.ThrowUtil;
import com.snqg.domain.enums.ErrorCode;
import com.snqg.domain.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

//图片上传
@Slf4j
@RestController
@Api(tags = "文件上传，获取")
public class UploadController {

    @Resource
    private ResourceLoader resourceLoader;

    private static final String uploadPath = Paths.get(System.getProperty("user.dir"), "file").toString();

    public static final String FILE_FORMAT = "file-%s%s";

    static {
        FileUtil.mkdir(uploadPath);
    }

    //上传图片
    @ApiOperation(value = "上传文件(响应结果为该文件的文件名)")
    @PostMapping("/upload")
    public Response<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            Response.error("上传失败：请选择要上传的图片");
        }

        try {
            String oldFilename = file.getOriginalFilename();

            ThrowUtil.throwIfNull(oldFilename, "上传失败：上传图片名不能为空");

            // 获取文件名
            String fileSuffix = oldFilename.substring(oldFilename.lastIndexOf("."));

            //构建新的文件名
            String filename = String.format(FILE_FORMAT, UUID.randomUUID(), fileSuffix);

            // 构建文件存储路径
            String filePath = Paths.get(uploadPath, filename).toString();

            // 将文件保存到指定路径
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

            return Response.ok(filename, "上传成功");

        } catch (IOException e) {

            log.error(e.toString());
            return new Response<>(ErrorCode.SYSTEM_ERROR.getCode(), null, "上传文件失败：系统内部错误");

        }

    }

    @ApiOperation(value = "获取文件")
    @GetMapping("/file/{filename}")
    public org.springframework.core.io.Resource getImage(@PathVariable String filename) throws IOException {
        org.springframework.core.io.Resource resource = resourceLoader.getResource("file:" + Paths.get(uploadPath, filename).toString());
        System.out.println("uploadPath: " + uploadPath);
        log.error(resource.getFile().getAbsolutePath());
        if (resource.exists()) {
            return resource;
        } else {
            // 处理文件不存在的情况
            System.out.println("uploadPath: " + uploadPath);
            log.error(resource.getFile().getAbsolutePath());
            throw new IOException("找不到该文件");
        }
    }
}
