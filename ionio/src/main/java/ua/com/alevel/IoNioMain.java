package ua.com.alevel;

import ua.com.alevel.file.csv.CsvTest;
import ua.com.alevel.file.json.JsonTest;
import ua.com.alevel.io.IOCRUDService;
import ua.com.alevel.nio.NIOCRUDService;
import ua.com.alevel.serial.UserSerializationTest;
import ua.com.alevel.type.FileType;

import java.io.*;
import java.util.LinkedList;

public class IoNioMain {

    public static void main(String[] args) {

        CsvTest csvTest = new CsvTest();
        csvTest.test();

//        JsonTest jsonTest = new JsonTest();
//        jsonTest.saveUsersToJson();

        // InputStream inputStream;       Reader reader;
        // BufferedInputStream           //BufferedReader
        // FileInputStream               //FileReader
        // ByteArrayInputStream
        // ObjectInputStream

        // OutputStream outputStream;     Writer writer;
        //  BufferedOutputStream           //        BufferedWriter
        // FileOutputStream              //        FileWriter
        // ByteArrayOutputStream
        // ObjectOutputStream

//        FileIOTest fileIOTest = new FileIOTest();
//        fileIOTest.test();

//        UserSerializationTest userSerializationTest = new UserSerializationTest();
//        userSerializationTest.saveUserState();

//        IOCRUDService service = new IOCRUDService();
//        service.rename(FileType.FILE_TYPE.getPath(), "ZZZ.txt");
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
