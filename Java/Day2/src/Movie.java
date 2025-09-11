public class Movie {
    // Attributes
    String producer;
    String director;
    int year;
    double budget;
    double rating;

    // ⿡ Default Constructor
    public Movie() {
        producer = "Unknown";
        director = "Unknown";
        year = 0;
        budget = 0.0;
        rating = 0.0;
    }
    // ⿢ Constructor with 3 parameters
    public Movie(String producer, String director, int year) {
        this.producer = producer;
        this.director = director;
        this.year = year;
        this.budget = 0.0;
        this.rating = 0.0;
    }

    // ⿣ Constructor with all 5 parameters
    public Movie(String producer, String director, int year, double budget, double rating) {
        this.producer = producer;
        this.director = director;
        this.year = year;
        this.budget = budget;
        this.rating = rating;
    }

    // Method to display movie details
    public void displayMovie() {
        System.out.println("Producer: " + producer);
        System.out.println("Director: " + director);
        System.out.println("Year: " + year);
        System.out.println("Budget: " + budget + " Cr");
        System.out.println("Rating: " + rating + " / 10");
        System.out.println("---------------------------------");
    }
}
