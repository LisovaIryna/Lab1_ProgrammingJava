package film;
import java.util.Scanner;

class Film{
    String FilmTitle;
    int GraduationYear;
    String Country;
    String Genre;
    double DistributionPrice;
}

public class InformationFilm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "UTF-8");

        // Input information about films
        System.out.println("Enter the number of films → ");
        int n = sc.nextInt();   // number of films
        Film films[] = new Film[n];
        System.out.println(" ");
        System.out.println("Enter information about films: ");
        for (int i=0; i<films.length; i++) {
            sc.nextLine();     // очистка буфера
            films[i] = new Film();
            System.out.println(" ");
            System.out.print("The title of the " + (i + 1) + " film → ");
            films[i].FilmTitle = sc.nextLine();
            System.out.print("The graduation year of the " + (i + 1) + " film → ");
            films[i].GraduationYear = sc.nextInt();
            sc.nextLine();     // очистка буфера
            System.out.print("The country of the " + (i + 1) + " film → ");
            films[i].Country = sc.nextLine();
            System.out.print("The genre of the " + (i + 1) + " film → ");
            films[i].Genre = sc.nextLine();
            System.out.print("The distribution price of the " + (i + 1) + " film → ");
            films[i].DistributionPrice = sc.nextDouble();
        }

        // Output of the received information
        System.out.println("\nCharacteristics of films:");
        for (int i=0; i<films.length; i++)
            System.out.println(films[i].FilmTitle + "\t\t\t" + films[i].GraduationYear + " year" + "\t\t\t" +
                               films[i].Country + "\t\t\t" + films[i].Genre + "\t\t\t" + films[i].DistributionPrice + " $");

        // The cost of distribution is more than average
        double s = 0;   // total cost
        for (int i=0; i<films.length; i++)
            s += films[i].DistributionPrice;
        double sr = s/films.length;   // average cost
        System.out.println(" ");
        System.out.println("Average cost of distribution of films = " + sr);
        System.out.println("\nFilms with cost of distribution more than average");
        for (int i=0; i<films.length; i++) {
            if (films[i].DistributionPrice > sr)
                System.out.println(films[i].FilmTitle + "\t\t\t" + films[i].DistributionPrice + " $");
        }

        // Film of the earliest year of release
        int nommin = 0;       // element number for the film of the earliest year of release (initial value)
        double min = films[nommin].GraduationYear;     // earliest year (initial value)
        for (int i=0; i<films.length; i++)
            if (films[i].GraduationYear<min) {
                min = films[i].GraduationYear;
                nommin = i;
            }
        System.out.println("\nFilm of the earliest year of release: ");
        System.out.println(films[nommin].FilmTitle + "\t\t\t" + films[nommin].GraduationYear + " year" + "\t\t\t" +
                           films[nommin].Country + "\t\t\t" + films[nommin].Genre + "\t\t\t" + films[nommin].DistributionPrice + " $");

        // Sort movies by title
        for (int i=0; i<films.length - 1; i++)
            for (int j=0; j<films.length - 1; j++)
                if (films[j].FilmTitle.compareTo(films[i+1].FilmTitle)>0) {
                    Film f = films[j];   // f - working variable for permutation
                    films[j] = films[j + 1];
                    films[j + 1] = f;
                }
        System.out.println("\nSorted list by title:");
        for (int i=0; i<films.length; i++) {
            System.out.println(films[i].FilmTitle + "\t\t\t" + films[i].GraduationYear + " year" + "\t\t\t" +
                               films[i].Country + "\t\t\t" + films[i].Genre + "\t\t\t" + films[i].DistributionPrice + " $");
        }

        // Search by title
        sc.nextLine();   // clear buffer
        System.out.println(" ");
        System.out.println("Enter the name of the film you want to find → ");
        String title = sc.nextLine();
        int nom = -1;   // -1 - the movie with the given title is missing
        for (int i=0; i<films.length; i++)
            if (title.equalsIgnoreCase(films[i].FilmTitle))
                nom = i;
        if (nom!=-1) {
            System.out.println("Such a film is on the list. It " + films[nom].FilmTitle + "\t" + films[nom].GraduationYear + " year" + "\t" +
                                films[nom].Country + "\t" + films[nom].Genre + "\t" + films[nom].DistributionPrice + " $");
            System.out.println("Enter what needs to be fixed (FilmTitle, GraduationYear, Country, Genre, DistributionPrice) → ");
            String fix = sc.nextLine();
            if (fix.equalsIgnoreCase("FilmTitle")){
                System.out.print("The title of the " + (nom + 1) + " film → ");
                films[nom].FilmTitle = sc.nextLine();
            }
            else if (fix.equalsIgnoreCase("GraduationYear")){
                System.out.print("The graduation year of the " + (nom + 1) + " film → ");
                films[nom].GraduationYear = sc.nextInt();
            }
            else if (fix.equalsIgnoreCase("Country")){
                System.out.print("The country of the " + (nom + 1) + " film → ");
                films[nom].Country = sc.nextLine();
            }
            else if (fix.equalsIgnoreCase("Genre")){
                System.out.print("The genre of the " + (nom + 1) + " film → ");
                films[nom].Genre = sc.nextLine();
            }
            else if (fix.equalsIgnoreCase("DistributionPrice")){
                System.out.print("The distribution price of the " + (nom + 1) + " film → ");
                films[nom].DistributionPrice = sc.nextDouble();
            }
            else
                System.out.print("This field does not exist");
        }
        else
            System.out.println("Such a film is not on the list.");

        // Output of the fixed information
        System.out.println("\nFixed characteristics of films:");
        for (int i=0; i<films.length; i++)
            System.out.println(films[i].FilmTitle + "\t" + films[i].GraduationYear + " year" + "\t" +
                    films[i].Country + "\t" + films[i].Genre + "\t" + films[i].DistributionPrice + " $");
    }
}