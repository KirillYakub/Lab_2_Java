import java.lang.Math;

public class Rectangular extends Triangle
{
    public static final double epsilon = 1E-2;

    public void isRectangular()
    {
        if(Math.abs(90d - angleA) < epsilon)
        {
            straight_angleA = true;
            straight_angleB = straight_angleC = false;
        }
        else if(Math.abs(90d - angleB) < epsilon)
        {
            straight_angleB = true;
            straight_angleA = straight_angleC = false;
        }
        else if(Math.abs(90d - angleC) < epsilon)
        {
            straight_angleC = true;
            straight_angleA = straight_angleB = false;
        }
        else
            straight_angleA = straight_angleB = straight_angleC = false;
    }
    public static void isMinHypotenuse(Rectangular[] triangles, int size)
    {
        int count = 0, index = 0;
        double min_hypotenuse = 50d;

        for(int i = 0; i < size; i++)
        {
            if(triangles[i].straight_angleA && triangles[i].sideA < min_hypotenuse)
            {
                min_hypotenuse = triangles[i].sideA;
                index = i;
                count++;
                continue;
            }
            if(triangles[i].straight_angleB && triangles[i].sideB < min_hypotenuse)
            {
                min_hypotenuse = triangles[i].sideB;
                index = i;
                count++;
                continue;
            }
            if(triangles[i].straight_angleC && triangles[i].sideC < min_hypotenuse)
            {
                min_hypotenuse = triangles[i].sideC;
                index = i;
                count++;
                continue;
            }
        }
        if(count == 0)
            System.out.println("No rectangular triangles to search triangle with min hypotenuse");
        else
            System.out.println("Rectangular triangle with min hypotenuse has an index = " + (index + 1));
    }
}