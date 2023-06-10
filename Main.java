
public class Main {
    public static void main(String[] args) {
        // Создание mapa
        Mapa<Integer, Integer> mapa = new Mapa<>();
        int nums = 10;
        for (int i = 0; i < nums; i++) {
            mapa.put(i + 10, i);
        }

        System.out.println();
        System.out.println("--- Исходная Hash-таблица ---");
        System.out.println(mapa.toString());

        System.out.println("--- Получение значения по ключу ---");
        int key = 10;
        int newValue = 120;
        System.out.println("Getting value for key = " + key);
        System.out.println("value = " + mapa.get(key));

        System.out.println("--- Замена значения ---");
        mapa.replace(key, newValue);
        System.out.println("Getting value for key = " + key);
        System.out.println("value = " + mapa.get(key));
        System.out.println("--- Hash-таблица после замены значения ---");
        System.out.println(mapa.toString());

        System.out.println("--- Размер Hash-таблицы ---");
        System.out.println("Size of mapa: " + mapa.getSize());

        System.out.println("--- Проверка наличия ключа ---");
        key = 10;
        System.out.println("Mapa contains key = " + key + "? " + mapa.containsKey(key));
        key = 20;
        System.out.println("Mapa contains key = " + key + "? " + mapa.containsKey(key));

        System.out.println("--- Проверка наличия значения ---");
        int value = 0;
        System.out.println("Mapa contains value = " + value + "? " + mapa.containsValue(value));
        value = 120;
        System.out.println("Mapa contains value = " + value + "? " + mapa.containsValue(value));
        System.out.println();

    }
}
