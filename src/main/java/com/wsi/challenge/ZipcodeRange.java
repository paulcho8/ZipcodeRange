package com.wsi.challenge;

import java.util.ArrayList;

public class ZipcodeRange {
  private int lowerRange;
  private int higherRange;

  /** "Sort ranges upon instantiation in case they are not in order" */
  public ZipcodeRange(int lowerRange, int higherRange){
   this.lowerRange = Math.min(lowerRange, higherRange);
   this.higherRange = Math.max(lowerRange, higherRange);
  }

  public int getLowerRange() {
    return lowerRange;
  }

  public void setLowerRange(int lowerRange) {
    this.lowerRange = lowerRange;
  }

  public int getHigherRange() {
    return higherRange;
  }

  public void setHigherRange(int higherRange) {
    this.higherRange = higherRange;
  }

  /** Construct a printable ArrayList */
  public ArrayList<Integer> constructRangeStructure() {
    ArrayList<Integer> zipcodeRange = new ArrayList<>();
    zipcodeRange.add(lowerRange);
    zipcodeRange.add(higherRange);
    return zipcodeRange;
  }

}
