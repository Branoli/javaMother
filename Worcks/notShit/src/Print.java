import java.util.ArrayList;

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
    public static void PrintHistory(ArrayList<Integer> historyMove)
    {
        if (historyMove.size() != 0)
        {
            for (int i = 0; i < historyMove.size(); i++)
            {
                System.out.print("0 -> " + historyMove.get(i) + "|");
            }
            System.out.println();
        }
    }
}
