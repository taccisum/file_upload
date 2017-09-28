package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageInfo;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageValidator implements ImageValidator {

    @Override
    public void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException {
        for (ImageValidator filter : getValidatorChain(arguments.getBizType())) {
            filter.interceptBeforeHandling(arguments);
        }
    }

    @Override
    public void interceptAfterHandling(ImageInfo info) throws ImageValidatingException {
        for (ImageValidator filter : getValidatorChain(info.getBizType())) {
            filter.interceptAfterHandling(info);
        }
    }

    private ImageValidatorChain getValidatorChain(String type) {
        return ImageManagerConfigFactory.get(type).getValidatorChain();
    }
}
