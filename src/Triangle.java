import java.lang.Math;
import java.util.Random;

public class Triangle
{
    protected Random random;
    protected int sideAB, sideBC, sideAC;
    protected double perimeter, area, angleA, angleB, angleC;
    protected boolean straight_angleA, straight_angleB, straight_angleC;

    public void generate()
    {
        sideAB = random.nextInt(10) + 5;
        sideBC = random.nextInt(10) + 5;
        sideAC = random.nextInt(15) + 5;
    }
    public boolean isCorrect()
    {
        if(sideAB + sideBC > sideAC && sideAC > sideAB && sideAC > sideBC)
            return true;
        else if(sideBC + sideAC > sideAB && sideAB > sideBC && sideAB > sideAC)
            return true;
        else if(sideAB + sideAC > sideBC && sideBC > sideAC && sideBC > sideAB)
            return true;
        else
            return false;
    }
    public void calculate()
    {
        perimeter = sideAB + sideBC + sideAC;
        double half_perimeter = perimeter / 2;

        area = Math.round(Math.sqrt(half_perimeter * (half_perimeter - sideAB) * (half_perimeter - sideBC) * (half_perimeter - sideAC)) * 1000d) / 1000d;

        angleA = (Math.pow(sideBC, 2) + Math.pow(sideAC, 2) - Math.pow(sideAB, 2)) / (2 * sideBC * sideAC);
        angleA = Math.round(Math.toDegrees(Math.acos(angleA)) * 1000d) / 1000d;

        angleB = (Math.pow(sideBC, 2) + Math.pow(sideAB, 2) - Math.pow(sideAC, 2)) / (2 * sideAB * sideBC);
        angleB = Math.round(Math.toDegrees(Math.acos(angleB)) * 1000d) / 1000d;

        angleC = Math.round((180 - (angleA + angleB)) * 1000d) / 1000d;
    }
    public void output(int i)
    {
        System.out.println("Triangle №" + (i + 1) + ": Side AB = " + sideAB + " сm, Side BC = " + sideBC + " cm, Side AC = " + sideAC + " cm");
        System.out.println("Angle A = " + angleA + " deg, Angle B = " + angleB + " deg, Angle C = " + angleC + " deg");
        System.out.println("Area = " + area + " сm^2, Perimeter = " + perimeter + " cm");
        if(straight_angleA || straight_angleB || straight_angleC)
            System.out.println("The triangle is rectangular");
        else
            System.out.println("The triangle is not rectangular");
        System.out.println();
    }
    public static int findMaxArea(Rectangular[] triangles, int size)
    {
        double max_area = 0d;
        int index = 0;

        for(int i = 0; i < size; i++)
        {
            if(triangles[i].area > max_area)
            {
                max_area = triangles[i].area;
                index = i;
            }
        }
        return index;
    }
}