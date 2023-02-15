package src;
public class Board {
    private int width, height;
    private BoardObject[][] twoDBoard;
    public Board(int xSize, int ySize){
        width = xSize;
        height = ySize;
        twoDBoard = new BoardObject[height][width];
    }
    public int getWidth(){ return width; }
    public int getHeight(){ return height; }

    public String toString(){
        return "This is a board of width: " + width +" and height: " + height + ".";
    }
    public void setObject(int x, int y, BoardObject obj){
        if(!(x>=0 && x<width && y>=0 && y<height)){
            System.out.println("Trying to access outside of board");
            System.exit(1);
        }
        twoDBoard[y][x] = obj;
    }
    public BoardObject getObject(int x, int y){
        if(!(x>=0 && x<width && y>=0 && y<height)){
            System.out.println("Trying to access outside of board");
            System.exit(1);
        }
        return twoDBoard[y][x];
    }
    public void randomFood(){
        int randX = (int)(Math.random() * width); // rand int between 0 and width
        int randY = (int)(Math.random() * height); // rand num between 0 and height
        while(this.getObject(randX, randY)!=null){
            randX = (int)(Math.random() * width);
            randY = (int)(Math.random() * height);
        }
        double randFood = Math.random(); // random for food type
        if(randFood<0.75){
            this.setObject(randX, randY, new Foods(randX, randY, FoodTypes.GROWY));
        }
        else{
            this.setObject(randX, randY, new Foods(randX, randY, FoodTypes.SHRINKY));
        }
    }
    public void setSnake(SnakeArr snake, int start){
        for(int i = start; i<snake.getLen(); i++){
            this.setObject(snake.getPart(i).getX(), snake.getPart(i).getY(), snake.getPart(i));
        }
    }
    public void printBoard(){
        for(int i = 0; i<width+2; i++){
            System.out.print('-');
        };
        System.out.print("\n");
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++){
                if(i == 0){
                    System.out.print('|');
                }
                if(this.getObject(i,j)==null){
                    System.out.print('.');
                }
                else{
                    System.out.print(this.getObject(i,j).getSymbol());
                }
            }
            System.out.print('|');
            System.out.print("\n");
        }
        for(int i = 0; i<width+2; i++){
            System.out.print('-');
        };
        System.out.print("\n");
    }
}
