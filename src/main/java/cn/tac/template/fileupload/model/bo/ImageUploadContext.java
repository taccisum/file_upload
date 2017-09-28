package cn.tac.template.fileupload.model.bo;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageUploadContext extends ImageUploadArguments {
    private MultipartHttpServletRequest multipartHttpServletRequest;

    public MultipartHttpServletRequest getMultipartHttpServletRequest() {
        return multipartHttpServletRequest;
    }

    public void setMultipartHttpServletRequest(MultipartHttpServletRequest multipartHttpServletRequest) {
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }
}
