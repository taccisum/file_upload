package cn.tac.template.fileupload.domain.image.validator;

import cn.tac.template.fileupload.domain.image.ImageValidator;
import cn.tac.template.fileupload.exception.ImageValidatingException;
import cn.tac.template.fileupload.model.bo.ImageHandlingResult;
import cn.tac.template.fileupload.model.bo.ImageUploadArguments;

/**
 * @author tac
 * @since 29/09/2017
 */
public class CommonImageValidator implements ImageValidator {

    @Override
    public void interceptBeforeHandling(ImageUploadArguments arguments) throws ImageValidatingException {
        if (invalidArgs(arguments)) {
            throw new ImageValidatingException("非法参数");
        }
        if (outOfSize(arguments)) {
            throw new ImageValidatingException("裁剪范围超出尺寸");
        }
    }

    private boolean invalidArgs(ImageUploadArguments arguments) {
        return (arguments.getX() != null && arguments.getX() < 0) ||
                (arguments.getY() != null && arguments.getY() < 0) ||
                arguments.getX() >= arguments.getImage().getWidth() ||
                arguments.getY() >= arguments.getImage().getHeight();
    }

    private boolean outOfSize(ImageUploadArguments arguments) {
        return (arguments.getX() + arguments.getWidth()) > arguments.getImage().getWidth() ||
                (arguments.getY() + arguments.getHeight() > arguments.getImage().getHeight());
    }

    @Override
    public void interceptAfterHandling(ImageHandlingResult result) throws ImageValidatingException {

    }
}
