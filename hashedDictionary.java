package dictionary;

public class hashedDictionary {
    static int index = 255; // Can set to larger values (but don't go too large - limit ~ 214748360)
    static String[] dictKeys = new String[index];
    static int[][] dictValues = new int[index][];

    public static int hash(String key){
        int pos = 0;
        for (char chr: key.toCharArray()){
            pos += chr;
        }

        pos = pos % index;
        return pos;
    }

    /**
     * Adds key, value pair
     * @param key - string key for dict. key
     * @param value - int value for dict. data
     */
    public static String insert(String key, int value){
        int pos = hash(key);

        int[] temp_value = {value};

        if (dictKeys[pos] == null){
            dictKeys[pos] = key;
            dictValues[pos] = temp_value;

            return "Success";
        }
        else if (dictKeys[pos] == key){
            return "Duplicate Key";
        }
        else{
            while (dictKeys[pos] != null){
                pos ++;
                pos = pos % index;
            }

            dictKeys[pos] = key;
            dictValues[pos] = temp_value;

            return ("Collision Error, Handled Hash Location: " + pos);
        }
    }

    /**
     * Adds key, value pair
     * @param key - string key for dict. key
     * @param value - array of int values for dict. data
     */
    public static String insert(String key, int[] value){
        int pos = hash(key);

        if (dictKeys[pos] == null){
            dictKeys[pos] = key;
            dictValues[pos] = value;

            return "Success";
        }
        else if (dictKeys[pos] == key){
            return "Duplicate Key";
        }
        else{
            while (dictKeys[pos] != null){
                pos ++;
                pos = pos % index;
            }

            dictKeys[pos] = key;
            dictValues[pos] = value;
            
            return ("Collision Error, Handled Hash Location: " + pos);
        }
    }

    /**
     * Deletes a dict. entry based of it's key
     * @param key 
     */
    public static String delete(String key){
        int pos = hash(key);
        int temp = pos;

        if ((dictValues[pos] != null) && (dictKeys[pos] == key)){
            dictKeys[pos] = null;
            dictValues[pos] = null;

            return "Delete - Success";
        }
        else if (dictKeys[pos] != key){
            while ((dictKeys[pos] != key)) {
                pos ++;
                pos = pos % index;

                if (temp == pos){
                    break;
                }
            }
            dictKeys[pos] = null;
            dictValues[pos] = null;

            return ("Delete - Collision Success, Handled Hash Location: " + pos);
        }
        else{
            return "Delete - Failed";
        }
    }

    /**
     * Returns string representation of dictionary
     * data corresponding to a passed key value
     * @param key - string key for dict. key
     * @return - string representation of data
     */
    public static String search(String key){
        int pos = hash(key);
        int temp = pos;

        if ((dictValues[pos] != null) && (dictKeys[pos] == key)){
            return java.util.Arrays.toString(dictValues[pos]);
        }
        else if (dictKeys[pos] != key){
            while ((dictKeys[pos] != key)) {
                pos ++;
                pos = pos % index;

                if (temp == pos){
                    return null;
                }
            }
            return java.util.Arrays.toString(dictValues[pos]);
        }
        else{
            return null;
        }
    }

    /**
     * Test data for hashing function
     * @param args
     */
    public static void main(String[] args) {
        int[] data = {1,2,3};
        int[] data_2 = {5, 6, 7};
        int[] data_3 = {5, 6, 7, 8};

        // Collision Test Data Insertion
        System.out.println("Edge Collision Test Data Insertion:");

        System.out.println(insert("zAC", data));
        System.out.println(insert("zACzAD", data_2));
        System.out.println(insert("zACzADzAD", data_3));

        System.out.println("\nCollision Test Data Insertion:");

        System.out.println(insert("one", data));
        System.out.println(insert("onezAD", data_2));
        System.out.println(insert("onezADzAD", data_3));

        // Standard Test Data Insertion
        System.out.println("\nStandard Data Insertion:");

        System.out.println(insert("two", data_2));
        System.out.println(insert("four", data_3));
        System.out.println(insert("five", 5));
        System.out.println(insert("three", 3));

        //----------------------------------------------//

        // Test Data Deletion
        System.out.println("\n//----------------------------------------------//");
        System.out.println("\nData Deletion:");

            //Standard
        System.out.println(delete("three"));
            //Collision
        System.out.println(delete("one"));
        System.out.println(delete("onezAD"));
            //Edge
        System.out.println(delete("zAC"));
        System.out.println(delete("zACzAD"));
        
        //----------------------------------------------//

        // Deleted Viewer
        System.out.println("\n//----------------------------------------------//");
        System.out.println("\nDeleted Viewer:");

        System.out.println(search("zAC")); // Expected null as deleted
        System.out.println(search("zACzAD")); // Expected null as deleted
        System.out.println(search("zACzADzAD")); // Expected value as present

        System.out.println();

        System.out.println(search("one")); // Expected null as deleted
        System.out.println(search("onezAD")); // Expected null as deleted
        System.out.println(search("onezADzAD")); // Expected value as present


        System.out.println();
        System.out.println(search("three")); // Expected null as deleted
        System.out.println(search("four")); // Expected value as present

        //----------------------------------------------//
        
        // Re-insert deleted data
        System.out.println("\n//----------------------------------------------//");
        System.out.println("\nRe-insert Deleted Data:");

        System.out.println(insert("one", data));
        System.out.println(insert("onezAD", data_2));
        System.out.println(insert("zAC", data));
        System.out.println(insert("zACzAD", data_2));
        System.out.println(insert("three", 3));

        //----------------------------------------------//

        // Collision Tests
        System.out.println("\n//----------------------------------------------//");
        System.out.println("\nEdge Collision Tests:");

        System.out.println(search("zAC"));
        System.out.println(search("zACzAD"));
        System.out.println(search("zACzADzAD"));

        System.out.println("\nCollision Tests:");

        System.out.println(search("one"));
        System.out.println(search("onezAD"));
        System.out.println(search("onezADzAD"));

        // Standard Tests
        System.out.println("\nStandard Tests:");
        System.out.println(search("four"));
        System.out.println(search("three"));

        //----------------------------------------------//

        //All data viewer 

        //System.out.println("\n//----------------------------------------------//");
        // int c = 0;
        // for (int[] i : dictValues) {
        //     System.out.print(dictKeys[c] + ' ');
        //     System.out.print(Integer.toString(c) + ' ');
        //     System.out.println(java.util.Arrays.toString(i));
        //     c++;
        // }
    }
}
