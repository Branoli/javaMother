import java.util.Scanner;

public class Progaram
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       //System.out.print("Введите размер поля: ");

       Game game = new Game(3);
       GameTwo gameTwo = new GameTwo(3);
       System.out.println("Игра НАЧАЛАСЬ");
       do
       {
           Print.PrintMass(gameTwo.GetMass());
           System.out.print("Что передвигать: ");
           gameTwo.UpShift(input.nextInt());
           Print.PrintHistory(gameTwo.GetHistoryMove());
       }while(true);
    }
}
