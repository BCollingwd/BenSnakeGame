package src;

import java.util.ArrayList;

public class SnakeArr {
    ArrayList<SnakePart> snake;
    public SnakeArr(Board aBoard){
        snake = new ArrayList<SnakePart>();
        snake.add(new SnakePart((aBoard.getWidth()/2), (aBoard.getHeight()/2)-1, Direction.UP));
        snake.add(new SnakePart((aBoard.getWidth()/2), (aBoard.getHeight()/2), Direction.UP));
        snake.add(new SnakePart((aBoard.getWidth()/2), (aBoard.getHeight()/2)+1, Direction.UP));
        snake.get(0).setSymbol('H');
        aBoard.setSnake(this, 0);
    }
    public SnakePart getPart(int pos){
        return snake.get(pos);
    }
    public void movePart(int pos){
        snake.get(pos).move();
    }
    public int getLen(){
        return snake.size();
    }
    public void updateDirections(Direction newDir){
        Direction prev = snake.get(0).getDir();
        Direction temp;
        for(int i = 0; i<snake.size(); i++){
            if(i==0 && newDir!=Direction.PREV){
                snake.get(0).setDir(newDir);
            }
            else{
                temp = prev;
                prev = snake.get(i).getDir();
                snake.get(i).setDir(temp);
            }
        }
    }
    public void foodInteractions(Foods food){
        int newY = snake.get(snake.size()-1).getY(), newX = snake.get(snake.size()-1).getX();
        Direction prevDir = snake.get(snake.size()-1).getDir();
        if(food.getFoodType()==FoodTypes.GROWY){
            if(prevDir==Direction.UP){
                newY ++;
            }
            else if(prevDir==Direction.DOWN){
                newY -=1;
            }
            else if(prevDir==Direction.RIGHT){
                newX -=1;
            }
            else if(prevDir==Direction.LEFT){
                newX ++;
            }
            snake.add(new SnakePart(newX, newY, prevDir));
        }
    }
    public boolean checkImpact(Board aBoard){
        // Returns false when snake impacts itself, otherwise does stuff and returns true
        int impactX = snake.get(0).getX();
        int impactY = snake.get(0).getY();
        BoardObject impactObj = aBoard.getObject(impactX, impactY);
        if(impactObj instanceof SnakePart){
            System.out.println("Crashed into self!");
            return true;
        }
        else if(impactObj instanceof Foods){
            this.foodInteractions((Foods)impactObj);
        }
        return false;
    }
}
