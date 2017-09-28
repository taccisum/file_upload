package cn.tac.template.fileupload.config;

import cn.tac.template.fileupload.domain.image.*;
import cn.tac.template.fileupload.domain.image.config.TestConfig;
import cn.tac.template.fileupload.util.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tac
 * @since 28/09/2017
 */
@Configuration
public class ImageManagerConfiguration {
    static {
        ImageManagerConfigFactory.put("test", new TestConfig());
    }

    @Bean
    public ImageManager imageManager(ImageValidator filter, ImageStorage storage, ImageRecorder recorder, ImageHandler handler){
        DefaultImageManager bean = new DefaultImageManager();
        bean.setImageFilter(filter);
        bean.setImageStorage(storage);
        bean.setImageRecorder(recorder);
        bean.setImageHandler(handler);
        FileUtils.setImageManager(bean);
        return bean;
    }

    @Bean
    public ImageValidator imageFilter(){
        ImageValidator bean = new DefaultImageValidator();
        return bean;
    }

    @Bean
    public ImageStorage imageStorage(){
        ImageStorage bean = new DefaultImageStorage();
        return bean;
    }

    @Bean
    public ImageRecorder imageRecorder(){
        ImageRecorder bean = new DefaultImageRecorder();
        return bean;
    }

    @Bean
    public ImageHandler imageHandler(){
        ImageHandler bean = new DefaultImageHandler();
        return bean;

    }
}
