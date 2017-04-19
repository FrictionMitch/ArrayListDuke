import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    int maxCount = 0;
    int indexOfMax = 0;
    String maxWord = "";

    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }

    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();

        for(String s : resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value + 1);
            }
        }
    }

    public int findMax() {
        int max = 0;
        int index = 0;
        for(int highest : myFreqs) {
            if(highest > max) {
                max = highest;
                indexOfMax = myFreqs.get(highest);
            }
        }
        maxCount = max;
        return max;
    }

    public void test(){
        findUnique();
        System.out.println("# of unique words: " + myWords.size());
        findMax();

        for(int i = 0; i < myWords.size(); i++) {
            System.out.println(myFreqs.get(i) + "\t" + myWords.get(i));

        }

            System.out.println("Location is: " + myFreqs.indexOf(findMax()));
            System.out.println("The word that occurs most is: " + "\"" + myWords.get(indexOfMax - 1) + "\" with a count of: " +
            findMax());
    }
}
