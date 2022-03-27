package brickset;

import repository.Repository;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Prints out the Lego setts that start with a given string.
     */
    public void printLegoSettNamesBeginningWith(String first) {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getName)
                .filter(name -> name.toLowerCase().startsWith(first))
                .forEach(System.out::println);
    }

    /**
     * Prints out the Lego setts with names shorter than five.
     */
    public void printLegoSettNamesShorterThanFive() {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getName)
                .filter(name -> name.length() <= 5)
                .forEach(System.out::println);
    }

    /**
     * Prints out the Lego setts with names equal to a given number.
     */
    public void printLegoSettNamesLengthEqualToGiven(int number) {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getName)
                .filter(name -> name.length() == number)
                .forEach(System.out::println);
    }

    /**
     * Counts the Lego setts with names equal to a given number.
     */
    public long countLegoSetsByNameLength(int number) {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        return lego.stream()
                .map(LegoSet::getName)
                .filter(name -> name.length() == number)
                .count();
    }

    /**
     * Prints all lego sett themes sorted and without duplication.
     */
    public void printLegoSettThemesSorted() {
        var repository = new LegoSetRepository();
        var lego = repository.getAll();
        lego.stream()
                .map(LegoSet::getTheme)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        var repository = new LegoSetRepository();
        System.out.println("printLegoSettNamesBeginningWith():");
        repository.printLegoSettNamesBeginningWith("a");
        System.out.println("printLegoSettNamesShorterThanFive():");
        repository.printLegoSettNamesShorterThanFive();
        System.out.println("printLegoSettNamesLengthEqualToGiven():");
        repository.printLegoSettNamesLengthEqualToGiven(6);
        System.out.println("countLegoSetsByNameLength():");
        System.out.println(repository.countLegoSetsByNameLength(4));
        System.out.println("printLegoSettThemesSorted():");
        repository.printLegoSettThemesSorted();
    }
}
