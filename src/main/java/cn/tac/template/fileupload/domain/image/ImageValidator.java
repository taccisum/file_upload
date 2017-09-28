package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.domain.Validator;
import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageInfo;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageValidator extends Validator {
    void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException;
    void interceptAfterHandling(ImageInfo info) throws ImageValidatingException;
}
