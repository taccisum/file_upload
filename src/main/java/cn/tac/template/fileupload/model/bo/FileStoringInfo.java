package cn.tac.template.fileupload.model.bo;

import java.io.File;

/**
 * @author tac
 * @since 28/09/2017
 */
public class FileStoringInfo {
    private String location;
    private File file;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
