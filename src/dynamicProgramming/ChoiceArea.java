package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ChoiceArea {
    public static class Area{
        int x;
        int y;
        Area(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static class Power{
        int a;
        int b;
        Power(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Power power = (Power) o;

            if (a != power.a) return false;
            return b == power.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
    enum Choice{
        A,B,C
    }
    static Area A;
    static Area B;
    static Area C;
    static Map<Power,Integer> dp =  new HashMap<>();
    public static int getMaxSurvivalTime(Power p, Choice choice ){
        if(p.a <=0 || p.b <= 0)
            return 0;
        if(dp.containsKey(p)){
            return dp.get(p);
        }
        int areaA = Integer.MIN_VALUE;
        int areaB = Integer.MIN_VALUE;
        int areaC = Integer.MIN_VALUE;
        if(!choice.equals(Choice.A)) {
            Power newPower = new Power(p.a + A.x, p.b + A.y);
            if(dp.containsKey(newPower))
                areaA = dp.get(newPower);
            else
                areaA = getMaxSurvivalTime(newPower, Choice.A);
        }
        if(!choice.equals(Choice.B)) {
            Power newPower = new Power(p.a + B.x, p.b + B.y);
            if(dp.containsKey(newPower))
                areaB = dp.get(newPower);
            else
                areaB = getMaxSurvivalTime(newPower, Choice.B);
        }
        if(!choice.equals(Choice.C)) {
            Power newPower = new Power(p.a + C.x, p.b + C.y);
            if(dp.containsKey(newPower))
                areaC = dp.get(newPower);
            else
                areaC = getMaxSurvivalTime(newPower, Choice.C);
        }
        int tempResult = 1 + Math.max( areaA, Math.max(areaB, areaC));
        dp.put(p, tempResult);
        return tempResult;
    }

    public static int getMaxTime(Power p){
        if (p.a <= 0 || p.b <= 0)
            return 0;

        return Math.max(getMaxSurvivalTime(new Power(p.a + A.x, p.b+A.y), Choice.A),
                Math.max(getMaxSurvivalTime(new Power(p.a + B.x, p.b + B.y), Choice.B),
                        getMaxSurvivalTime(new Power(p.a + C.x, p.b + C.y), Choice.C)));
    }
    public static void main(String [] args){
        A =  new Area(3, 2);
        B =  new Area(-5, -10);
        C =  new Area(-20, 5);

        int a = 20;
        int b = 8;
        Power p = new Power(a,b);
         System.out.println(getMaxTime(p));
    }
}
