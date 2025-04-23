package com.example.Pretraiteurs;

import java.util.ArrayList;
import java.util.List;

public class Pretraiteur2 implements Pretraiteurs {


    @Override
    public List<String> traiter(List<String> contenu) {
        List<String> list = new ArrayList<>();
        for(String word : contenu){
            list.add(word.toLowerCase());
        }
        return list;
    }



}
