package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mail {

    private Map<String, Integer> wordList = new HashMap<>();

    public void addWord (String word){
        //if word is not in list add word and set value to 1 otherwise increment value
        wordList.merge(word, 1, Integer::sum);
    };

    public Map<String, Integer> getWordList (){
        return wordList;
    }



}
