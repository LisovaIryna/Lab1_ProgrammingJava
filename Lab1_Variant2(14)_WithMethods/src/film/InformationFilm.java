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

    // Methods for all subtasks to work with a class object Film

    public static Film[] setFilmArr(int k) {
        // Input of an array of films
        Scanner sc = new Scanner(System.in, "UTF-8");
        Film films[] = new Film[k];

        // Input information about films
        System.out.println("Enter information about films: ");
        for (int i=0; i<films.length; i++) {
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
            sc.nextLine();     // очистка буфера
        }
        return films;
    }

    // Output the array
    public static void showArray(Film[] films) {
        for (int i=0; i<films.length; i++)
            System.out.println(films[i].FilmTitle + "\t\t\t" + films[i].GraduationYear + " year" + "\t\t\t" +
                    films[i].Country + "\t\t\t" + films[i].Genre + "\t\t\t" + films[i].DistributionPrice + " $");
    }

    // Information about one film
    public static void showFilm(Film films) {
        System.out.println(films.FilmTitle + "\t\t\t" + films.GraduationYear + " year" + "\t\t\t" +
                films.Country + "\t\t\t" + films.Genre + "\t\t\t" + films.DistributionPrice + " $");
    }

    // The number of film with cost of distribution is more than average
    public static int MaxCostAvg(Film[] films) {
        int result = 0;
        double s = 0;   // total cost
        for (int i = 0; i < films.length; i++)
            s += films[i].DistributionPrice;
        double sr = s / films.length;   // average cost
        System.out.println("Average cost of distribution of films = " + sr);
        for (int i = 0; i < films.length; i++) {
            if (films[i].DistributionPrice > sr)
                result = i;
        }
        return result;
    }

    // Film of the earliest year of release
    public static int minDistributionYear(Film[] films) {
        int nommin = 0;       // element number for the film of the earliest year of release (initial value)
        double min = films[nommin].GraduationYear;     // earliest year (initial value)
        for (int i=0; i<films.length; i++)
            if (films[i].GraduationYear<min) {
                min = films[i].GraduationYear;
                nommin = i;
            }
        return nommin;
    }

    // Sort movies by title
    public static void sortTitle(Film[] films) {
        for (int i=0; i<films.length - 1; i++)
            for (int j=0; j<films.length - 1; j++)
                if (films[j].FilmTitle.compareTo(films[i+1].FilmTitle)>0) {
                    Film f = films[j];   // f - working variable for permutation
                    films[j] = films[j + 1];
                    films[j + 1] = f;
                }
    }

    // Search by title
    public static void findForTitle(Film films[], String title){
        Scanner sc = new Scanner(System.in, "UTF-8");
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
    }

    public static void main(String[] args) {   // main class with Methods
        Scanner sc = new Scanner(System.in, "UTF-8");
        System.out.println("Enter the number of films → ");
        int n = sc.nextInt();   // number of films
        System.out.println(" ");
        Film films[] = setFilmArr(n);   // film information input

        System.out.println("\nCharacteristics of films:");
        showArray(films);   // output of the received information

        // The cost of distribution is more than average
        int nommax = MaxCostAvg(films);
        System.out.println(" ");
        System.out.println("\nFilms with cost of distribution more than average");
        showFilm(films[nommax]);

        // Film of the earliest year of release
        int minyear = minDistributionYear(films);
        System.out.println("\nFilm of the earliest year of release: ");
        showFilm(films[minyear]);

        // Sort movies by title
        sortTitle(films);
        System.out.println("\nSorted list by title:");
        showArray(films);

        // Search by title
        sc.nextLine();   // clear buffer
        System.out.println(" ");
        System.out.println("Enter the name of the film you want to find → ");
        String title = sc.nextLine();
        findForTitle(films, title);
        showArray(films);
    }
}