package com.example.domain;

import com.example.Pretraiteurs.Pretraiteur1;
import com.example.Pretraiteurs.Pretraiteur2;
import com.example.Pretraiteurs.Pretraiteur3;
import com.example.Pretraiteurs.Pretraiteurs;
import com.example.readers.Statistic;

import java.util.*;

public class main {
    public static void main(String[] args) {




        long startTime = System.currentTimeMillis();
        SearchEngine moteur  =new SearchEngine();
        moteur.index("C:\\Users\\hp\\OneDrive\\Bureau\\mp2");

        long endTime = System.currentTimeMillis();

        // Calculer la durée d'exécution en millisecondes
        long duration = endTime - startTime;

        // Afficher la durée d'exécution
        System.out.println("Le temps d'exécution est de : " + duration + " millisecondes");








        SearchEngine searchEngine = new SearchEngine();


        boolean word2 = true;

        do {

            System.out.println("* To perform a search, type 1:");
            System.out.println("* To choose the search engine settings, type 2:");

            System.out.println("To exit the menu, type 0");
            System.out.println("..........................................................");

            Scanner scanner = new Scanner(System.in);
            String choiceNumber = scanner.nextLine();
            Pretraiteur1 pre1=new Pretraiteur1();
            Pretraiteur2 pre2=new Pretraiteur2();
            Pretraiteur3 pre3=new Pretraiteur3();
            searchEngine.pretraiteurs.add(pre2);
            searchEngine.pretraiteurs.add(pre3);

            searchEngine.pretraiteurs.add(pre1);

            switch (choiceNumber) {


                case "1":
                    do {

                        System.out.println("Provide the file path to index:");
                        String path = scanner.nextLine();
                        searchEngine.index(path);




                        System.out.println("To write the search term, type 1");
                        System.out.println("To quit the search, type 0");
                        System.out.println("..........................................................");
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                do {

                                    System.out.println("Enter your search term: ");
                                    String term = scanner.nextLine();
                                    System.out.println("..........................................................");
                                    System.out.print("search term words: ");
                                    List<String> requetePretraite =searchEngine.traiteRequete(term);
                                    for (String word : requetePretraite) {
                                        System.out.println(word);
                                    }
                                    System.out.println("Files containing the words in the search term:");


                                    List<Statistic> result = searchEngine.index.rechercherequete(requetePretraite);
                                    for (Statistic stats : result) {
                                        System.out.println(stats);
                                    }
                                    Map<String, Integer> map = searchEngine.score.calculeScore(result);
                                    List<String> list = searchEngine.ordonnanceur.ordonnancer(map);
                                    System.out.println("The search result is:");
                                    for (String word : list) {
                                        System.out.println(word);
                                    }
                                } while (!choice.equals("0"));
                                break;



                        }while (!choice.equals(0)) ;


                    } while (word2);
                case "2":
                    boolean mot=true;


                    do {
                        System.out.println("Search Engine Configuration:");
                        System.out.println("To choose the indexer type, type 1");
                        System.out.println("To choose the type of score analyzer type 2");
                        System.out.println("To choose the type of Pretraiteur type 3");

                        System.out.println("To exit the configuration menu, type 0");
                        List<String> choix = List.of("0", "1", "2", "3", "4", "5");
                        String choice1 = new String();

                        do {
                            System.out.print("Entrez un numéro de choix valide: ");

                            choice1 = scanner.nextLine();
                            System.out.println("..............................................................");

                        } while (!choix.contains(choice1));
                        if (choice1.equals("1")) {
                            System.out.println("To choose index1, type 1");
                            System.out.println("To choose index2, type 2");
                            System.out.println("Exit, type 0");

                            List<String> liste =List.of("0","1","2");

                            String choix2;
                            do {
                                System.out.print("Please enter a valid choice number:\n");
                                choix2 = scanner.nextLine();
                            } while (!liste.contains(choix2));
                            if (choix2.equals("1")) {
                                searchEngine.useIndex1(true);
                                System.out.println("you are using index1");

                            } else {
                                searchEngine.useIndex1(false);
                                System.out.println("you are using index2");

                            }


                        }
                        else if (choice1.equals("2")) {
                            System.out.println("To choose Analysor1, type 1");
                            System.out.println("To choose Analysor2, type 2");

                            String choix3;
                            System.out.println("..............................................................");
                            List<String> liste = List.of("1", "2");
                            do {
                                System.out.print("Please enter a valid choice number:\n ");
                                choix3 = scanner.nextLine();
                            } while (!liste.contains(choix3));
                            if (choix3.equals("1")) {
                                searchEngine.useAnalyzor2(false);
                                System.out.println("you are using Analyzor1");

                            } else {
                                searchEngine.useAnalyzor2(true);
                                System.out.println("you are using Analyzor2");

                            }


                        }
                        else if (choice1.equals("0")) {
                            mot=false;
                            // statements to execute if expression equals value2
                            break;
                        }
                        else if (choice1.equals("3")) {
                            boolean word6=true;




                            do{
                                System.out.println("To choose Pretraiteur1, type 1");
                                System.out.println("To choose Pretraiteur2, type 2");
                                System.out.println("To choose Pretraiteur3, type 3");
                                System.out.println("Exit, type 0");


                                String choix5;
                                System.out.println("..............................................................");
                                List<String> liste = List.of("0","1", "2","3");
                                do {
                                    System.out.print("Please enter a valid choice number:\n ");
                                    choix5 = scanner.nextLine();
                                } while (!liste.contains(choix5));
                                List<Pretraiteurs> praitreteurs=new ArrayList<>();
                                if (choix5.equals("1")) {
                                    praitreteurs.add(pre1);

                                }
                                else if(choix5.equals("2")) {
                                    praitreteurs.add(pre2);


                                }
                                else if(choix5.equals("0")) {
                                    word6=false;


                                    break;


                                }
                                else {
                                    praitreteurs.add(pre3);

                                }
                                searchEngine.pretraiteurs=praitreteurs;

                            }while (word6);




                        }


                    } while (mot);
                    break;

                case "0":

                    word2=false;


                    // statements to execute if expression equals value2
                    break;
            }


        } while (word2);
    }



}





