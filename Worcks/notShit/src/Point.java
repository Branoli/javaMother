public class Point
{
    private int X;
    private int Y;

    public Point(int x, int y)
    {
        X = x;
        Y = y;
    }
    public void EditCoord(int x, int y)
    {
        X = x;
        Y = y;
    }
    public int getPointX()
    {
        return X;
    }
    public int getPointY()
    {
        return Y;
    }
}
