package cn.tac.template.fileupload.model.bo;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageHandlingResult {
    public ImageHandlingResult(List<BufferedImage> images) {
        this.images = images;
    }

    private List<BufferedImage> images;

    public List<BufferedImage> getImages() {
        return images;
    }

    public void setImages(List<BufferedImage> images) {
        this.images = images;
    }
}
