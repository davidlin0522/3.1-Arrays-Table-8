public class Tile {
    private String value;
    private boolean isMatched;

    public Tile(String value) {
        this.value = value;
        this.isMatched = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        this.isMatched = matched;
    }

    @Override
    public String toString() {
        if (isMatched) {
            return value;
        } else {
            return "*";
        }
    }
}