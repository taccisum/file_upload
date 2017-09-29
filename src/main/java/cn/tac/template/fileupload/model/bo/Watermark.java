package cn.tac.template.fileupload.model.bo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author tac
 * @since 29/09/2017
 */
public class Watermark {
    private String url;
    private Float opacity;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Float getOpacity() {
        return opacity;
    }

    public void setOpacity(Float opacity) {
        this.opacity = opacity;
    }

    public BufferedImage getImage() throws IOException {
        File file;
        if(url.startsWith("classpath:")){
            file = new File(this.getClass().getClassLoader().getResource(url.replace("classpath:", "")).getPath());
        }else {
            file = new File(url);
        }
        return ImageIO.read(file);
    }
}
