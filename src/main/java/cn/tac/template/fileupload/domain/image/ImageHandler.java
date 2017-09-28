package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.domain.Handler;
import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageHandler extends Handler {
    ImageHandlingResult handle(ImageUploadArguments arguments);
}
