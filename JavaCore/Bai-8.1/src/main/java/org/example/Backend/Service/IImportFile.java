package org.example.Backend.Service;

import org.example.DTO.ImportError;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface IImportFile<T, K, E> {
    List<T> readFile(String path);
    void validation(T csv, E context ,List<ImportError> importErrors, List<K> entities);
    void saveAll(List<K> entities);
    void exportFileError(String pathError, List<ImportError> importErrors);

    default String importFile(String path, E context, String pathError){
        File file = new File(path);
        if(!file.exists()){
            return "File was not exist!";
        }
        if(!path.endsWith(".csv")){
            return "Invalid file format!";
        }
        List<T> csvs = readFile(path);
        if(Objects.isNull(csvs)) return "Invalid csv format!";
        List<ImportError> importErrors = new ArrayList<>();
        List<K> entities = new ArrayList<>();
        for(T csv: csvs){
            validation(csv, context, importErrors, entities);
        }
        //Save list vao DB
        saveAll(entities);

        //Export error file
        exportFileError(pathError, importErrors);

        String message = "Import success " + entities.size() + ", fail: " +importErrors.size();
        return message;
    }
}
