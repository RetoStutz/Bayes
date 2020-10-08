package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bayes {

    private List<Mail> ham = new ArrayList<>();

    public Bayes (){

        // get all files in the folder
        final File folder = new File("../resources/data/hamAnlernen");
        final List<File> fileList = Arrays.asList(folder.listFiles());

        for (int i = 0; i < fileList.size()-1; i++) {
            for (String line : readFromFile(fileList.get(i).getPath())) {
                for (String word : line.split(" ")){
                    ham.get(i).addWord(word);
                }
            }
        }

    }

    private List<String> readFromFile(String fileName) {
        try (BufferedReader reader = getReader(fileName)) {
            return reader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("failed");
        }
    }

    private BufferedReader getReader(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);  // damit kann man vom File lesen
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // lesen von Text-File
        return new BufferedReader(reader);  // damit man zeilenweise lesen kann
    }

    public List<Mail> getMailList(){
        return ham;
    }

}

