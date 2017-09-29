package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;
import cn.tac.template.fileupload.model.bo.ImageUploadContext;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageValidator implements ImageValidator {

    @Override
    public void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException {
        for (ImageValidator filter : ((ImageUploadContext) arguments).getValidatorChain()) {
            filter.interceptBeforeHandling(arguments);
        }
    }

    @Override
    public void interceptAfterHandling(ImageHandlingResult imageHandlingResult) throws ImageValidatingException {
        for (ImageValidator filter : ((ImageUploadContext) imageHandlingResult).getValidatorChain()) {
            filter.interceptAfterHandling(imageHandlingResult);
        }
    }
}
