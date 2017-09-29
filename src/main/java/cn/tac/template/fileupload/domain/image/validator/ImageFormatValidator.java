package cn.tac.template.fileupload.domain.image.validator;

import cn.tac.template.fileupload.domain.image.ImageValidator;
import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tac
 * @since 29/09/2017
 */
public class ImageFormatValidator implements ImageValidator {
    private static Set<String> supportFormats = new HashSet<>();

    public ImageFormatValidator(String... formats) {
        for (String format : formats) {
            if (format == null) {
                continue;
            }
            supportFormats.add(format.trim());
        }
    }

    @Override
    public void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException {
        String ext = extractExt(arguments.getName()).trim();
        if (!supportFormats.contains(ext)) {
            throw new ImageValidatingException("目前不支持上传\"" + ext + "\"格式的图片");
        }
    }

    @Override
    public void interceptAfterHandling(ImageHandlingResult result) throws ImageValidatingException {

    }

    protected String extractExt(String name) {
        return name.substring(name.lastIndexOf("."), name.length());
    }
}
