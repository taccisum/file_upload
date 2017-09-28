package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageStoringSize;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageHandler implements ImageHandler {

    protected ImageWrapper wrap(BufferedImage image){
        return new ImageWrapper(image);
    }

    @Override
    public ImageHandlingResult handle(ImageUploadArguments arguments) {
        ImageManagerConfig config = mapConfig(arguments);
        ImageWrapper wrapper = wrap(arguments.getImage())
               .crop(arguments.getX(), arguments.getY(), arguments.getWidth(), arguments.getHeight())
//               .watermark()
                .format(config.getFormat());
        List<BufferedImage> images = new ArrayList<>();
        List<ImageStoringSize> storingSizes = config.getImageStoringSize();
        for (ImageStoringSize size : storingSizes){
            images.add(wrapper.clone().zoom(size.getWidth(), size.getHeight(), false).getImage());
        }

        return new ImageHandlingResult(images);
    }

    private ImageManagerConfig mapConfig(ImageUploadArguments arguments) {
        return ImageManagerConfigFactory.get(arguments.getBizType());
    }
}
