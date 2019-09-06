package Delta;

public class MockLoader implements ITextLoad {

    private final String textToLoad;

    public MockLoader(final String textToLoad) { this.textToLoad = textToLoad; }


    @Override
        public String loadText(){
            try {
                for (int i = 0; i <= 5; i++) {
                    Thread.sleep(1_000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return textToLoad;
        }
    }
