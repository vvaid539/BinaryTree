//CSCI 1913 Fall 2022 Project 3
//Author: Vedant Vaid

/**
 * This class creates a Gibberisher object through 3 atttributes, A Trie<CharBag> object,
 * an integer to represent segment length, and an integer to respresent the number of letter samples
 */
public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int numLetterSamples;

    public Gibberisher(int segmentLength){
        this.segmentLength = segmentLength;
        model = new Trie<CharBag>();
        numLetterSamples = 0;

    }

    /**
     * This function adds Letter samples to the model attribute
     * @param arr Use the strings array to complete the model
     */
    public void train(String[] arr){
        for(int i = 0; i < arr.length; i++){
            LetterSample[] sample = LetterSample.toSamples(arr[i], segmentLength);
            for(int j = 0; j < sample.length; j++){
                String segment = sample[j].getSegment();
                char nextLetter = sample[j].getNextLetter();
                if(model.get(segment) == null){
                    CharBag charbag = new CharBag();
                    charbag.add(nextLetter);
                    model.put(segment, charbag);
                }
                else{
                    CharBag charbag = model.get(segment);
                    charbag.add(nextLetter);
                    model.put(segment, charbag);
                }
                numLetterSamples += 1;
            }
        }
    }

    /**
     * This function returns the number of Letter samples used to train the model
     * @return an integer detailing number of Lettersamples
     */
    public int getSampleCount(){
        return numLetterSamples;
    }

    /**
     * This function generates gibberish english words through an algorithim
     * @return A string of gibberish
     */
    public String generate(){
        String word = "";
        while(word.length() == 0 || word.charAt(word.length() - 1) != '.'){
            String sample = "";
            if(word.length() <= segmentLength){
                sample = word;
            }
            else{
                sample = word.substring(word.length() - segmentLength);
            }
            char nextLetter = model.get(sample).getRandomChar();
            word = word + nextLetter;
        }
        return word.substring(0, word.length() - 1);
    }
}
