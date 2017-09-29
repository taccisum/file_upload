package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;
import cn.tac.template.fileupload.model.bo.Watermark;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageHandler implements ImageHandler {
    private ImageWrapper wrap(BufferedImage image) {
        return new ImageWrapper(image);
    }

    @Override
    public ImageHandlingResult handle(ImageUploadArguments arguments) {
        return () -> doHandle(wrap(arguments.getImage()), arguments, (ImageManagerConfig) arguments);
    }

    private ImageWrapper doHandle(ImageWrapper wrapper, ImageUploadArguments arguments, ImageManagerConfig config) {
        wrapper.crop(
                defaultIfNull(arguments.getX(), 0),
                defaultIfNull(arguments.getY(), 0),
                defaultIfNull(arguments.getWidth(), arguments.getImage().getWidth()),
                defaultIfNull(arguments.getHeight(), arguments.getImage().getHeight()));

        Watermark waterMark = config.getWatermark();
        if (waterMark != null) {
            try {
                wrapper.watermark(waterMark.getImage(), waterMark.getOpacity());
            } catch (IOException e) {
                //todo::
                throw new RuntimeException(e);
            }
        }
        if (arguments.getFormat() != null && arguments.getFormat().trim().length() > 0) {
            wrapper.format(config.getFormat());
        }
        return wrapper;
    }

    private Integer defaultIfNull(Integer integer, Integer def) {
        return integer == null ? def : integer;
    }
}
