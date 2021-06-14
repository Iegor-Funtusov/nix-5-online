package ua.com.alevel;

import ua.com.alevel.io.IOCRUDService;
import ua.com.alevel.type.FileType;

public class IoNioMain {

    public static void main(String[] args) {
        CRUDService service = new IOCRUDService();
//        service.createFile(FileType.FILE_TYPE.getPath());
//        service.createFile(FileType.FILE_HIDDEN_TYPE.getPath());
//        service.createDirs(FileType.DIRS_TYPE.getPath());
        service.deleteDirs(FileType.DIR_TYPE.getPath());
    }
}
