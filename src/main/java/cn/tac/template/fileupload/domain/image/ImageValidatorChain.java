package cn.tac.template.fileupload.domain.image;

import java.util.ArrayList;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageValidatorChain extends ArrayList<ImageValidator> {

    public ImageValidatorChain() {
        //todo:: 添加默认的校验器
    }
}
