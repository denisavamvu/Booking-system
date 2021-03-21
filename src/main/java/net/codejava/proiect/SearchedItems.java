package net.codejava.proiect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchedItems {
    public List functie(List<Locatie> listLocatie, SearchCriteria searchCriteria){
        List<Locatie> result = new ArrayList<>();
        for(Locatie locatie: listLocatie)
            if(locatie.getNumeOras().equals(searchCriteria.getLocation()) && locatie.getTip().equals(searchCriteria.getType()))
                result.add(locatie);
        Collections.sort(result);
        return result;
    }
}
