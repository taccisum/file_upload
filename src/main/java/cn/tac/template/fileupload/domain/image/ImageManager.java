package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.domain.FileManager;
import cn.tac.template.fileupload.model.bo.ImageUploadContext;
import cn.tac.template.fileupload.model.dto.ImageUploadResult;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class ImageManager implements FileManager {
    public abstract ImageUploadResult upload(ImageUploadContext context);
}
