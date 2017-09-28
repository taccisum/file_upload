package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageInfo;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class ImageFilteringManager extends ImageStoringManager implements ImageValidator, ImageFilterAware {
    private ImageValidator validator;


    @Override
    public void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException {
        validator.interceptBeforeHandling(arguments);
    }

    @Override
    public void interceptAfterHandling(ImageInfo info) throws ImageValidatingException {
        validator.interceptAfterHandling(info);
    }

    @Override
    public void setImageFilter(ImageValidator filter) {
        this.validator = filter;
    }
}
