package firma;
import java.util.Scanner;

/*класс в виде структуры с полями
fam, im, otch, doljnost, oklad
 */
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}

//главный класс
public class Firma{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in, "UTF-8");

        System.out.println("Введите количество сотрудников => ");
        int kol = sc.nextInt();
        sc.nextLine();   //очистка буфера после ввода числа

        Sotrudnik []sotr = new Sotrudnik[kol];   //получена ссылка на массив сотрудников

        System.out.println("Введите информацию о каждом сотруднике:");
        for (int i=0; i<sotr.length; i++){
            sotr[i] = new Sotrudnik();   //получена ссылка на i-тый элемент

            //Присвоение значений полям
            System.out.print("Введите фамилию " + (i+1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введите его оклад => ");
            sotr[i].oklad = sc.nextInt();

            sc.nextLine();
            sc.nextLine();   //очистка буфера
        }   //end for

        //Вывод информации о сотрудниках
        System.out.println( "\n Сотрудники фирмы: \n Фамилия \t Имя \t\t Отчество \t\t\t Должность \t\t Оклад");
        for (Sotrudnik s: sotr)
        {
            System.out.println(" " + s.fam + "\t\t" + s.im + "\t\t" + s.otch + "\t\t\t" + s.doljnost + "\t\t" + s.oklad);
        }
    }
}