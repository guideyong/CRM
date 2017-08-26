package crm.util;

import java.io.File;
import java.util.UUID;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;

public class FileUploadUtil {
    public static String uploadFile(String fileName)
            throws Exception {
        String uuid = UUID.randomUUID().toString();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        fileName = uuid + fileType;
        return fileName;
    }

    /**
     * 删除文件
     *
     * @param filepath
     */
    public static void deleteFile(String filepath) {
        File file = new File(filepath);
        if (file.exists()) {
            file.delete();
        }

    }
}

