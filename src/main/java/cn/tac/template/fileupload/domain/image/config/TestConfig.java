package cn.tac.template.fileupload.domain.image.config;

import cn.tac.template.fileupload.domain.image.ImageManagerConfig;
import cn.tac.template.fileupload.domain.image.ImageValidatorChain;
import cn.tac.template.fileupload.model.bo.ImageStoringSize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class TestConfig implements ImageManagerConfig {
    @Override
    public ImageValidatorChain getValidatorChain() {
        return new ImageValidatorChain();
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public List<ImageStoringSize> getImageStoringSize() {
        List<ImageStoringSize> ls = new ArrayList<>();
        ls.add(new ImageStoringSize(100, 100));
        ls.add(new ImageStoringSize(300, 300));
        ls.add(new ImageStoringSize(500, 500));
        return ls;
    }
}
