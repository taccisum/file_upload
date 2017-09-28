package cn.tac.template.fileupload.model.bo;

import java.awt.image.BufferedImage;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageUploadArguments {
    private BufferedImage image;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private String name;
    private String format;
    private String bizType;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String ext) {
        this.format = ext;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
