package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bayes {

    private List<Mail> ham = new ArrayList<>();
    private List<Mail> spam = new ArrayList<>();

    public Bayes() {
        try {
            // get all files in the folder
            final File folder = new File("hamAnlernen");
            final List<File> fileList = Arrays.asList(folder.listFiles());
            //read all mails
            for (File file : fileList) {
                Mail mail = new Mail();
                //read all lines
                for (String line : readFromFile(file.getPath())) {
                    for (String word : line.split(" ")) {
                        mail.addWord(word);
                    }
                }
                ham.add(mail);
            }


        } catch (IOException f) {
        }
    }

    private List<String> readFromFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public List<Mail> getMailList() {
        return ham;
    }



}

