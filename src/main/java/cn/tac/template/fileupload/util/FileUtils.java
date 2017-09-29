package cn.tac.template.fileupload.util;

import cn.tac.template.fileupload.domain.image.ImageManager;
import cn.tac.template.fileupload.exception.EmptyFileException;
import cn.tac.template.fileupload.exception.NoAnyFileException;
import cn.tac.template.fileupload.model.bo.ImageUploadContext;
import cn.tac.template.fileupload.model.dto.ImageUploadDto;
import cn.tac.template.fileupload.model.dto.ImageUploadResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class FileUtils {
    private static ImageManager imageManager;


    public static ImageUploadResult upload(ImageUploadContext context) {
        verify();
        return imageManager.upload(context);
    }

    public static ImageUploadContext convert(ImageUploadDto dto, MultipartHttpServletRequest request) {
        ImageUploadContext context = new ImageUploadContext();
        MultipartFile file = getImageFile(request);

        context.setMultipartHttpServletRequest(request);

        try {
            context.setImage(ImageIO.read(file.getInputStream()));
        } catch (IOException e) {
            //todo::
            throw new RuntimeException(e);
        }
        context.setBizType(dto.getBizType());
        context.setX(dto.getX());
        context.setY(dto.getY());
        context.setWidth(dto.getWidth());
        context.setHeight(dto.getHeight());
        context.setName(file.getOriginalFilename());
        context.setFormat(dto.getFormat());
        return context;
    }

    public static void setImageManager(ImageManager imageManager) {
        FileUtils.imageManager = imageManager;
    }

    public static void verify(){
        if(imageManager == null){
            //todo::
            throw new RuntimeException("you must init imageManager before you user it");
        }
    }

    private static MultipartFile getImageFile(MultipartHttpServletRequest request) {
        MultipartFile file;

        Iterator<String> names = request.getFileNames();
        if (names.hasNext()) {
            //一次只能上传一张图片
            file = request.getFile(names.next());
        } else {
            throw new NoAnyFileException();
        }

        if(file.isEmpty()){
            throw new EmptyFileException();
        }

        return file;
    }
}
