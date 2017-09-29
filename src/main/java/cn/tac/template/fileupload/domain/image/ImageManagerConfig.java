package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageStoringSize;
import cn.tac.template.fileupload.model.bo.Watermark;

import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageManagerConfig {
    ImageValidatorChain getValidatorChain();

    String getFormat();

    List<ImageStoringSize> getImageStoringSize();

    Watermark getWatermark();

    String getLocation();
}
