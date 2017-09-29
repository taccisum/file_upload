package cn.tac.template.fileupload.domain.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageWrapper implements Cloneable {
    private Thumbnails.Builder<BufferedImage> builder;

    public ImageWrapper(BufferedImage image) {
        this.builder = Thumbnails.of(image);
    }

    public ImageWrapper zoom(int width, int height, boolean keepRatio) {
        builder.size(width,height).keepAspectRatio(keepRatio);
        return this;
    }

    public ImageWrapper zoom(float scale, boolean keepRatio) {
        builder.scale(scale).keepAspectRatio(keepRatio);
        return this;
    }

    public ImageWrapper rotate(double angle) {
        builder.rotate(angle);
        return this;
    }

    public ImageWrapper crop(int x, int y, int width, int height) {
        builder.sourceRegion(x, y, width, height);
        return this;
    }

    public ImageWrapper watermark(BufferedImage image, float opacity) {
        builder.watermark(Positions.BOTTOM_RIGHT, image, opacity);
        return this;
    }

    public ImageWrapper format(String format) {
        return null;
    }

    public ImageWrapper save(String path){
        return save(new File(path));
    }
    public ImageWrapper save(File outFile){
        try {
            builder.toFile(outFile);
        } catch (IOException e) {
            //todo::
            throw new RuntimeException(e);
        }
        return this;
    }

    public BufferedImage render() {
        try {
            try {
                return builder.asBufferedImage();
            } catch (IllegalStateException e) {
                builder.scale(1);
                return builder.asBufferedImage();
            }
        } catch (IOException e) {
            //todo::
            throw new RuntimeException(e);
        }
    }

    @Override
    protected ImageWrapper clone() {
        return new ImageWrapper(render());
    }
}
