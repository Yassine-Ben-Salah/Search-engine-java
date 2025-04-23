package com.example.ordonnaceur;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Ordonnanceur {
    public List<String> ordonnancer(Map<String,Integer> dic ){
        List<Integer> listeValeurs = new ArrayList<>(dic.values());

        Collections.sort(listeValeurs, Comparator.reverseOrder());
        List<String> result=new ArrayList<>();
        for(int valeur : listeValeurs){
            for(Map.Entry<String, Integer> entry : dic.entrySet()){
                if(valeur==entry.getValue()){
                    result.add(entry.getKey());

                }
            }
        }
        return result;
    }
}
