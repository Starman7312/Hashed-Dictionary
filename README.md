# Hashed-Dictionary
A simple hashed dictionary example with 256 hashable locations, and three methods:
  
    • insert - allows for a (key, value) pair to be added to the dictionary
    • delete - allows for deltetion of a (key, value) pair, referenced by their key
    • search - allows for the location of a (key, value) pair, referenced by the key

It uses linear probing to handle hash collisions and example tests are in the main method for examplifying the functionalities.

------------------------------------------------------------------------------------------------------------------------
Note: number of hashable locations can be modified to take up to &lt;= 2^31
