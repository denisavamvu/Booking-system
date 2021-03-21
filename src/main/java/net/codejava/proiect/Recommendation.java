package net.codejava.proiect;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Recommendation {


    public List getRecommandations(User user, List<Locatie> listLocatie, List<Calatorii> listLegaturi){

        List<Integer> scoreList = new ArrayList<Integer>();

        List<String> allTipes = new ArrayList<>();
        List<String> allCities = new ArrayList<>();

        for (Locatie currentLocatie : listLocatie)
            scoreList.add(0);

        for (Locatie currentLocatie : listLocatie)
        {
            allTipes.add(currentLocatie.getTip());
            allCities.add(currentLocatie.getNumeOras());
        }

        List<String> tipesDistinct = allTipes.stream().distinct().collect(Collectors.toList());
        List<String> citiesDistinct = allCities.stream().distinct().collect(Collectors.toList());

        List<Integer> scoreTipuri = new ArrayList<>();
        for (String currentTipe : tipesDistinct)
        {
            scoreTipuri.add(0);
        }

        List<Integer> scoreOrase = new ArrayList<>();
        for (String current : citiesDistinct)
        {
            scoreOrase.add(0);
        }

        int index = 0;
        for (String currentTipe : tipesDistinct) {
            for (Locatie locatie : listLocatie)
            {
                if (locatie.getTip().equals(currentTipe))
                {
                    for (Calatorii current : listLegaturi)
                    {
                        if (current.getIdUser().equals(user.getId()) && current.getIdLocatie().equals(locatie.getId()))
                        {
                            scoreTipuri.set(index, scoreTipuri.get(index) + current.getNrCalatorii().intValue());
                        }
                    }
                }
            }
            index++;
        }


        index = 0;
        for (String currentCity : citiesDistinct) {
            for (Locatie locatie : listLocatie)
            {
                if (locatie.getNumeOras().equals(currentCity))
                {
                    for (Calatorii current : listLegaturi)
                    {
                        if (current.getIdUser().equals(user.getId()) && current.getIdLocatie().equals(locatie.getId()))
                        {

                            scoreOrase.set(index, scoreOrase.get(index) + current.getNrCalatorii().intValue());
                        }
                    }
                }
            }
            index++;
        }

        for (int indexScore = 0; indexScore < scoreList.size(); indexScore++)
        {
            for (int indexFirst = 0; indexFirst < scoreTipuri.size(); indexFirst++)
            {
                for (int indexSecond = 0; indexSecond < scoreOrase.size(); indexSecond++)
                {
                    if (listLocatie.get(indexScore).getTip().equals(tipesDistinct.get(indexFirst)) &&
                            listLocatie.get(indexScore).getNumeOras().equals(citiesDistinct.get(indexSecond))) {
                        for (Calatorii current : listLegaturi) {
                            if (current.getIdUser().equals(user.getId()) && current.getIdLocatie().equals(listLocatie.get(indexScore).getId()))
                                scoreList.set(indexScore, -current.getNrCalatorii().intValue());
                        }
                        scoreList.set(indexScore, scoreList.get(indexScore) + scoreTipuri.get(indexFirst) + scoreOrase.get(indexSecond));
                    }
                }
            }
        }

        int first = 0, second = 0,third = 0;
        index = 0;
        List<Locatie> recomandari = new ArrayList<>();
        recomandari.add(listLocatie.get(0));
        recomandari.add(listLocatie.get(0));
        recomandari.add(listLocatie.get(0));
        for (Locatie locatie : listLocatie)
        {
            if (scoreList.get(index) > first)
            {
                recomandari.set(2, recomandari.get(1));
                recomandari.set(1, recomandari.get(0));
                recomandari.set(0, locatie);
                third = second;
                second = first;
                first = scoreList.get(index);
            }
            else if (scoreList.get(index) > second)
            {
                recomandari.set(2, recomandari.get(1));
                recomandari.set(1, locatie);
                third = second;
                second = scoreList.get(index);
            }
            else if (scoreList.get(index) > third)
            {
                recomandari.set(2, locatie);
                third = scoreList.get(index);
            }
            index++;
        }

        index = 0;
        for (String tip : tipesDistinct)
        {
            System.out.println(tip + " " + scoreTipuri.get(index));
            index++;
        }
        return recomandari;
    }
}
