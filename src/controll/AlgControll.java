package controll;

import data.Element;
import module.Algorithm;
import module.Module;
import view.Menu;

public class AlgControll extends Menu<String> {
    protected Algorithm algorithm;
    protected Module module;
    protected int[] array;
    protected int size_array;
    static String[] menu = {"Sort", "Search", "\\EXIT (0)"};

    public AlgControll(Element element) {
        super("\n----------!!Control System!!----------", menu);
        module = new Module();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> Sort();
            case 2 -> Search();
        }
    }


    private void Sort() {
        final String[] mSort = {"Bubble Sort", "Quick Sort", "Return Back(0)"};
        Menu m = new Menu("\n----------!!Sort Control!!----------", mSort) {
            @Override
            public void execute(int n) {

                module.display(array);
                switch (n) {
                    case 1 -> bublleSort();
                    case 2 -> quickSort();

                }

            }

        };

        m.run();
    }

    private void Search() {
        final String[] mSearch = {"linear Search", "Binary Search", "Return Back(0)"};
        Menu m = new Menu("\n----------!!Search Control!!----------", mSearch) {


            @Override
            public void execute(int n) {
                algorithm.buddleSort(array);
                module.display(array);
                switch (n) {
                    case 1 -> linearSearch();
                    case 2 -> binarySearch();

                }

            }

        };

        m.run();
    }

    private void bublleSort() {

        // 1. Bubble sort to sort ascending order
        algorithm.buddleSort(array);

        // 2. Display array after sort
        module.display(array, "Sorted array: ");
    }

    private void quickSort() {
        // 1. Quick sort to sort ascending order
        algorithm.quickSort(array,0,size_array -1);
        // 2. Display array after sort
        module.display(array, "Sorted array: ");
    }

    private void linearSearch() {
        int value = module.getInt("\nEnter number to find ", 1, 100);

        System.out.println("Found value: " + value + " at index: " + algorithm.linearSearch(array, value, 0, size_array - 1));
    }

    private void binarySearch() {
        int value = module.getInt("\nEnter number to find ", 1, 100);

        System.out.println("Found value: " + value + " at index: " + algorithm.binarySearch(array, value));
    }
}
