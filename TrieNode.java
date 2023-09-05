/**
 * This class creates an TrieNode object with the attributes
 * of data and a TrieNode array
 * @param <T> This implements the generic interface
 */
public class TrieNode<T>{
    public T data;
    private TrieNode<T>[] array;

    public TrieNode(){
        data = null;
        array = new TrieNode[26];
    }

    public T getData(){
        return data;
    }

    public void setData(T newData){
        data = newData;
    }

    /**
     * This function reutrns the child of a TrieNode based on a given character
     * @param letter Given character used to find a Trienode
     * @return a Trienode
     */
    public TrieNode<T> getChild(char letter){
        int numLetter = (int) letter;
        boolean isBetween = false;
        for(int i = 97; i <= 122; i++){
            if(numLetter == i){
                isBetween = true;
            }
        }
        if(!isBetween){
            return null;
        }
        for(int z = 97; z <= 122; z++){
            if(z == numLetter && array[z - 97] == null){
                TrieNode<T> newNode = new TrieNode<>();
                array[z - 97] = newNode;
                return array[z-97];
            }
            else if(z == numLetter){
                return array[z-97];
            }
        }
        return null;
    }
}
