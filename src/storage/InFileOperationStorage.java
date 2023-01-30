package storage;

import entity.Operation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InFileOperationStorage implements OperationStorage {
    private final String FILE_NAME = "history.txt";
    Date date = new Date();

    public void save(Operation operation) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);) {
            fileWriter.write(String.valueOf(date));
            fileWriter.write(" ");
            fileWriter.write(operation.toString());
            fileWriter.write("\n");
            fileWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Operation> findAll() {
        return new ArrayList<>();
    }

//    @Override
//    public List<String> findAll() {
//        List<String> operationFromFile=new ArrayList<>();
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME)))  {
//            bw.toString();
//        }catch (IOException e) {
//            throw new RuntimeException(e);}
//        return operationFromFile;
//    }
}
