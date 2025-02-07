package ModuleExamples;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Mod05Examples {
    
    public static void main(String[] args) {
        Mod05Book stranger = new Mod05Book("Stranger in a Strange Land", "scifi", 1964, 408, 31);
        Mod05AudioBook strangerAudio = new Mod05AudioBook("Stranger in a Strange Land", "scifi", 1964, 31, "US-ABC-23-45678", 240);
        Mod05Book dune = new Mod05Book("Dune", "scifi", 1965, 412, 32);
        Mod05AudioBook duneAudio = new Mod05AudioBook("Dune", "scifi", 1965, 32, "US-ABC-23-45679", 240);
        Mod05Book foundation = new Mod05Book("Foundation", "scifi", 1951, 255, 33);
        Mod05AudioBook foundationAudio = new Mod05AudioBook("Foundation", "scifi", 1951, 33, "US-ABC-23-45680", 240);
        Mod05Book enders = new Mod05Book("Ender's Game", "scifi", 1985, 324, 34);
        Mod05AudioBook endersAudio = new Mod05AudioBook("Ender's Game", "scifi", 1985, 34, "US-ABC-23-45681", 240);
        Mod05Book hobbit = new Mod05Book("The Hobbit", "fantasy", 1937, 310, 35);
        Mod05AudioBook hobbitAudio = new Mod05AudioBook("The Hobbit", "fantasy", 1937, 35, "US-ABC-23-45682", 240);
        Mod05Book rings = new Mod05Book("The Fellowship of the Ring", "fantasy", 1954, 423, 36);
        Mod05AudioBook ringsAudio = new Mod05AudioBook("The Fellowship of the Ring", "fantasy", 1954, 36, "US-ABC-23-45683", 240);
        Mod05Book towers = new Mod05Book("The Two Towers", "fantasy", 1954, 352, 37);
        Mod05AudioBook towersAudio = new Mod05AudioBook("The Two Towers", "fantasy", 1954, 37, "US-ABC-23-45684", 240);
        Mod05Book towers2 = new Mod05Book("The Two Towers", "fantasy", 1954, 352, 37);
        Mod05AudioBook towersAudio2 = new Mod05AudioBook("The Two Towers", "fantasy", 1954, 37, "US-ABC-23-45684", 240);


        if("stranger".equals("Stranger")) {
            System.out.println("stranger is stranger");
        }

        HashSet<Mod05IBook> mediaSet = new HashSet<>();
        mediaSet.add(stranger);
        mediaSet.add(strangerAudio);
        mediaSet.add(dune);
        mediaSet.add(duneAudio);

        System.out.println(mediaSet);

        HashMap<String, Mod05AbstractMedia> mediaMap = new HashMap<>();

        mediaMap.put("Stranger in a Strange Land", (Mod05AbstractMedia)stranger);
        mediaMap.put("Stranger in a Strange Land - AudioBook", strangerAudio);

        System.out.println(mediaMap);

        System.out.println("Stranger in a Strange Land".equals(new String("Stranger in a Strange Land")));

        List<String> list = new LinkedList<>(List.of("A", "B", "C", "D", "E", "a", "b", "c", "d", "e", "AA", "BB", "CC", "DD", "EE"));

        System.out.println(list);

        list.sort(String.CASE_INSENSITIVE_ORDER);

        System.out.println(list);

        LinkedList<Mod05AbstractMedia> mediaList = new LinkedList<>();
        mediaList.add(stranger);
        mediaList.add(strangerAudio);
        mediaList.add(dune);
        mediaList.add(duneAudio);
        mediaList.add(foundation);
        mediaList.add(foundationAudio);
        mediaList.add(enders);
        mediaList.add(endersAudio);
        mediaList.add(hobbit);
        mediaList.add(hobbitAudio);
        mediaList.add(rings);
        mediaList.add(ringsAudio);
        mediaList.add(towers);
        mediaList.add(towersAudio);
        mediaList.add(towers2);
        mediaList.add(towersAudio2);

        // for(Mod05IMedia media : mediaList) {
        //     System.out.println(media);
        // }

        Collections.sort(mediaList, new SortByType());

        // for(Mod05IMedia media : mediaList) {
        //     System.out.println(media);
        // }

        TreeSet<Mod05AbstractMedia> mediaList2 = new TreeSet<>((o1, o2) -> { 
                int compare = o1.getRating() - o2.getRating();
                if(compare == 0) {
                    compare = o1.getTitle().compareTo(o2.getTitle());
                } 
                if (compare == 0) {
                    compare = o1.getYearCreated() - o2.getYearCreated();
                }
                if (compare == 0) {
                    compare = o1.getType().compareTo(o2.getType());
                }
                return compare;
        });

        mediaList2.add(stranger);
        mediaList2.add(strangerAudio);
        mediaList2.add(dune);
        mediaList2.add(duneAudio);
        mediaList2.add(foundation);
        mediaList2.add(foundationAudio);
        mediaList2.add(enders);
        mediaList2.add(endersAudio);
        mediaList2.add(hobbit);
        mediaList2.add(hobbitAudio);
        mediaList2.add(rings);
        mediaList2.add(ringsAudio);
        mediaList2.add(towers);
        mediaList2.add(towersAudio);
        mediaList2.add(towers2);
        mediaList2.add(towersAudio2);
        
        for(Mod05AbstractMedia media : mediaList2) {
            System.out.println(media);
        }
    }


    public static class SortByGenre implements Comparator<Mod05AbstractMedia> {
        @Override
        public int compare(Mod05AbstractMedia o1, Mod05AbstractMedia o2) {
            return o2.getGenre().compareTo(o1.getGenre());
        }
    }

    public static class SortByType implements Comparator<Mod05AbstractMedia> {
        @Override
        public int compare(Mod05AbstractMedia o1, Mod05AbstractMedia o2) {
            return o1.getType().compareTo(o2.getType());
        }
    }
}
