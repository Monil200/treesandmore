package nontrees;

public class Directions {
    int steps[] = {1 ,2 ,2, 2, 1}; // north-west-south-east all the time order is followed
    public boolean didCrossOrigin() {
        int direction[][] = {{0,0}};
        for (int i=0;i <steps.length; i++) {
            if (i%4 == 0) { // north
                direction[0][1] += steps[i];
            } else if (i%4 == 1) { // west
                direction[0][0] += steps[i];
            } else if (i%4 == 2) { // south
                direction[0][1] -= steps[i];
            } else if (i%4 == 3) { // 
                direction[0][0] -= steps[i];
            }
            
            if (direction[0][0] == 0 && direction[0][1] == 0) {
                return true;
            }
        }
        return false;
        
    }
    
    public boolean didCrossOriginV2() {
        int direction[][] = {{0,0}};
        String path = "GLGLGLG";
        String currentDirection = "";
        for (int i=0;i <path.length(); i++) {
            if (currentDirection.equals("")) {
                currentDirection = "N"; // start direction 
            }
            if (path.charAt(i) == 'L') {
                switch(currentDirection) {
                    case "N":
                        currentDirection = "W";
                        break;
                    case "S":
                        currentDirection = "E";
                        break;
                    case "E":
                        currentDirection = "N";
                        break;
                    case "W":
                        currentDirection = "S";
                        break;
                }
            }
            if (path.charAt(i) == 'G') {
                switch(currentDirection) {
                    case "N":
                        direction[0][1] +=1;
                        break;
                    case "S":
                        direction[0][1] -=1;
                        break;
                    case "E":
                        direction[0][0] -=1;
                        break;
                    case "W":
                        direction[0][0] +=1;
                        break;
                }
            }
            System.out.println(currentDirection + " " + direction[0][0] + " "+direction[0][1]);
        }
        if (direction[0][0] == 0 && direction[0][1] == 0) {
            return true;
        }
        return false;
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Directions d = new Directions();
        System.out.println("Our directions did cross origin? " + d.didCrossOrigin());
        System.out.println("Our directions did cross originv2? " + d.didCrossOriginV2());
    }

}
