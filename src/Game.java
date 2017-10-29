import java.util.Random;


public class Game
{
    private int arrKnukle[][];
    private Point point[];
    public Game(int size)
    {
        arrKnukle = new int[size][size];
        point = new Point[5];
        GenerationField();
        RandominationField();
        SerchZero();
    }
    private void GenerationField()
    {
        int temp = 0;
        for (int i = 0; i < arrKnukle[0].length; i++)
        {
            for (int j = 0; j < arrKnukle[1].length; j++)
            {
                arrKnukle[i][j] = temp;
                temp++;
            }
        }
    }
    private void RandominationField()
    {
        Random gen = new Random();
        int temp = 0;
        for (int i = 0; i < arrKnukle[0].length; i++)
        {
            for (int j = 0; j < arrKnukle[1].length; j++)
            {
                int iX = gen.nextInt(arrKnukle[1].length);
                int jY = gen.nextInt(arrKnukle[1].length);
                temp = arrKnukle[iX][jY];
                arrKnukle[iX][jY] = arrKnukle[i][j];
                arrKnukle[i][j] = temp;
            }
        }
    }
    private void SerchZero()
    {
        for (int i = 0; i < arrKnukle[0].length; i++)
        {
            for (int j = 0; j < arrKnukle[1].length; j++)
            {
                if (arrKnukle[i][j] == 0) {
                    if(j + 1 <= arrKnukle[1].length)
                        point[0] = new Point(i - 1, j);
                        point[1] = new Point(i, j - 1);
                        point[2] = new Point(i, j + 1);
                        point[3] = new Point(i + 1, j);
                        point[4] = new Point(i,j);
                }
            }
        }
    }
    private void SerchZeroAgaine()
    {
        point[0] = new Point(point[4].X - 1, point[4].Y);
        point[1] = new Point(point[4].X, point[4].Y - 1);
        point[2] = new Point(point[4].X, point[4].Y + 1);
        point[3] = new Point(point[4].X + 1, point[4].Y);
    }
    public void Shift(int number)
    {
        for (int i=0; i<point.length; i++)
        {
            if(point[i].X >= 0 && point[i].Y >= 0 && point[i].X < arrKnukle[0].length && point[i].Y < arrKnukle[0].length)
            {
                if(number == arrKnukle[point[i].X][point[i].Y] && arrKnukle[point[i].X][point[i].Y] != 0)
                {
                    int temp = 0;
                    temp = arrKnukle[point[i].X][point[i].Y];
                    arrKnukle[point[i].X][point[i].Y] = 0;
                    arrKnukle[point[4].X][point[4].Y] = temp;
                    point[4].EditCoord(point[i].X, point[i].Y);
                    SerchZeroAgaine();
                    break;
                }
            }
        }
    }
    public int[][] GetMass()
    {
        return arrKnukle;
    }
}
