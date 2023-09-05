
import java.util.Random;
/**
 * This class creates a CharBag object that has 3 attributes.
 * It creates an integer array that directly correlates to numbers in the alphabet.
 * It also has additional 2 integer variables to keep
 * track of the number of additions and subtractions
 */
public class CharBag {
    private int[] array;
    private int numAdds = 0;
    private int numSubs = 0;
    public CharBag(){
        array = new int[27];
    }

    /**
     * This function adds a letter or a stop element to a integer list that retains its size
     * @param element Determines which element's counts increases
     */
    public void add(char element){
        if(Character.isUpperCase(element)){
            element = Character.toLowerCase(element);
        }
        boolean isAdded = false;
        int elementNumber = (int) element;
        for(int i = 97; i <= 122; i++){
            if(elementNumber == i){
                array[i - 97] += 1;
                isAdded = true;
            }
        }
        if(!isAdded){
            array[26] += 1;
        }
        numAdds++;
    }

    /**
     * This function removes a letter or a stop element to a integer list that retains its size
     * @param c determines which element's counts is lowered
     */
    public void remove(char c){
        if(Character.isUpperCase(c)){
            c = Character.toLowerCase(c);
        }
        int elementC = (int) c;
        boolean isRemoved = false;
        for(int i = 0; i <= 26; i++){
            if(i + 97 == elementC && array[i] > 0){
                array[i] -= 1;
                isRemoved = true;
                numSubs++;
            }
        }
        if(!isRemoved && array[26] > 0){
            array[26] -= 1;
            numSubs++;
        }
    }

    /**
     * This returns the count of a certain element
     * @param element The elmenet whose count is returned
     * @return a count integer
     */
    public int getCount(char element){
        if(Character.isUpperCase(element)){
            element = Character.toLowerCase(element);
        }
        boolean isPresent = false;
        int elementNumber = (int) element;
        for(int i = 97; i <= 122; i++){
            if(elementNumber == i){
                return(array[i - 97]);
            }
        }
        return array[26];
    }

    /**
     * Returns the number of succesful additions minus the number of successful removes
     * @return Size of the array
     */
    public int getSize(){
        return numAdds - numSubs;
    }

    /**
     * Returns the object displayed as a string
     * @return a string
     */
    public String toString(){
        String string = "CharBag{";
        char start = 'a';
        for(int i = 0; i < 27; i++){
            if(i != 26) {
                string += start + ":" + array[i] + ", ";
            }
            if(i == 26){
                string += ".:" + array[i] + "}";
            }
            start += 1;
        }
        return string;
    }

    /**
     * Use the random class to generate a random letter by using counts of letter to change probabilities
     * @return a letter or the stop element.
     */
    public char getRandomChar(){
        if(getSize() == 0){
            return '.';
        }
        Random random = new Random();
        int count = random.nextInt(getSize());
        for(int i = 0; i < 26; i++){
            count -= array[i];
            if(count < 0){
                char c = (char) (i + 97);
                return c;
            }
        }
        return '.';
    }


}
