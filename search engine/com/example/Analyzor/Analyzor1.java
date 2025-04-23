package com.example.Analyzor;

import com.example.readers.CoupleStats;

import java.util.*;

public class Analyzor1 implements Analyzor {



    @Override
    public List<CoupleStats> analyse(List<String> contentPretraite) {
        List<CoupleStats>  list = new ArrayList<>();
        Collections.sort(contentPretraite);
        int comp = 0;
        while (comp < contentPretraite.size() - 1) {
            int occurrenceNumber = 1;
            while (comp < contentPretraite.size() - 1 && contentPretraite.get(comp).equals(contentPretraite.get(comp + 1))) {
                occurrenceNumber++;
                comp++;
            }
            list.add(new CoupleStats(contentPretraite.get(comp), occurrenceNumber));
            comp++;
        }
        return list;

    }




}
