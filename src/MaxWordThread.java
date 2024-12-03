public class MaxWordThread implements Runnable{
    private String text;
    private String MaxWord = "";

    public MaxWordThread(String text)
    {
        this.text = text;
    }


    @Override
    public void run() {

            System.out.println("разбиваем текст на слова...");
            String words[] = text.split("\\s+");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Готово, ищем самое длинное слово в тексте...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (String word : words){
                if(MaxWord.length() < word.length()){
                    MaxWord = word;
                }
            }
            System.out.println("Готово, самое длинное слово - " + MaxWord + " , кол-во символов: " + MaxWord.length());
        }
    }

