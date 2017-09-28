package cn.tac.template.fileupload.domain;

import cn.tac.template.fileupload.model.bo.FileStoringInfo;

import java.util.List;

/**
 * @author tac
 * @since 28/09/2017
 */
public interface Storage {
    int store(List<FileStoringInfo> infos);
}
