package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.FileStoringInfo;

import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public abstract class ImageStoringManager extends ImageManager implements ImageStorage, ImageStorageAware, ImageRecorder, ImageRecorderAware {
    private ImageStorage storage;
    private ImageRecorder recorder;

    @Override
    public int store(List<FileStoringInfo> infos) {
        return 0;
    }

    @Override
    public void setImageStorage(ImageStorage storage) {
        this.storage = storage;
    }

    @Override
    public void setImageRecorder(ImageRecorder recorder) {
        this.recorder = recorder;
    }
}
