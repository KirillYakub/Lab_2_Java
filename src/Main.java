import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random random = new Random();
        int size = random.nextInt(20) + 10;
        Rectangular[] triangles = new Rectangular[size];

        for(int i = 0; i < size; i++)
        {
            triangles[i] = new Rectangular();

            do
            {
                triangles[i].generate();
            } while(!triangles[i].isCorrect());

            triangles[i].calculate();
            triangles[i].rectangular();
            triangles[i].output(i);
        }
        System.out.println("Triangle with the max area has an index = " + (Triangle.findMaxArea(triangles, size) + 1));
        Rectangular.findMinHypotenuse(triangles, size);
    }
}