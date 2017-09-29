package cn.tac.template.fileupload.domain.image.config;

import cn.tac.template.fileupload.domain.image.ImageManagerConfig;
import cn.tac.template.fileupload.domain.image.ImageValidatorChain;
import cn.tac.template.fileupload.domain.image.validator.ImageFormatValidator;
import cn.tac.template.fileupload.model.bo.ImageStoringSize;
import cn.tac.template.fileupload.model.bo.Watermark;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class TestConfig implements ImageManagerConfig {
    @Override
    public ImageValidatorChain getValidatorChain() {
        ImageValidatorChain chain = new ImageValidatorChain();
        chain.add(new ImageFormatValidator(".jpg", ".jpeg", ".png"));
        return chain;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public List<ImageStoringSize> getImageStoringSize() {
        List<ImageStoringSize> ls = new ArrayList<>();
        ls.add(new ImageStoringSize("100x100", 100, 100));
        ls.add(new ImageStoringSize("300x300", 300, 300));
        ls.add(new ImageStoringSize("500x500", 500, 500));
        return ls;
    }

    @Override
    public Watermark getWatermark() {
        return null;
    }

    @Override
    public String getLocation() {
        return "classpath:upload/";
    }
}
