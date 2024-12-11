import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    // Клас, що описує автомобіль
    static class Car {
        String brand;       // Марка автомобіля
        String model;       // Модель автомобіля
        int year;           // Рік випуску
        double price;       // Ціна автомобіля
        int mileage;        // Пробіг автомобіля

        // Конструктор для ініціалізації об'єктів
        public Car(String brand, String model, int year, double price, int mileage) {
            this.brand = brand;
            this.model = model;
            this.year = year;
            this.price = price;
            this.mileage = mileage;
        }

        // Перевизначення методу toString() для зручного виведення
        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    ", price=" + price +
                    ", mileage=" + mileage +
                    '}';
        }

        // Перевизначення equals() для порівняння об'єктів
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Car car = (Car) obj;
            return year == car.year &&
                    Double.compare(car.price, price) == 0 &&
                    mileage == car.mileage &&
                    brand.equals(car.brand) &&
                    model.equals(car.model);
        }
    }

    public static void main(String[] args) {
        // Створення масиву автомобілів
        Car[] cars = {
                new Car("Toyota", "Camry", 2020, 25000, 50000),
                new Car("Honda", "Civic", 2018, 20000, 40000),
                new Car("Ford", "Focus", 2019, 22000, 30000),
                new Car("BMW", "X5", 2021, 55000, 20000),
                new Car("Audi", "A4", 2020, 35000, 15000),
                new Car("Honda", "Accord", 2020, 20000, 35000)
        };

        // Сортування за роком випуску (за зростанням), а за ціною (за спаданням)
        Arrays.sort(cars, Comparator
                .comparingInt((Car car) -> car.year)       // Порівняння за роком (зростання)
                .thenComparing((Car car) -> -car.price)); // Порівняння за ціною (спадання)

        // Виведення відсортованого масиву
        System.out.println("Відсортований масив автомобілів:");
        for (Car car : cars) {
            System.out.println(car);
        }

        // Створення об'єкта Scanner для зчитування введених даних
        Scanner scanner = new Scanner(System.in);

        // Введення даних для пошуку
        System.out.println("\nВведіть марку автомобіля:");
        String brandInput = scanner.nextLine();

        System.out.println("Введіть модель автомобіля:");
        String modelInput = scanner.nextLine();

        System.out.println("Введіть рік випуску:");
        int yearInput = scanner.nextInt();

        System.out.println("Введіть ціну:");
        double priceInput = scanner.nextDouble();

        System.out.println("Введіть пробіг:");
        int mileageInput = scanner.nextInt();

        // Створення об'єкта, який шукаємо
        Car target = new Car(brandInput, modelInput, yearInput, priceInput, mileageInput);

        // Пошук ідентичного об'єкта
        boolean found = Arrays.asList(cars).contains(target);
        if (found) {
            System.out.println("Об'єкт знайдено: " + target);
        } else {
            System.out.println("Об'єкт не знайдено.");
        }

        scanner.close();
    }
}
