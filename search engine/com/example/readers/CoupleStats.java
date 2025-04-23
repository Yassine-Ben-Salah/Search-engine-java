package com.example.readers;

public class CoupleStats {
    private String word;
    private Integer stats;

    public CoupleStats(String word, int stats) {
        this.word=word;

        this.stats = stats ;

    }

    public Integer getStats() {
        return stats;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "CoupleStats{" +
                "word='" + word + '\'' +
                ", stats=" + stats +
                '}';
    }
}
