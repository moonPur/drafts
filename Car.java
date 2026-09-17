public class Car {
    // 1. Меняем public на private. Теперь эти данные НЕЛЬЗЯ изменить напрямую снаружи класса!
    private String brand;
    private String model;
    private String color;
    private int fuelLevel; // Добавим новое поле для наглядности (уровень топлива в %)

    public Car(String brand, String model, String color, int fuelLevel) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        setFuelLevel(fuelLevel); // Используем сеттер для проверки даже при создании
    }

    // 2. ГЕТТЕРЫ (Getters) — методы, которые безопасно отдают (читают) данные
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    // 3. СЕТТЕРЫ (Setters) — методы, которые проверяют данные перед изменением
    // Защищаем уровень топлива от нереалистичных значений
    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel < 0) {
            this.fuelLevel = 0; // Топливо не может быть отрицательным
            System.out.println("⚠️ Ошибка: Уровень топлива не может быть меньше 0! Установлено: 0%");
        } else if (fuelLevel > 100) {
            this.fuelLevel = 100; // Бак не резиновый
            System.out.println("⚠️ Ошибка: Бак переполнен! Установлен максимум: 100%");
        } else {
            this.fuelLevel = fuelLevel; // Если всё ок — сохраняем
        }
    }

    // Пример метода, который сам меняет приватные данные по внутренней логике
    public void drive() {
        if (this.fuelLevel > 0) {
            System.out.println("🚗 " + brand + " едет...");
            this.fuelLevel -= 10; // Тратим топливо напрямую внутри класса
        } else {
            System.out.println("❌ Не удается поехать: бак пуст!");
        }
    }
}
