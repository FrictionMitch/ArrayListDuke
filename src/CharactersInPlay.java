import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCounts;

    public CharactersInPlay() {
        characterNames = new ArrayList<String>();
        characterCounts = new ArrayList<Integer>();
    }

    public void update(String person) {
        person = person.toLowerCase();
        int index = characterNames.indexOf(person);
        if(index == -1) {
            characterNames.add(person);
            characterCounts.add(1);
        } else {
            int value = characterCounts.get(index);
            characterCounts.set(index, value + 1);
        }
    }

    public void findAllCharacters() {
        characterNames.clear();
        characterCounts.clear();

        FileResource resource = new FileResource();
        for(String s : resource.lines()) {
            int index = s.indexOf(".");
            if(index != -1) {
                String name = s.substring(0, index);
                name = name.trim();
                update(name);
            }
        }
    }

    public void charactersWithNumParts(int num1, int num2) {
//        findAllCharacters();
        for(int i =0; i<characterNames.size(); i++){
            int numberOfParts = i;
            if(characterCounts.get(numberOfParts) >= num1 && characterCounts.get(numberOfParts) <= num2) {
                System.out.println(characterNames.get(numberOfParts).toUpperCase() + " has " +
                        characterCounts.get(numberOfParts) + " parts.");
            }
        }
    }

    public void tester() {
        findAllCharacters();
        System.out.println("Number of Characters are: " + characterNames.size());

        for(int i=0; i < characterNames.size(); i++) {
            if(characterCounts.get(i) > 1) {
                System.out.println(characterNames.get(i).toUpperCase() + " " + characterCounts.get(i));
            }
        }
        charactersWithNumParts(50, 200);
    }
}
