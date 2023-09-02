import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyStore {
    private PriorityQueue<Toy> toyQueue;

    public ToyStore(String[] toyData) {
        toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.weight, t1.weight));
        for (String data : toyData) {
            String[] parts = data.split(" ");
            int id = Integer.parseInt(parts[0]);
            int weight = Integer.parseInt(parts[1]);
            // Объединяем оставшиеся части массива parts в строку для названия
            String name = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));
            toyQueue.add(new Toy(id, name, weight));
        }
    }

    public int getRandomToy() {
        Random rand = new Random();
        int randomNum = rand.nextInt(100) + 1;
        if (randomNum <= 20) {
            return 1;
        } else if (randomNum <= 40) {
            return 2;
        } else {
            return 3;
        }
    }

    public void writeResultsToFile(String filename, int numResults) {
        try (PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            for (int i = 0; i < numResults; i++) {
                int selectedToy = getRandomToy();
                Toy toy = null;
                for (Toy t : toyQueue) {
                    if (t.id == selectedToy) {
                        toy = t;
                        break;
                    }
                }
                if (toy != null) {
                    writer.println("Selected Toy: " + toy.id + " - " + toy.name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
