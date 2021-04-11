package legoset;

import album.Album;
import jaxb.JAXBHelper;
import movie.Movie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        var legoSet = new LegoSet();

        legoSet.setNumber("75211");
        legoSet.setUrl("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter");

        legoSet.setName("Imperial TIE Fighter");
        legoSet.setTheme("Star Wars");
        legoSet.setSubtheme("Solo");
        legoSet.setYear(Year.of(2018));
        legoSet.setPieces(519);
        legoSet.setPackaging(Packaging.BOX);
        legoSet.setTags(Set.of("Starfighter", "Stormtrooper", "Star Wars", "Solo"));

        var minifigs = new ArrayList<Minifig>();
        minifigs.add(new Minifig("Imperial Mudtrooper", 2));
        minifigs.add(new Minifig("Imperial Pilot", 1));
        minifigs.add(new Minifig("Mimban Stormtrooper", 1));
        legoSet.setMinifigs(minifigs);

        legoSet.setRatings(new Ratings(4.4, 468));

        JAXBHelper.toXML(legoSet, System.out);

        JAXBHelper.toXML(legoSet, new FileOutputStream("legoset.xml"));
        System.out.println(JAXBHelper.fromXML(LegoSet.class, new FileInputStream("legoset.xml")));
    }
}
