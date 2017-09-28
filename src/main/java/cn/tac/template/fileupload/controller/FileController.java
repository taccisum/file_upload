package cn.tac.template.fileupload.controller;

import cn.tac.template.fileupload.model.bo.ImageUploadResult;
import cn.tac.template.fileupload.model.dto.ImageUploadDto;
import cn.tac.template.fileupload.util.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author tac
 * @since 28/09/2017
 */

@RestController
@RequestMapping(FileController.PATH)
public class FileController {
    public static final String PATH = "file";

    @RequestMapping("/image/upload")
    public void imageUpload(ImageUploadDto dto, MultipartHttpServletRequest request){
        ImageUploadResult result = FileUtils.upload(FileUtils.convert(dto, request));
    }

}
