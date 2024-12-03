public class SortWordsThread implements Runnable{
    private final String text;

    public SortWordsThread(String text){this.text = text;}

    public static void PrintArray(String[] arr)
    {
        for(String word : arr){
            System.out.print(word + " ");
        }
    }

    @Override
    public void run() {
        System.out.println("разбиваем текст на слова...");
        String[] words = text.split("\\s+");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Готово, cортируем слова по их длине...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < words.length - 1; i++)
        {
            for(int j = 0; j < words.length - 1- i; j++){
                if(words[j].length() > words[j + 1].length()){
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
            PrintArray(words);

    }
}
