package cn.tac.template.fileupload.model.bo;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageStoringSize {
    public ImageStoringSize(String name, Integer width, Integer height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    private Integer width;
    private Integer height;
    private String name;

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
}
