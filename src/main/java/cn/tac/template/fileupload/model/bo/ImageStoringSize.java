package cn.tac.template.fileupload.model.bo;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageStoringSize {
    public ImageStoringSize(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    private Integer width;
    private Integer height;

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
}
