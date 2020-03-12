package com.wsi.challenge;

import java.util.Comparator;

public class RangeComparator implements Comparator<ZipcodeRange> {
  @Override
  public int compare (ZipcodeRange range1, ZipcodeRange range2) {
    return range1.getLowerRange() < range2.getLowerRange() ? -1 : range1.getLowerRange() == range2.getLowerRange() ? 0 : 1;
  }
}
