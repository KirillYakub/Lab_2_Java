import java.lang.Math;

public class Triangle
{
    public double sideA, sideB, sideC, perimeter, area, angleA, angleB, angleC;
    public boolean straight_angleA, straight_angleB, straight_angleC;

    public boolean isCorrect()
    {
        if(sideA + sideB > sideC || sideB + sideC > sideA || sideA + sideC > sideB)
            return true;
        else
            return false;
    }
    public void isCalculate()
    {
        perimeter = sideA + sideB + sideC;
        double half_perimeter = perimeter / 2;

        area = Math.round(Math.abs(Math.sqrt(half_perimeter * (half_perimeter - sideA) * (half_perimeter - sideB) * (half_perimeter - sideC))) * 1000d) / 1000d + 1;
        angleA = Math.round(Math.abs((Math.pow(sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideB, 2)) / (2 * sideA * sideC) * 180 / Math.PI) * 1000d) / 1000d;
        angleB = Math.round(Math.abs((Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (2 * sideA * sideB) * 180 / Math.PI) * 1000d) / 1000d;
        angleC = Math.round((180 - (angleA + angleB)) * 1000d) / 1000d;
    }
    public void isOutput(int i)
    {
        System.out.println("Triangle №" + (i + 1) + ": Side A = " + sideA + " сm, Side B = " + sideB + " cm, Side C = " + sideC + " cm");
        System.out.println("Angle A = " + angleA + " deg, Angle B = " + angleB + " deg, Angle C = " + angleC + " deg");
        System.out.println("Area = " + area + " сm^2, Perimeter = " + perimeter + " cm");
        if(straight_angleA || straight_angleB || straight_angleC)
            System.out.println("The triangle is rectangular");
        else
            System.out.println("The triangle is not rectangular");
        System.out.println();
    }
    public static int isMaxArea(Rectangular[] triangles, int size)
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