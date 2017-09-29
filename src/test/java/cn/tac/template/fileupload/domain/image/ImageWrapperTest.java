package cn.tac.template.fileupload.domain.image;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;

/**
 * @author tac
 * @since 29/09/2017
 */
public class ImageWrapperTest {
    @Test
    public void cloneTest() throws Exception {
        ImageWrapper wrapper = new ImageWrapper(ImageIO.read(this.getClass().getResource("/assets/Avatar.jpg")));
        ImageWrapper clone = wrapper.clone();
        Assert.assertNotEquals(wrapper.render(), wrapper.render());
        Assert.assertNotNull(clone);
        Assert.assertNotEquals(wrapper, clone);
        Assert.assertNotEquals(wrapper.render(), clone.render());
    }

}