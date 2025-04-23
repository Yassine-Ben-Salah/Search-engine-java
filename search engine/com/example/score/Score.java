package com.example.score;

import com.example.readers.Statistic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {

    public Map<String, Integer> calculeScore(List<Statistic> ResultRecherche) {
        Map<String, Integer> dic = new HashMap<>();

        for (Statistic statistic : ResultRecherche) {
            int score = statistic.getStatistique();

            for (Statistic each : ResultRecherche) {
                if (each.getPath().equals(statistic.getPath()) && !each.equals(statistic)) {
                    score += each.getStatistique();
                }
            }

            dic.put(statistic.getPath(), score);
        }

        return dic;
    }
}