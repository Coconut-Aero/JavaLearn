package practice;

import java.util.*;

public class quadSolve {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double[] eqn1 ={a,b,c};
        BooleanWrapper haveRoot = new BooleanWrapper(false);
        double[] root = {0,0};
        int methReturn=solveQuadratic(eqn1,haveRoot,root);
        if (!haveRoot.getValue()){
            System.out.println("This equation have no root");
        }else if(root[0]==root[1]){
            System.out.println("This equation have two same root " + root[0]);
        }else if(methReturn==1){
            System.out.println("No enough arguments.");
        }else {
            System.out.println("This equation have two root " + root[0] + " and " + root[1]);
        }
    }

    public static int solveQuadratic(double[] eqn, BooleanWrapper haveRoot, double[] root) {
        if(eqn.length<3){
            return 1;
        }
        else {
            double a = eqn[0];
            double b = eqn[1];
            double c = eqn[2];
            double delta = b*b-4*a*c;
            if(delta<0){
                haveRoot.setValue(false);
            } else if (delta == 0) {
                haveRoot.setValue(true);
                double up = -b;
                double down = 2*a;
                root[0] = up / down;
                root[1] = up / down;
            }else{
                haveRoot.setValue(true);
                double up1 = -b - Math.sqrt(delta);
                double up2 = -b + Math.sqrt(delta);
                double down = 2*a;
                root[0] = up1 / down;
                root[1] = up2 / down;
            }
            return 0;
        }
    }
}


