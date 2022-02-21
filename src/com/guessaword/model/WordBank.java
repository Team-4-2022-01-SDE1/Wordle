package com.guessaword.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.*;

class WordBank {
    List<String> dict;
    private static final String LIST_OF_WORDS_FROM_FILE = "Dictionary/words.txt";

    public WordBank(List<String> dict) {
        setDict(dict);
    }

    public String getWord() {
        int index = (int)(Math.random() * dict.size()) + 1;
        return dict.get(index);
    }

    public List<String> getDict() {
        return dict;
    }

    public void setDict(List<String> dict) {
        try {
            dict = Files.readAllLines(Path.of(LIST_OF_WORDS_FROM_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dict = convertToUpper(dict);
        Collections.sort(dict);
        this.dict = dict;
    }

    public List<String> convertToUpper(List<String> list) {
        List<String> convertToUpper = list.stream()
                .distinct()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return convertToUpper;
    }
}