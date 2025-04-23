package com.example.Pretraiteurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pretraiteur1 implements Pretraiteurs {

    @Override
    public List<String> traiter(List<String> contenu) {
        List<String> result = new ArrayList<>();
        List<String> unnecessary= Arrays.asList(".",",",";","","?","!",":" );
        for(String word : contenu){
            if(!unnecessary.contains(word.toLowerCase())){
                result.add(word);
            }
        }
        return result;
    }


}
