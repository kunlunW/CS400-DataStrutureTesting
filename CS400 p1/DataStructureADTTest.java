//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DataStructureADTTest
// Files: DataStructureADTTest.java
// Course: CS400 fall 2019
//
// Author: Kunlun Wang
// Email: kwang358@wisc.edu
// Lecturer's Name: Deb Deppeler
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: N/A
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * The class mainly serves as a test to test the functionality of TA implementation as well as DS_My
 * implementations
 * 
 * @author Kunlun Wang & Deb Deppeler
 *
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

abstract class DataStructureADTTest<T extends DataStructureADT<String, String>> {

  private T dataStructureInstance;

  protected abstract T createInstance();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @AfterAll
  static void tearDownAfterClass() throws Exception {}

  @BeforeEach
  void setUp() throws Exception {
    dataStructureInstance = createInstance();
  }

  @AfterEach
  void tearDown() throws Exception {
    dataStructureInstance = null;
  }

  /**
   * test if DS is empty before any operations
   */
  @Test
  void test00_empty_ds_size() {
    if (dataStructureInstance.size() != 0)
      fail("data structure should be empty, with size=0, but size=" + dataStructureInstance.size());
  }

  /**
   * test if insert one key results in size=1
   */
  @Test
  void test01_after_insert_one_size_is_one() {
    dataStructureInstance.insert("1", "Hydrogen");
    if (dataStructureInstance.size() != 1) {
      fail("data structure size should be size = 1 after the insertion of one key value pair, "
          + "but size = " + dataStructureInstance.size());
    }
  }

  /**
   * test if inserting one key and removing it results in size=0
   */
  @Test
  void test02_after_insert_one_remove_one_size_is_zero() {
    dataStructureInstance.insert("2", "Helium");

    if (dataStructureInstance.size() != 1)
      fail("data structure should have 1 element, with size=1, but size="
          + dataStructureInstance.size());

    dataStructureInstance.remove("2");

    if (dataStructureInstance.size() != 0) {
      fail("data structure should be empty, with size=0, but size=" + dataStructureInstance.size());
    }
  }

  /**
   * test if duplicate key exception is thrown when inserting duplicate keys
   */
  @Test
  void test03_duplicate_exception_is_thrown() throws RuntimeException {
    boolean passTest = false;
    try {
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("2", "Helium");
      dataStructureInstance.insert("2", "Helium");
    } catch (RuntimeException e) {
      System.out.println("DuplicateKeyException Caught!");
      passTest = true;
    } catch (Exception e) {
      passTest = false;
      System.out.println("Exception caught");
    }
    if (!passTest) {
      System.out.println("Something went wrong");
    }
  }

  /**
   * test if duplicate key exception is thrown when inserting duplicate keys
   */
  @Test
  void test031_duplicate_exception_is_thrown() throws RuntimeException {
    boolean passTest = false;
    try {
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("1", "Hydrogen");
      fail("RuntimeException not caught!");
    } catch (RuntimeException e) {
      System.out.println("DuplicateKeyException Caught!");
      passTest = true;
    } catch (Exception e) {
      passTest = false;
      System.out.println("Exception caught");
    }
    if (!passTest) {
      System.out.println("Something went wrong");
    }
  }


  /**
   * test if removing a non-existing key throws an exception
   */
  @Test
  void test04_remove_returns_false_when_key_not_present() {
    try {
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("2", "Helium");
      dataStructureInstance.insert("3", "Lithium");

      if (dataStructureInstance.remove("4")) {
        fail(
            "No such key in the structure. Remove should return false, but returned true instead.");
      }
    } catch (Exception e) {
      System.out.println("Exception caught");
    }

  }

  /**
   * test if inserting a null key throwns an exception
   */
  @Test
  void test05_insertNullKey() {
    boolean passTest = false;

    try {
      dataStructureInstance.insert(null, "Nullium");
      fail("Did not catch IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      passTest = true;
    } catch (Exception e) {
      passTest = false;
      fail("A IllegalArgumentException should be thrown instead!");
    }

    if (!passTest) {
      fail("A IllegalArgumentException should be thrown instead!");
    }
  }

  /**
   * test if inserting 500 keys and removing them would function properly
   */
  @Test
  void test06_insertHundredsKeys_andRemoveThem() {
    boolean testPass = false;
    try {
      for (int i = 0; i < 500; i++) {
        String key = i + "_element";
        dataStructureInstance.insert(key, "Kunlunium");
        if (!dataStructureInstance.remove(key)) {
          fail("Coudln't remove key: " + key);
        }
      }
    } catch (Exception e) {
      System.out.println("Exception caught");
    }
  }

  void test061_insertHundredsKeys() {

    try {
      for (int i = 0; i < 600; i++) {
        String key = i + "_element";
        dataStructureInstance.insert(key, "Kunlunium");
        if (!dataStructureInstance.remove(key)) {
          fail("Coudln't remove key: " + key);
        }
      }
    } catch (Exception e) {
      System.out.println("Exception caught");
    }

    if (dataStructureInstance.size() != 0) {
      fail("data structure should be empty after removal but " + "but has a size="
          + dataStructureInstance.size());
    }
  }

  /**
   * test if removing a null key throws an exception
   */
  @Test
  void test07_removeNullKey() {

    try {
      dataStructureInstance.remove(null);
      fail("Did not catch IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      System.out.println("Exception caught: trying to remove null");
    } catch (Exception e) {
      System.out.println("Exception caught");
    }
  }

  /**
   * test if inserting 3 key and removing 2 results in size=1
   */
  @Test
  void test08_insert_three_remove_two() {

    try {
      dataStructureInstance.insert("4", "Beryllium");
      dataStructureInstance.insert("5", "Boron");
      dataStructureInstance.insert("6", "Carbon");

      if (dataStructureInstance.size() != 3) {
        fail("data structure has size of 3, but size=" + dataStructureInstance.size());
      }
      dataStructureInstance.remove("4");
      if (dataStructureInstance.size() != 2) {
        fail("data structure has size of 2, but size=" + dataStructureInstance.size());
      }
      dataStructureInstance.remove("5");
      if (dataStructureInstance.size() != 1) {
        fail("data structure has size of 1, but size=" + dataStructureInstance.size());
      }

    } catch (Exception e) {
      System.out.println("Exception caught");
    }

  }

  /**
   * test if getting a null key results in exception
   */
  @Test
  void test09_get_null_exception_thrown() {
    try {
      dataStructureInstance.get(null);
      fail("Attempting to get a null key");
    } catch (IllegalArgumentException e) {
      System.out.println("Exception caught");

    } catch (Exception e) {
      System.out.println("Exception caught");
    }

  }

  /**
   * test if get method is getting the correct value of keys
   */
  @Test
  void test10_get_correct_value() {
    try {
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("2", "Helium");
      dataStructureInstance.insert("3", "Lithium");
      if (!(dataStructureInstance.get("1").equals("Hydrogen")
          && dataStructureInstance.get("2").equals("Helium")
          && dataStructureInstance.get("3").equals("Lithium"))) {
        fail("Failing to get correct value of keys");
      }
    } catch (Exception e) {
      System.out.println("Exception caught!");
    }
  }

  /**
   * test if getting from a non-existing key throws an exception
   */
  @Test
  void test11_get_from_null_key() {
    try {

      if (!(dataStructureInstance.get("1") == null))
        fail("did not return null when key does not exist");
    } catch (Exception e) {
      System.out.println("Exception caught");
    }
  }

  /**
   * test if keys contains the correct values
   */
  @Test
  void test_12_contains_test_correct() {
    try {
      // insert three key and check whether contains each
      dataStructureInstance.insert("1", "Hydrogen");
      dataStructureInstance.insert("2", "Helium");
      dataStructureInstance.insert("3", "Lithium");

      if (!(dataStructureInstance.contains("1") && dataStructureInstance.contains("2")
          && dataStructureInstance.contains("3")))
        fail("Contains function fails to detect existing key");
    } catch (Exception e) {
      System.out.println("Exception caught");
    }
  }

  /**
   * test if inserting 500 keys-value pair would generate correct size
   */
  @Test
  void test13_check_hundred_size() {
    try {
      for (int i = 0; i < 500; i++) {
        // set key to i and value to i+1
        String key = Integer.toString(i);
        String value = Integer.toString(i + 1);
        dataStructureInstance.insert(key, value);
        if (dataStructureInstance.size() != i + 1) {
          fail("Size is wrong");
        }
      }
    }

    catch (Exception e) {
      System.out.println("Exception caught");
    }
  }


}


