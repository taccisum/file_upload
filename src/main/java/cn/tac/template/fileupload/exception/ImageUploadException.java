package cn.tac.template.fileupload.exception;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageUploadException extends RuntimeException {
    public ImageUploadException(Throwable cause) {
        super(cause.getMessage(), cause);
    }
}
