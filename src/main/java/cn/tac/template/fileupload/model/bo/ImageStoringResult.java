package cn.tac.template.fileupload.model.bo;

import java.util.List;

/**
 * @author tac
 * @since 29/09/2017
 */
public interface ImageStoringResult {
    String getId();
    String getStoringName();
    List<String> getSizes();
}
