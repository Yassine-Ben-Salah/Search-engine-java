package com.example.index;

import com.example.readers.CoupleStats;
import com.example.readers.Statistic;

import java.util.ArrayList;
import java.util.List;

public class Index1 implements Index {
   private  List<Statistic> index=new ArrayList<>();




   @Override
   public void addindex(List<CoupleStats> liststat, String path) {
      for(CoupleStats couple : liststat){
         Statistic statistic =new Statistic(path,couple.getWord(), couple.getStats());
         this.index.add(statistic);
      }
   }

   @Override
   public List<Statistic> rechercherequete(List<String> requete){
      List<Statistic> list = new ArrayList<>();
      for(Statistic statistic : this.getIndex()){
         for (String word : requete){
            if(statistic.getWord().equals(word)){
               list.add(statistic);


            }

         }

      }
      System.out.println("you used index 1");
      return list;
   }
   @Override
   public  List<Statistic> getIndex(){
      return this.index;
   }

}
