package com.example.index;

import com.example.readers.CoupleStats;
import com.example.readers.Statistic;

import java.util.List;

public interface Index {
    void addindex(List<CoupleStats>coupleStats, String path);
    List<Statistic> getIndex();
    List<Statistic> rechercherequete(List<String> requete);


}

