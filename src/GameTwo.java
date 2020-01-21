import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameTwo extends Game
{
    private ArrayList<Integer> historyMove = new ArrayList<>();

    public GameTwo(int size)
    {
        super(size);
    }

    public void UpShift(int number)
    {
        if(CheckMove(number))
        {
            historyMove.add(number);
            super.Shift(number);
        }
    }

    public ArrayList GetHistoryMove()
    {
        return historyMove;
    }
}
