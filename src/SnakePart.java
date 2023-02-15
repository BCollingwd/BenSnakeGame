package src;
public class SnakePart extends MoveableObject{
    public SnakePart(int xPos, int yPos, Direction dir){
        this.setCoords(xPos, yPos);
        this.setSymbol('S');
        this.setDir(dir);
    }
    public String toString(){
        return "This is a snake part";
    }
}
