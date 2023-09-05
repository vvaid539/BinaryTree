/**
 * This class creates a Trie class object which has a singlular attribute
 * of a Trienode Object root
 * @param <T> Implements the generics class
 */
public class Trie<T> {
    private TrieNode<T> root;

    public Trie(){
        root = new TrieNode<T>();
    }

    /**
     * This function return the child node of the entire string
     * @param string String which we find the node from
     * @return A Trienode<t> object
     */
    private TrieNode<T> getNode(String string){
        if(string.equals("")){
            return root;
        }
        TrieNode temp = root.getChild(string.charAt(0));
        if(string.length() >= 2) {
            for (int i = 1; i < string.length(); i++) {
                temp = temp.getChild(string.charAt(i));
            }
        }
        return temp;

    }

    /**
     * Getter function for String
     * @param s determines the node
     * @returnr return the Data
     */
    public T get(String s){
        if(getNode(s) == null){
            return null;
        }
        return getNode(s).getData();
    }

    /**
     * Setter for the Trie class
     * @param s determines the node
     * @param datas generic parameter
     * @return same thing as setter
     */
    public T put(String s, T datas){
        getNode(s).setData(datas);
        return getNode(s).getData();
    }



}
