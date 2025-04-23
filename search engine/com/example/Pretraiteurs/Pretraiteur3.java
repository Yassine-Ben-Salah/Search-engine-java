package com.example.Pretraiteurs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pretraiteur3 implements Pretraiteurs {


    @Override
    public List<String> traiter(List<String> contenu) {
        List<String> result = new ArrayList<>();
        List<String> unnecessary= Arrays.asList("of","or","and","this","the","for","a" );
        for(String word : contenu){
            if(!unnecessary.contains(word.toLowerCase())){
                result.add(word);
            }
        }
        return result;
    }


}
