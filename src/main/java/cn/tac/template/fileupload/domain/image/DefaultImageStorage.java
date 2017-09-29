package cn.tac.template.fileupload.domain.image;

import cn.tac.template.fileupload.model.bo.ImageStoringInfo;
import cn.tac.template.fileupload.model.bo.ImageStoringResult;
import cn.tac.template.fileupload.model.bo.ImageStoringSize;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author tac
 * @since 28/09/2017
 */
public class DefaultImageStorage implements ImageStorage, ImageRecorder, ImageRecorderAware {
    private ImageRecorder recorder;

    @Override
    public ImageStoringResult store(ImageStoringInfo info) {
        String location = info.getLocation();
        if (location.startsWith("classpath:")) {
            String classpath = this.getClass().getClassLoader().getResource("").getPath();
            location = classpath + File.separator + location.replace("classpath:", "");
            File folder = new File(location);
            if (!folder.exists()) {
                folder.mkdir();
            }
            if (!folder.isDirectory()) {
                throw new RuntimeException(folder.getPath() + "not a directory");
            }
        }

        String storingName = generateUUID();
        List<String> sizeNames = new ArrayList<>();

        for (ImageStoringSize size : info.getStoringSize()) {
            File outFile = new File(location, storingName + "_" + size.getName() + info.getFormat());
            info.getImageWrapper().clone().zoom(size.getWidth(), size.getHeight(), false).save(outFile);
            sizeNames.add(size.getName());
        }

        return new ImageStoringResult() {
            @Override
            public String getId() {
                return generateUUID();      //todo::
            }

            @Override
            public String getStoringName() {
                return storingName;
            }

            @Override
            public List<String> getSizes() {
                return sizeNames;
            }
        };
    }

    protected String generateUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Override
    public void setImageRecorder(ImageRecorder recorder) {
        this.recorder = recorder;
    }
}
