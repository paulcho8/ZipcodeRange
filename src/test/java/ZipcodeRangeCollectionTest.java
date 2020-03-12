import com.wsi.challenge.ZipcodeRange;
import com.wsi.challenge.ZipcodeRangeCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ZipcodeRangeCollectionTest {
  private ZipcodeRangeCollection collection;

  @Before
  public void setup() {
    collection = new ZipcodeRangeCollection();
  }

  /** Tests overlapping zipcode ranges (given example) */
  @Test
  public void properlyMergesOverlappingZipCodes(){
    ZipcodeRange range1 = new ZipcodeRange(94133, 94133);
    ZipcodeRange range2 = new ZipcodeRange(94200, 94299);
    ZipcodeRange range3 = new ZipcodeRange(94226, 94399);

    collection.addRangeToList(range1);
    collection.addRangeToList(range2);
    collection.addRangeToList(range3);
    collection.createMinimumRanges();

    ArrayList<Integer> expectedRange1 = new ArrayList<>();
    expectedRange1.add(94133);
    expectedRange1.add(94133);

    ArrayList<Integer> expectedRange2 = new ArrayList<>();
    expectedRange2.add(94200);
    expectedRange2.add(94399);

    ArrayList<ArrayList<Integer>> expectedResult = new ArrayList<>();
    expectedResult.add(expectedRange1);
    expectedResult.add(expectedRange2);

    Assert.assertEquals(expectedResult, collection.getConstructedRange());
  }

  /** Tests non-overlapping zipcode ranges (given example) */
  @Test
  public void doesNotMergeCorrectRanges() {
    ZipcodeRange range1 = new ZipcodeRange(94133, 94133);
    ZipcodeRange range2 = new ZipcodeRange(94200, 94299);
    ZipcodeRange range3 = new ZipcodeRange(94600, 94699);

    collection.addRangeToList(range1);
    collection.addRangeToList(range2);
    collection.addRangeToList(range3);
    collection.createMinimumRanges();

    ArrayList<Integer> expectedRange1 = new ArrayList<>();
    expectedRange1.add(94133);
    expectedRange1.add(94133);

    ArrayList<Integer> expectedRange2 = new ArrayList<>();
    expectedRange2.add(94200);
    expectedRange2.add(94299);

    ArrayList<Integer> expectedRange3 = new ArrayList<>();
    expectedRange3.add(94600);
    expectedRange3.add(94699);

    ArrayList<ArrayList<Integer>> expectedResult = new ArrayList<>();
    expectedResult.add(expectedRange1);
    expectedResult.add(expectedRange2);
    expectedResult.add(expectedRange3);

    Assert.assertEquals(expectedResult, collection.getConstructedRange());
  }

  /** Tests for long overlapping/consecutive zipcode ranges to be merged properly. */
  @Test
  public void handlesLongRanges(){
    ZipcodeRange range1 = new ZipcodeRange(94133, 94133);
    ZipcodeRange range2 = new ZipcodeRange(94134, 94299);
    ZipcodeRange range3 = new ZipcodeRange(94232, 94333);
    ZipcodeRange range4 = new ZipcodeRange(94540, 94570);
    ZipcodeRange range5 = new ZipcodeRange(94600, 94699);
    ZipcodeRange range6 = new ZipcodeRange(94622, 94650);
    ZipcodeRange range7 = new ZipcodeRange(94633, 94700);

    collection.addRangeToList(range1);
    collection.addRangeToList(range2);
    collection.addRangeToList(range3);
    collection.addRangeToList(range4);
    collection.addRangeToList(range5);
    collection.addRangeToList(range6);
    collection.addRangeToList(range7);
    collection.createMinimumRanges();

    ArrayList<Integer> expectedRange1 = new ArrayList<>();
    expectedRange1.add(94133);
    expectedRange1.add(94333);

    ArrayList<Integer> expectedRange2 = new ArrayList<>();
    expectedRange2.add(94540);
    expectedRange2.add(94570);

    ArrayList<Integer> expectedRange3 = new ArrayList<>();
    expectedRange3.add(94600);
    expectedRange3.add(94700);

    ArrayList<ArrayList<Integer>> expectedResult = new ArrayList<>();
    expectedResult.add(expectedRange1);
    expectedResult.add(expectedRange2);
    expectedResult.add(expectedRange3);

    Assert.assertEquals(expectedResult, collection.getConstructedRange());
  }

  /** Tests for long overlapping/consecutive unsorted ranges */
  @Test
  public void properlyMergesUnsortedRanges() {
    ZipcodeRange range1 = new ZipcodeRange(94133, 94133);
    ZipcodeRange range2 = new ZipcodeRange(94134, 94299);
    ZipcodeRange range3 = new ZipcodeRange(94232, 94333);
    ZipcodeRange range4 = new ZipcodeRange(94540, 94570);
    ZipcodeRange range5 = new ZipcodeRange(94600, 94699);
    ZipcodeRange range6 = new ZipcodeRange(94622, 94650);
    ZipcodeRange range7 = new ZipcodeRange(94633, 94700);

    collection.addRangeToList(range2);
    collection.addRangeToList(range1);
    collection.addRangeToList(range3);
    collection.addRangeToList(range7);
    collection.addRangeToList(range5);
    collection.addRangeToList(range6);
    collection.addRangeToList(range4);

    collection.createMinimumRanges();

    ArrayList<Integer> expectedRange1 = new ArrayList<>();
    expectedRange1.add(94133);
    expectedRange1.add(94333);

    ArrayList<Integer> expectedRange2 = new ArrayList<>();
    expectedRange2.add(94540);
    expectedRange2.add(94570);

    ArrayList<Integer> expectedRange3 = new ArrayList<>();
    expectedRange3.add(94600);
    expectedRange3.add(94700);

    ArrayList<ArrayList<Integer>> expectedResult = new ArrayList<>();
    expectedResult.add(expectedRange1);
    expectedResult.add(expectedRange2);
    expectedResult.add(expectedRange3);

    Assert.assertEquals(expectedResult, collection.getConstructedRange());
  }
}
