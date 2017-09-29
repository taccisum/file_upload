package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageStoringInfo;
import cn.tac.template.fileupload.model.bo.ImageStoringResult;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class ImageStoringManager extends ImageManager implements ImageStorage, ImageStorageAware {
    private ImageStorage storage;

    @Override
    public ImageStoringResult store(ImageStoringInfo info) {
        return storage.store(info);
    }


    @Override
    public void setImageStorage(ImageStorage storage) {
        this.storage = storage;
    }

}
