package cn.tac.template.fileupload.domain.image.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author tac
 * @since 29/09/2017
 */
public class ImageFormatValidatorTest {
    @Test
    public void extractExt() throws Exception {
        ImageFormatValidator validator = new ImageFormatValidator();
        Assert.assertEquals(".jpg", validator.extractExt("boqfq.biw.jpg"));
    }
}