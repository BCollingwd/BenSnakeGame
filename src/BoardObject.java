package src;
// Will go to snake segment and food classes so both have X and Y coordinates
abstract class BoardObject {
  private int x, y;
  private char symbol;
  public void setCoords(int xPos, int yPos){
    x = xPos;
    y = yPos;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public void setSymbol(char c){
    symbol = c;
  }
  public char getSymbol(){
    return symbol;
  }
}
