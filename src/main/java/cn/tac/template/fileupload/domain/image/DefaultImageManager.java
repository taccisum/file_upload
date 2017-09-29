package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.exception.ImageUploadException;
import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageStoringResult;
import cn.tac.template.fileupload.model.bo.ImageUploadContext;
import cn.tac.template.fileupload.model.dto.ImageUploadResult;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageManager extends ImageHandlingManager {
    @Override
    public ImageUploadResult upload(ImageUploadContext context) {
        try {
            interceptBeforeHandling(context);
        } catch (ImageValidatingException e) {
            throw new ImageUploadException(e);
        }

        context.fillImageHandlingResult(handle(context));

        try {
            interceptAfterHandling(context);
        } catch (ImageValidatingException e) {
            throw new ImageUploadException(e);
        }

        context.fillImageStoringResult(store(context));

        return buildResult(context);
    }

    private ImageUploadResult buildResult(ImageUploadContext context) {
        ImageStoringResult storingResult = context;
        ImageUploadResult result = new ImageUploadResult();

        result.setId(storingResult.getId());
        result.setName(storingResult.getStoringName());
        result.setSizes(storingResult.getSizes());
        return result;
    }
}
