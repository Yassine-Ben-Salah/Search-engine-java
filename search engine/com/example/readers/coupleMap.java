package com.example.readers;

public class coupleMap {
    private String word;
    private String path;

    public coupleMap(String path, String word) {
        this.word=word;

        this.path = path ;

    }

    public String getpath() {
        return path;
    }

    public String getWord() {
        return word;
    }


}
