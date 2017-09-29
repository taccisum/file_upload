package cn.tac.template.fileupload.model.dto;

import java.util.List;

/**
 * @author tac
 * @since 29/09/2017
 */
public class ImageUploadResult {
    private String id;
    private String name;
    private List<String> sizes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }
}
