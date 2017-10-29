public class Print
{
    public static void PrintMass(int[][] mas)
    {
        for (int i = 0; i < mas[0].length; i++)
        {
            for (int j = 0; j < mas[1].length; j++)
            {
                System.out.print(mas[i][j]);
            }
            System.out.println();
        }
    }
}
