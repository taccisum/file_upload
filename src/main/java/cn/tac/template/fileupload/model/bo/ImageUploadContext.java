package cn.tac.template.fileupload.model.bo;

import cn.tac.template.fileupload.domain.image.ImageManagerConfig;
import cn.tac.template.fileupload.domain.image.ImageManagerConfigFactory;
import cn.tac.template.fileupload.domain.image.ImageValidatorChain;
import cn.tac.template.fileupload.domain.image.ImageWrapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public class ImageUploadContext implements ImageManagerConfig, ImageUploadArguments, ImageHandlingResult, ImageStoringInfo, ImageStoringResult {
    private BufferedImage image;
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private String name;
    private String format;
    private String bizType;

    private ImageWrapper imageWrapper;

    private String id;
    private String storingName;
    private List<String> sizes;

    private MultipartHttpServletRequest multipartHttpServletRequest;


    @Override
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFormat() {
        if (format == null || format.trim().length() == 0) {
            return name.substring(name.lastIndexOf("."), name.length());
        }
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    @Override
    public ImageWrapper getImageWrapper() {
        return imageWrapper;
    }

    public void setImageWrapper(ImageWrapper imageWrapper) {
        this.imageWrapper = imageWrapper;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getStoringName() {
        return storingName;
    }

    public void setStoringName(String storingName) {
        this.storingName = storingName;
    }

    @Override
    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public MultipartHttpServletRequest getMultipartHttpServletRequest() {
        return multipartHttpServletRequest;
    }

    public void setMultipartHttpServletRequest(MultipartHttpServletRequest multipartHttpServletRequest) {
        this.multipartHttpServletRequest = multipartHttpServletRequest;
    }

    @Override
    public ImageValidatorChain getValidatorChain() {
        return getConfig().getValidatorChain();
    }

    @Override
    public List<ImageStoringSize> getImageStoringSize() {
        return getConfig().getImageStoringSize();
    }

    @Override
    public Watermark getWatermark() {
        return getConfig().getWatermark();
    }

    @Override
    public String getLocation() {
        return getConfig().getLocation();
    }

    @Override
    public List<ImageStoringSize> getStoringSize() {
        return getConfig().getImageStoringSize();
    }

    public void fillImageHandlingResult(ImageHandlingResult result) {
        this.imageWrapper = result.getImageWrapper();
    }

    private ImageManagerConfig getConfig() {
        return ImageManagerConfigFactory.get(bizType);
    }

    public void fillImageStoringResult(ImageStoringResult store) {
        this.id = store.getId();
        this.storingName = store.getStoringName();
        this.sizes = store.getSizes();
    }
}
