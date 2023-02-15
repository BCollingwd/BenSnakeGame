package src;

public class MoveableObject extends BoardObject{
    private Direction dir;
    public void setDir(Direction d){
        dir = d;
    }
    public Direction getDir(){
        return dir;
    }
    public void move(){ // moves object for internal positions
        if(this.getDir()==Direction.RIGHT){
            this.setCoords(this.getX()+1, this.getY());
        }
        else if(this.getDir()==Direction.UP){
            this.setCoords(this.getX(), this.getY()-1);
        }
        else if(this.getDir()==Direction.DOWN){
            this.setCoords(this.getX(), this.getY()+1);
        }
        else if(this.getDir()==Direction.LEFT){
            this.setCoords(this.getX()-1, this.getY());
        }
    }
}
