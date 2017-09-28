package cn.tac.template.fileupload.model.bo;

import java.io.File;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageInfo {
    private Integer width;
    private Integer height;
    private List<File> files;
    private String bizType;

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }
}
