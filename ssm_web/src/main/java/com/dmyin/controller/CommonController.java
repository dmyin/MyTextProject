package com.dmyin.controller;


import com.dmyin.entity.Result;
import com.dmyin.utils.UploadUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("common")
public class CommonController {
    @RequestMapping("uploadFile")
    public Result uploadFile(MultipartFile upload, HttpServletRequest request) throws IOException {

        try {
            String imgUrl = "img/upload" + UploadUtils.getDir();
            //创建储存文件的文件夹
            String realPath = request.getSession().getServletContext().getRealPath(imgUrl);
            File file = new File(realPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            //创建文件名
            String filename = upload.getOriginalFilename();
            String uuidName = UploadUtils.getUUIDName(filename);

            //文件进行储存
            upload.transferTo(new File(file,uuidName));

            //获取服务器储存文件的路径
            imgUrl += "/" + uuidName;
            System.out.println(imgUrl);
            return new Result(true, "文件上传成功", imgUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "文件上传失败");
        }
    }
}
