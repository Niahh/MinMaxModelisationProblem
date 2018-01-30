package plateau;

public class Case {
    private int posX;
    private int posY;
    private boolean isOccupied;
    private String value;

    public Case(){
        // TO DO
        this.posY = -1;
        this.posX = -1;
        this.value = " ";
    }

    public Case(int posX, int posY, boolean isOccupied, String value){
        this.posX = posX;
        this.posY = posY;
        this.isOccupied = false;
        this.value = value;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String formatStringCase(){
        StringBuilder str = new StringBuilder();
        str.append("+---+");
        str.append(System.getProperty("line.separator"));
        str.append("| " + this.value + " |");
        str.append(System.getProperty("line.separator"));
        str.append("+---+");
        return str.toString();
    }

    public void displayCase(){
        System.out.println(this.formatStringCase());
    }
}
