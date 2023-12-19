public class Main {

    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
            } else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);

            } else if (parts[0].equals("Coffee")) {
                breakfast[itemsSoFar] = new Coffee(parts[1]);
            }
            itemsSoFar++;
        }

        countFood(breakfast, breakfast[1]);
        countFood(breakfast, breakfast[0]);
        countFood(breakfast, breakfast[2]);
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
                System.out.println();

            } else {
                break;
            }
        }
        System.out.println("Всего хорошего!");
    }

    public static void countFood(Food[] foods, Food food) {
        int count = 0;
        for (Food f : foods) {
            if (f != null && f.equals(food)) {
                count++;
            }

        }
        System.out.println("There are " + count + " products of type " + food.getClass().getSimpleName() + " in the breakfast");
    }
}