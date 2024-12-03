/*4. Написать программу на Java с двумя нитями процессов:
1-й процесс находит слово максимальной длины в строке;
2-й процесс сортирует слова по возрастанию.*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args){
        List<String> textFromPath = new ArrayList<>();
    try {
        textFromPath = FileReader.readFile("text.txt");
    } catch (IOException e) {
        System.out.print("Ошибка" + e.getMessage());
    }
    String text = String.join(" ", textFromPath);

    MaxWordThread maxWord = new MaxWordThread(text);
    SortWordsThread sortWords = new SortWordsThread(text);

    Thread threadMaxWord = new Thread(maxWord);
    Thread threadSortWords = new Thread(sortWords);
    threadMaxWord.start();
    try {
        threadMaxWord.join();
        Thread.sleep(1500);
        System.out.println("Первый процесс завершил свою работу, запускаем следующий");
    } catch (InterruptedException e) {
        System.out.print("Ошибка" + e.getMessage());
    }
    threadSortWords.start();

    }
}
