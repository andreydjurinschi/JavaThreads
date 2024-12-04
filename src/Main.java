import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Число доступных процессоров: " + Runtime.getRuntime().availableProcessors());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Число активных потоков в JVM: " + Thread.activeCount());
        String choice;
        do {
            String text;
            while (true) {
                System.out.println("Введите текст: ");
                text = scanner.nextLine().trim();
                if (!text.isEmpty()) {
                    System.out.println("Текст не должен быть пустым. Попробуйте ещё раз.");
                    break;
                }
            }

            System.out.println("\nИсходный текст: " + text);

            MaxWordThread maxWord = new MaxWordThread(text);
            SortWordsThread sortWords = new SortWordsThread(text);

            Thread threadMaxWord = new Thread(maxWord);
            Thread threadSortWords = new Thread(sortWords);

            threadMaxWord.start();
            try {
                threadMaxWord.join();
                Thread.sleep(1500);
                System.out.println("Первый процесс завершил свою работу, запускаем следующий.");
            } catch (InterruptedException e) {
                System.out.print("Ошибка: " + e.getMessage());
            }

            threadSortWords.start();
            try {
                threadSortWords.join(); // Дождаться завершения 2-го потока
                System.out.println("\nВторой процесс завершил свою работу.");
            } catch (InterruptedException e) {
                System.out.print("Ошибка: " + e.getMessage());
            }
            System.out.println("\nХотите протестировать ещё раз? (да/нет): ");
            choice = scanner.nextLine().trim().toLowerCase();
        } while (choice.equals("да"));
    }
}
