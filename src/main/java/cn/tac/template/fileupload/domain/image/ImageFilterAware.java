package cn.tac.template.fileupload.domain.image;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface ImageFilterAware {
    void setImageFilter(ImageValidator filter);
}
