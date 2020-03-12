package com.wsi.challenge;

public class CodingChallenge {

  public static void main(String[] args) {
    if (args.length < 1) {
      throw new Error("Input is required");
    }

    /** Instantiate a new collection */
    ZipcodeRangeCollection collection = new ZipcodeRangeCollection();

    /** Parse command line arguments and add each range to collection*/
    for (int i = 0; i < args.length; i++) {
      String substring = args[i];

      String[] splitSubstring = substring.split(",", -1);
      if (splitSubstring.length != 2) {
        throw new Error("Improper input. Please separate the limits of each range with a single comma");
      }
      for (int j = 0; j < splitSubstring.length; j += 2) {
        ZipcodeRange range;
        try {
          range = new ZipcodeRange(Integer.parseInt(splitSubstring[0]), Integer.parseInt(splitSubstring[1]));
        } catch (Exception e){
          throw new Error("Improper input or input is not an integer");
        }
        collection.addRangeToList(range);
      }
    }

    /** Generate an optimized collection of merged ranges */
    collection.createMinimumRanges();

    /** Print out the collection after calling a custom "toString" method to convert the ZipcodeRange objects. */
    System.out.println(collection.getConstructedRange());
  }
}
