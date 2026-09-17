public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", "Camry", "Черный", 50);

        // Попытка напрямую написать myCar.fuelLevel = -500; вызовет ошибку компиляции!
        // Теперь мы вынуждены использовать сеттер:
        System.out.println("--- Пробуем залить некорректное топливо ---");
        myCar.setFuelLevel(150); // Выведет предупреждение и ограничит до 100%
        
        System.out.println("\n--- Проверяем текущее топливо через геттер ---");
        System.out.println("Топливо в баке: " + myCar.getFuelLevel() + "%"); // Выведет: 100%

        System.out.println("\n--- Поездка ---");
        myCar.drive(); // Тратит 10% топлива
        System.out.println("Топливо после поездки: " + myCar.getFuelLevel() + "%"); // Выведет: 90%
    }
}
