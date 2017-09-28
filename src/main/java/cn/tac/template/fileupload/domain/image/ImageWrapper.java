package cn.tac.template.fileupload.domain.image;

import java.awt.image.BufferedImage;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageWrapper implements Cloneable {
    private BufferedImage image;

    public ImageWrapper(BufferedImage image) {
        this.image = image;
    }

    public ImageWrapper zoom(int width, int height, boolean keepRatio) {
        return null;
    }

    public ImageWrapper zoom(float scale, boolean keepRatio) {
        return null;
    }

    public ImageWrapper rotate(int angle, boolean keepRatio) {
        return null;
    }

    public ImageWrapper crop(int x, int y, int width, int height) {
        return null;
    }

    public ImageWrapper watermark() {
        return null;
    }

    public ImageWrapper format(String format) {
        return null;
    }

    @Override
    protected ImageWrapper clone(){
        //todo::
        return null;
    }

    public BufferedImage getImage() {
        return image;
    }
}
