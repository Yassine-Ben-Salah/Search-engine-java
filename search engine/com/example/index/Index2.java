package com.example.index;

import com.example.readers.CoupleStats;
import com.example.readers.Statistic;
import com.example.readers.coupleMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index2 implements Index {
    private Map<coupleMap,Integer> index = new HashMap<>();


    @Override

    public void addindex(List<CoupleStats> coupleStats, String path) {
        for (CoupleStats couple : coupleStats) {
            coupleMap coupleMap = new coupleMap(path, couple.getWord());
            this.index.put(coupleMap, couple.getStats() );
        }
    }
    public Map<coupleMap,Integer> getIndexMap(){
        return this.index;
    }
    @Override
    public List<Statistic> getIndex() {
        List<Statistic> list =new ArrayList<>();
        for(Map.Entry<coupleMap,Integer> entry : this.index.entrySet()){
            Statistic statistic =new Statistic(entry.getKey().getpath(), entry.getKey().getWord(),entry.getValue());
            list.add(statistic);
        }
        return list;
    }




    @Override
    public List<Statistic> rechercherequete(List<String> requete) {
        List<Statistic> list = new ArrayList<>();

        for (Map.Entry<coupleMap,Integer> entry : this.getIndexMap().entrySet()) {
            for (String word : requete) {
                if (word.equals(entry.getKey().getWord())) {
                    Statistic statistic = new Statistic(entry.getKey().getpath(), entry.getKey().getWord(), entry.getValue());
                    list.add(statistic);

                }
            }
        }
        System.out.println("you used index 2");

        return list;
    }

}
