//package src;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//public class MyListener implements KeyListener {
//    public static Direction input;
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public static void keyPressed(KeyEvent e) {
//        int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT) {
//            changeDir(input);
//        }
//
//        if (key == KeyEvent.VK_RIGHT) {
//            return Direction.RIGHT;
//        }
//
//        if (key == KeyEvent.VK_UP) {
//            return Direction.UP;
//        }
//
//        if (key == KeyEvent.VK_DOWN) {
//            return Direction.DOWN;
//        }
//        return Direction.PREV;
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    private static void changeDir(Direction dir){
//
//    }
//}