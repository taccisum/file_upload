package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class ImageHandlingManager extends ImageFilteringManager implements ImageHandler, ImageHandlerAware {
    private ImageHandler handler;

    @Override
    public void setImageHandler(ImageHandler handler) {
        this.handler = handler;
    }

    @Override
    public ImageHandlingResult handle(ImageUploadArguments arguments) {
        return handler.handle(arguments);
    }
}
