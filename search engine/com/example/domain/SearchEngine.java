
package com.example.domain;
import com.example.Analyzor.Analyzor1;
import com.example.Analyzor.Analyzor2;
import com.example.Analyzor.Analyzor;
import com.example.Pretraiteurs.Pretraiteurs;
import com.example.index.Index;
import com.example.index.Index1;
import com.example.index.Index2;
import com.example.readers.*;
import com.example.ordonnaceur.Ordonnanceur;
import com.example.score.Score;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;

public class SearchEngine {
     public boolean isIndex1 = false;
     public Analyzor analyzor;
     public WordByWordDocumentReader wordByWordDocumentReader;
     public Index index;
     public List<Pretraiteurs> pretraiteurs =new ArrayList<>();
     public Score score;
     public Ordonnanceur ordonnanceur;
     public  boolean isAnalyzor2 =false;










    public SearchEngine(){
        this.analyzor =new Analyzor1();
        this.wordByWordDocumentReader=new WordByWordDocumentReader();
        this.pretraiteurs=new ArrayList<>();
        this.index=new Index2();
        this.ordonnanceur=new Ordonnanceur();
        this.score=new Score();


    }
    public void useIndex1(boolean useIndex1) {
        isIndex1 = useIndex1;
        if (isIndex1) {
            index = new Index1(); // Changer à Index1
        } else {
            index = new Index2(); // Revenir à Index2
        }
    }
    public void useAnalyzor2(boolean useAnalyzor2) {
        isAnalyzor2 = useAnalyzor2;
        if (isAnalyzor2) {
            analyzor = new Analyzor2();
        } else {
            analyzor = new Analyzor1();
        }
    }


    public void index(String path){
        File filePath = Paths.get(path).toFile();
        if(filePath.exists()){
            if(filePath.isDirectory()){
                System.out.println(path+" is a directory");
                indexDirectory(path);
            }else{
                System.out.println(path+" is a file");
                indexSingleDocument(path);
            }
        }else{
            System.out.println(path+" does not exist");
        }

    }




    private void indexSingleDocument(String path){
        List<String> contenu=this.wordByWordDocumentReader.readDocument(path);
        for(Pretraiteurs praitraiteurs:this.pretraiteurs){
            List<String> contenupretaite =praitraiteurs.traiter(contenu);
            contenu=contenupretaite;


        }

        List<CoupleStats> list = this.analyzor.analyse(contenu);
        this.index.addindex(list, path);


    }



    private void indexDirectory(String path){

        File pathFile = Paths.get(path).toFile();
        File[] files = pathFile.listFiles();
        for(File f: files ){
            if(f.isDirectory()){
                indexDirectory(f.getAbsolutePath());
            }else{
               indexSingleDocument(f.getAbsolutePath());
            }
        }

    }
    public List<String>  traiteRequete (String requete){
        List<String> mots = Arrays.asList(requete.split("\\s+"));

        for(Pretraiteurs praitraiteurs:this.pretraiteurs){
            List<String> requetepretaite =praitraiteurs.traiter(mots);
            mots=requetepretaite;


        }
        return mots;

    }














}
