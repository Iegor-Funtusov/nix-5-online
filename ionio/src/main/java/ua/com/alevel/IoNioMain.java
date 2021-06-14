package ua.com.alevel;

import ua.com.alevel.io.IOCRUDService;
import ua.com.alevel.nio.NIOCRUDService;
import ua.com.alevel.type.FileType;

public class IoNioMain {

    public static void main(String[] args) {
        IOCRUDService service = new IOCRUDService();
        service.rename(FileType.FILE_TYPE.getPath(), "ZZZ.txt");
//        service.createFile(FileType.FILE_TYPE.getPath());
//        service.createFile(FileType.FILE_HIDDEN_TYPE.getPath());
//        service.createDirs(FileType.DIRS_TYPE.getPath());
//        service.deleteDirs(FileType.DIR_TYPE.getPath());
//        NIOCRUDService service = new NIOCRUDService();
//        service.createFile(FileType.FILE_TYPE.getPath());
//        service.createDir(FileType.DIR_TYPE.getPath());
//        service.createDirs(FileType.DIRS_TYPE.getPath());
//        service.move(FileType.DIR_TYPE.getPath(), "copy");
    }
}
