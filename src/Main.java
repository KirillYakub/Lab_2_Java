import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int size = random.nextInt(10) + 10;
        Rectangular[] triangles = new Rectangular[size];

        for(int i = 0; i < size; i++)
        {
            triangles[i] = new Rectangular();
            do
            {
                triangles[i].sideA = random.nextInt(15) + 5;
                triangles[i].sideB = random.nextInt(15) + 5;
                triangles[i].sideC = random.nextInt(15) + 5;
            }while(!triangles[i].isCorrect());

            triangles[i].isCalculate();
            triangles[i].isRectangular();
            triangles[i].isOutput(i);
        }
        System.out.println("Triangle with the max area has an index = " + (Triangle.isMaxArea(triangles, size) + 1));
        Rectangular.isMinHypotenuse(triangles, size);
    }
}