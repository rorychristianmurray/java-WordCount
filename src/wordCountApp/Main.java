package wordCountApp;

import java.util.*; // Includes all libraries in the java.util directory

public class Main {
    public static void main(String[] args) {

        String declaration = new Declaration().getDeclaration();

        String replacedText = declaration.replaceAll("[[\\.\\?\\!\\,\\;\\:\\{\\}\\(\\)\\']]", "").toLowerCase();

        String[] words = replacedText.split(" +");

        System.out.println();
        System.out.println("*** words ***" + words);

        // Instantiate new HashMap object taking a String as key and Integer as value
        // named wordCount
        HashMap<String, Integer> wordCount = new HashMap<>();

        // Check each word of type String in the words array
        for (String word : words) {
            // If statement checks HashMap type object named wordCount to see if it contains
            // the key of type String corresponding to each word in the for loop, looping
            // over the words array.
            // If the key of the key-value pair for each item in
            // the wordCount array matches the word item in the
            // words array, put the word string as the key
            // in the key - value pair to the wordCount HashMap,
            // and as the value, get the current value associated
            // with that key and increase by 1
            // If that key is not found, then put that word
            // into the wordCount HashMap and give it a value of 1

            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        System.out.println("*** wordCount ***");
        System.out.println(wordCount);

        // Create an ArrayList named sortedWords, the type will be the same type as each
        // item in the HashMap, which we get by accessing the entry

        ArrayList<HashMap.Entry<String, Integer>> sortedWords = new ArrayList<>();

        // Add all of the entry key-value pairs from the wordCount HashMap to the
        // sortedWords ArrayList using the entrySet() method on the HashMap

        sortedWords.addAll(wordCount.entrySet());
        System.out.println();
        // System.out.println("*** SortedWords ***");
        // System.out.println(sortedWords);

        // Sort sortedWords ArrayList using the sort() method on the Collections class.
        // sort() takes two arguments, a collections array and a Comparator object.
        // Instantiate new Comparator object in the sort() call
        // Comparator object will be of the type of each individual entry in the HashMap
        // collection, which is of type key-value pair (String, Integer)

        Collections.sort(sortedWords, new Comparator<HashMap.Entry<String, Integer>>() {
            // compare must be an interger. Compared two objects (with declared types)
            // against each other and returns based on that. This compare and return a
            // sorted ArrayList collection based on word instance (the integer 'value' in
            // the entry)

            public int compare(HashMap.Entry<String, Integer> o1, HashMap.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue(); // Check this for order
            }
        });

        // Loop over the sorted ArrayList sortedWords and print each word with the
        // amount of times it appears

        for (int i = 0; i < 50; i++) {
            System.out.println(
                    sortedWords.get(i).getKey() + " appears " + sortedWords.get(i).getValue() + " times in the UN HRD");
        }

    }

}

// for (HashMap.Entry<String, Integer> w : sortedWords) {
// System.out.println(w.getKey() + " appears " + w.getValue() + " times in the
// UN HRD");
// }