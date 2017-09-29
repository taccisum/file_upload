package cn.tac.template.fileupload.model.bo;

import java.awt.image.BufferedImage;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageUploadArguments {
    BufferedImage getImage();
    Integer getX();
    Integer getY();
    Integer getWidth();
    Integer getHeight();
    String getName();
    String getFormat();
    String getBizType();
}
