public class Main {
    public static void main(String[] args) {
        String[] toyData = {
                "1 2 конструктор",
                "2 2 робот",
                "3 6 кукла"
        };

        ToyStore toyStore = new ToyStore(toyData);
        toyStore.writeResultsToFile("toy_results.txt", 10);
        System.out.println("Results written to toy_results.txt");
    }
}
