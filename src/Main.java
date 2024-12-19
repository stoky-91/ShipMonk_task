public class Main {
    public static void main(String[] args) {
        // Test with Integer values
        SortedLinkedList<Integer> intList = new SortedLinkedList<>(Integer.class);
        intList.add(10);
        intList.add(5);
        intList.add(20);
        intList.add(15);
        intList.printList(); // 5 -> 10 -> 15 -> 20

        // Remove an element
        intList.remove(10);
        intList.remove(33);
        intList.printList(); // 5 -> 15 -> 20 -> null
        System.out.println("Size of list: " + intList.size());
        System.out.println("Contains 15? " + intList.contains(15)); // true
        System.out.println("Contains 25? " + intList.contains(25)); // false
        System.out.println();

        // Test with String values
        SortedLinkedList<String> strList = new SortedLinkedList<>(String.class);
        strList.add("Martin");
        strList.add("Andrea");
        strList.add("Tereza");
        strList.add("Michal");
        strList.printList(); // Andrea -> Martin -> Michal -> Tereza
        System.out.println("Contains Andrea? " + strList.contains("Andrea")); // true
        System.out.println("Contains Radka? " + strList.contains("Radka")); // false
    }


}