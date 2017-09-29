package cn.tac.template.fileupload.model.bo;

import cn.tac.template.fileupload.domain.image.ImageWrapper;

import java.util.List;

/**
 * @author tac
 * @since 29/09/2017
 */
public interface ImageStoringInfo {
    String getLocation();
    List<ImageStoringSize> getStoringSize();
    ImageWrapper getImageWrapper();
    String getFormat();
}
