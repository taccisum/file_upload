package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.exception.ImageUploadException;
import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.*;

import java.util.List;

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

        ImageHandlingResult result = handle(context);

        try {
            interceptAfterHandling(extractInfo(result));
        } catch (ImageValidatingException e) {
            throw new ImageUploadException(e);
        }

        store(buildStoringInfos(result));

        return null;
    }

    private List<FileStoringInfo> buildStoringInfos(ImageHandlingResult result) {
        //todo::
        return null;
    }

    private ImageInfo extractInfo(ImageHandlingResult result) {
        //todo::
        return null;
    }

}
