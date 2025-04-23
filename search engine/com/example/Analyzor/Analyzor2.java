package com.example.Analyzor;

import com.example.readers.CoupleStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzor2 implements Analyzor {


    @Override
    public List<CoupleStats>  analyse(List<String> content) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : content){
            int occurrenceNumber=0;
            for (String mot : content) {
                if (word.equals(mot)) {
                    occurrenceNumber++;
                }
            }
            map.put(word,occurrenceNumber);

        }
        List<CoupleStats> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            CoupleStats coupleStats = new CoupleStats(entry.getKey(), entry.getValue());
            list.add(coupleStats);
        }
        return list;
    }



}


