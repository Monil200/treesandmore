package treesandmore;


class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle {
    Point leftTop;
    Point rightBottom;
    
    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }
    
    public boolean isOverlapping(Rectangle other) {
        if (this.leftTop.x >= other.rightBottom.x ||
            this.rightBottom.x <= other.leftTop.x ||
            this.leftTop.y <= other.rightBottom.y ||
            this.rightBottom.y >= other.leftTop.y) {
            return false;
        } else {
            return true;
        }
    }
}
public class RectanglesOverlap {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Point l1 = new Point(0,10);
//        Point r1 = new Point(10,0);
//        
//        Point l2 = new Point(-10,0);
//        Point r2 = new Point(0,-10);
//        
//        Rectangle one = new Rectangle(l1,r1);
//        Rectangle other = new Rectangle(l2,r2);
        
        Point l1 = new Point(0, 10); 
        Point r1 = new Point(10, 0); 
        Point l2 = new Point(5, 5); 
        Point r2 = new Point(15, 0); 
        
        Rectangle one = new Rectangle(l1, r1); 
        Rectangle other = new Rectangle(l2, r2);

        
        System.out.println(one.isOverlapping(other));
    }

}
