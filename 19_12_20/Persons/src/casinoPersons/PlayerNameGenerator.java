package casinoPersons;

public class PlayerNameGenerator {
    static int playerNameGenerator;

    public static String generateName() {
        return "player" + (++playerNameGenerator);
    }
}