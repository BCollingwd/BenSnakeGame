package src;
public class Foods extends BoardObject{
    private FoodTypes foodType;
    public Foods(int xPos, int yPos, FoodTypes type) {
        this.setCoords(xPos, yPos);
        foodType = type;
        if(type == FoodTypes.GROWY) {
            this.setSymbol('G');
        }
        if(type == FoodTypes.SHRINKY) {
            this.setSymbol('L');
        }
    }
    public FoodTypes getFoodType(){
        return foodType;
    }

    public String toString(){
        return "This is a food of type: " + this.getFoodType();
    }
}
