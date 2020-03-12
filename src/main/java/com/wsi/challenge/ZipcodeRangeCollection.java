package com.wsi.challenge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ZipcodeRangeCollection {

  private ArrayList<ZipcodeRange> rangeList = new ArrayList<>();
  private ArrayList<ArrayList<Integer>> constructedRange = new ArrayList<>();

  public void addRangeToList(ZipcodeRange range) {
    rangeList.add(range);
  }

  public void createMinimumRanges() {
    /** Sort the rangeList before merging */
    Collections.sort(rangeList, new RangeComparator());

    LinkedList<ZipcodeRange> merged = new LinkedList<>();
    for (ZipcodeRange range: rangeList) {

      /** If the merged list is empty or if there is no overlap between the current interval and the previous, we add the range */
      if (merged.isEmpty() || (merged.getLast().getHigherRange() < range.getLowerRange() && merged.getLast().getHigherRange() != range.getLowerRange() - 1)) {
        merged.add(range);

      /** The previous upper range and current lower range are consecutive; therefore, must be merged */
      } else if (merged.getLast().getHigherRange() + 1 == range.getLowerRange()) {
        merged.getLast().setHigherRange(range.getHigherRange());

        /** There is an inclusive overlap; therefore, must merge the current and previous values */
      } else {
        merged.getLast().setHigherRange(Math.max(merged.getLast().getHigherRange(), range.getHigherRange()));
      }
    }

    /** Convert the ZipcodeRange Object to an ArrayList before appending to the final constructedRange */
    for (ZipcodeRange range: merged) {
      constructedRange.add(range.constructRangeStructure());
    }
  }

  public ArrayList<ArrayList<Integer>> getConstructedRange() {
    return constructedRange;
  }
}
