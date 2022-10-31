package StefanAgustoHutapeaJSleepDN;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

/**
 * Tugas Pendahuluan 6
 * Stefan Agusto Hutapea
 * 2106700744
 */

public class JSleep
{   
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args)
    {
        String filepath= "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\city.json";
        Gson gson = new Gson();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("Name: " + input.name);
            System.out.println("Population: " + input.population);
            System.out.println("States: ");
            input.listOfStates.forEach(state -> System.out.println(state));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}