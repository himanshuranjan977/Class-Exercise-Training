public class Movie1 {
    public static void main(String[] args) {
        // Using default constructor
        Movie m1 = new Movie();

        // Using constructor with 3 parameters
        Movie m2 = new Movie("Yash Raj Films", "Karan Johar", 2023);

        // Using constructor with all 5 parameters
        Movie m3 = new Movie("Red Chillies", "Farah Khan", 2022, 150.5, 8.2);

        // Display movie details
        m1.displayMovie();
        m2.displayMovie();
        m3.displayMovie();
    }


}
