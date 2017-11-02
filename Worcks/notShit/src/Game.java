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
        point[0] = new Point(point[4].getPointX() - 1, point[4].getPointY());
        point[1] = new Point(point[4].getPointX(), point[4].getPointY() - 1);
        point[2] = new Point(point[4].getPointX(), point[4].getPointY() + 1);
        point[3] = new Point(point[4].getPointX() + 1, point[4].getPointY());
    }
    protected boolean CheckMove(int number)
    {
        boolean check = false;
        for (int i=0; i<point.length; i++)
        {
            if(point[i].getPointX() >= 0 && point[i].getPointY() >= 0 && point[i].getPointX() < arrKnukle[0].length && point[i].getPointY() < arrKnukle[0].length)
            {
                if(number == arrKnukle[point[i].getPointX()][point[i].getPointY()] && arrKnukle[point[i].getPointX()][point[i].getPointY()] != 0)
                {
                    check = true;
                    break;
                }
                else check = false;
            }
            else check = false;
        }
        return check;
    }
    public void Shift(int number)
    {
        if (CheckMove(number))
        {
            for (int i=0; i<point.length; i++)
            {
                if(point[i].getPointX() >= 0 && point[i].getPointY() >= 0 && point[i].getPointX() < arrKnukle[0].length && point[i].getPointY() < arrKnukle[0].length)
                {
                    if(number == arrKnukle[point[i].getPointX()][point[i].getPointY()] && arrKnukle[point[i].getPointX()][point[i].getPointY()] != 0)
                    {
                        int temp = 0;
                        temp = arrKnukle[point[i].getPointX()][point[i].getPointY()];
                        arrKnukle[point[i].getPointX()][point[i].getPointY()] = 0;
                        arrKnukle[point[4].getPointX()][point[4].getPointY()] = temp;
                        point[4].EditCoord(point[i].getPointX(), point[i].getPointY());
                        SerchZeroAgaine();
                        break;
                    }
                }
            }
        }
    }
    public int[][] GetMass()
    {
        return arrKnukle;
    }
}
