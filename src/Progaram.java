import java.util.Scanner;

public class Progaram
{
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       System.out.print("Введите размер поля: ");

       Game game = new Game(input.nextInt());
       System.out.println("Игра НАЧАЛАСЬ");
       do
       {
           Print.PrintMass(game.GetMass());
           System.out.print("Что передвигать: ");
           game.Shift(input.nextInt());
       }while(true);
    }
}
