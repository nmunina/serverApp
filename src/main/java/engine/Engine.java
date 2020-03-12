package engine;

public class Engine {
    //TODO: use enumerations
    public static final String CLASSIC = "classic";
    public static final String FREESTYLE = "freestyle";
    public static final String BABY = "baby";
    public static final String CHILD = "child";
    public static final String GROWNUP = "grownup";
    public static final String CASE207 =  "Classic skis are only made for lengths up to 207cm.";
    public static final String DATAMISSING =  "Data is missing.";

    public static final boolean IS_COMPETING = false;

    private Engine() {
    }

    public static String calculateSkiLength(int bodyLength, String ageGroup, String style, boolean isCompeting) {

        if (bodyLength == 0) {
            return DATAMISSING;
        }

        if (style.equals(CLASSIC) && bodyLength > 197) {
            return CASE207;
        }
        if (ageGroup.equals(BABY)) {
            return String.valueOf(bodyLength);
        }
        return calculateBoundary(bodyLength, ageGroup, style, isCompeting);
    }

    private static String calculateBoundary(int bodyLength, String ageGroup, String style, boolean isCompeting) {
        if (ageGroup.equals(CHILD)) {
            if (bodyLength >= 198) {
                return CASE207;
            } else if (bodyLength == 197) {
                return "207. " + CASE207;
            } else if (bodyLength >= 188) {
                return (bodyLength + 10) + " to 207. " + CASE207;
            }

            return (bodyLength + 10) + " to " + (bodyLength + 20);
        }

        if (style.equals(CLASSIC)) {
            if (bodyLength > 187) {
                return CASE207;
            }

            return "" + (bodyLength + 20);

        } else {
            if (isCompeting) {
                return (bodyLength + 10) + "";
            } else return (bodyLength + 10) + " to " + (bodyLength + 15);
        }
    }
}
