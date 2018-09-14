package mdoe.example.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.String;
import java.io.File;
import java.io.IOException;
import java.lang.System;
import java.util.Scanner;


public class App
{

    public static void main( String[] args )
    {
        String home = System.getProperty("user.home");         //Systemunabhaeging homefolder finden https://stackoverflow.com/questions/585534/what-is-the-best-way-to-find-the-users-home-directory-in-java

        File aliasopt = new File(home+"/alias.txt");     //Checken ob Optionsdtei existiert
       if (aliasopt.exists()){
           System.out.println("Starte Start-Funktion");

           start();
       }else{
           System.out.println("Optionsdatei schreiben");
           String optliste[]=new String[20];

           for(int i =0;i<20;i++){
               if (i>9){
                   optliste[i]="c"+(i-10)+": Keine alias-Zuweisung vorhanden!";
               }else{
              optliste[i]="";}
               System.out.println(optliste[i]);
           }

           String optlistestr = "";
           for (int i =0;i<optliste.length;i++){
               optlistestr = optlistestr +"\n"+optliste[i];

           }

           System.out.println("DATEI: \n"+optlistestr);

            try {

                File optdatei = new File(home+"/alias.txt");
                optdatei.createNewFile();                                   //Datei erstellen

                System.out.println("Neue Options-Datei geschrieben.");
            }catch(IOException e){
                System.out.println("OOOPS: "+e);
            }

           try {
               File optdatei = new File(home+"/alias.txt");         //Datei schreiben https://stackoverflow.com/questions/20509114/bufferedwriter-not-writing-to-text-file
               FileWriter fw = new FileWriter(optdatei);
               BufferedWriter bw = new BufferedWriter(fw);
               bw.write(optlistestr);
               bw.close();


           }catch(IOException e){

               System.out.println("OOOPS SCHREIEBN: "+e);
           }
       }
    }

    public static String[] einlesen() throws IOException{
        System.out.println("Einlesen-Funktion gestartet");
        String home  = System.getProperty("user.home");
        String[] opteinstr = new String[21];
        Scanner optein = new Scanner(new File(home+"/alias.txt"));      //JfD, S. 215
        for(int i =0;i<21;i++){
            opteinstr[i] = optein.nextLine();                          //mit nextLine() jeweils die nächste Zeile auslesen
        }


       optein.close();
        return (opteinstr);
    }


    public static void start() {

    System.out.println("Start-Funktion gestartet");

    String[] optdateiarray = new String[21];
    try {                                                                       //einlesen() wirft evtl. Fehler, daher trycatch
        optdateiarray= einlesen();
    }catch(IOException e){
        System.out.println("OOOPS LESEN: "+e);
    }
        System.out.println(optdateiarray[20]);

    }

}