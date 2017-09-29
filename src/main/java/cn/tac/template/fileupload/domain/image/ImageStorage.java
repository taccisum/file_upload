package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.domain.Storage;
import cn.tac.template.fileupload.model.bo.ImageStoringInfo;
import cn.tac.template.fileupload.model.bo.ImageStoringResult;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageStorage extends Storage {
    ImageStoringResult store(ImageStoringInfo info);
}
