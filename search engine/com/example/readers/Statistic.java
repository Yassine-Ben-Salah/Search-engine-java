package com.example.readers;

public class Statistic {
    private String path;
    private String word;
    private Integer stats;



    public Statistic(String path , String word,Integer stats){
        this.path = path;
        this.word = word;
        this.stats =stats;
    }

    public int getStatistique() {

        return stats;
    }

    public String getPath() {
        return path;
    }

    public String getWord() {

        return word;
    }
    public String toString() {
        return "Statistic{" +
                "path='" + path + '\'' +
                ", word='" + word + '\'' +
                ", statistique=" + stats +
                '}';
    }

}
