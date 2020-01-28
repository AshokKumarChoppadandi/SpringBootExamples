package com.java.spring.basics.coupled.loosely.withannotations;

import com.java.spring.basics.search.BinarySearch;
import com.java.spring.basics.sort.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchWithAnnotations {

    /**
     * Here, this Auto Wiring will fail if the @Component annotation is added to the BubbleSortBean class also.
     * The reason is, both the QuickSortBean and BubbleSortBean are implementing the same Type of Class Sort.
     * In this case, if Spring find two Components of Same type it doesn't know which one to use.
     * Hence it fails with the below Error
     *
     * "expected single matching bean but found 2"
     *
     * To handle this type issues, Spring provides @Primary annotation.
     * @Primary annotation tells the Spring which Bean to use as a Primary bean.
     */

    /**
     * Spring Framework use NOTHING for Auto Wire the dependencies, which is called as NO SETTER OR CONSTRUCTOR INJECTION.
     * This happens automatically when using @AutoWired on the Class object as above.
     */

    @Autowired
    private Sort sortAlgorithm;

    /**
     * Spring Framework use the Constructor to Auto Wire the dependencies, which is called as CONSTRUCTOR INJECTION.
     *
     * Spring Framework recommends to use Constructor Injection for all the MANDATORY dependencies
     */
    /*
    public BinarySearchWithAnnotations(Sort sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
    */

    /**
     * Spring Framework use the Setter Method to Auto Wire the dependencies, which is called as SETTER INJECTION.
     *
     * Spring Framework recommends to use Setter Injection if there are any OPTIONAL dependencies
     */
    /*
    public void setSortAlgorithm(Sort sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }
    */

    public int search(int[] numbers, int numberForSearch) {

        int[] sortedNumbers = sortAlgorithm.sort(numbers);

        // Searching the Element using Binary Search
        BinarySearch binarySearch = new BinarySearch();
        return binarySearch.search(sortedNumbers, numberForSearch);
    }
}

