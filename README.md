# Hashed-Dictionary
A simple hashed dictionary example with 256 hashable locations, and three methods:
  
    • insert - allows for a (key, value) pair to be added to the dictionary
    • delete - allows for deltetion of a (key, value) pair, referenced by their key
    • search - allows for the location of a (key, value) pair, referenced by the key


------------------------------------------------------------------------------------------------------------------------
Note:

    • Uses linear probing to handle hash collisions and example tests are in the main method for examplifying the functionalities
    • The number of hashable locations can be modified to be larger, but the code struggles with values > ~ 214748360
