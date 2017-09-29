package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.domain.image.validator.CommonImageValidator;

import java.util.ArrayList;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageValidatorChain extends ArrayList<ImageValidator> {

    public ImageValidatorChain() {
        this(true);
    }

    public ImageValidatorChain(boolean def) {
        if(def){
            //todo:: 添加默认的校验器
            add(new CommonImageValidator());
        }
    }
}
