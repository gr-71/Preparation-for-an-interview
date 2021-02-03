package second.lesson.homework;

public class TestsApp {

    private static ListSpecimen<String> stringList;

    private static void displayListActions(){
        System.out.println("Confirmation of the list emptiness: " + stringList.isEmpty());
        for (int i = 0; i < 10; i++) {
            stringList.add("Essence " + i);
        }
        System.out.println("List size is " + stringList.size() + " after filling with " + stringList.size() + " essences.");
        System.out.println("Get essence by index: " + stringList.get(8));
        System.out.println("Set essence by index: " + stringList.set(8, "new essence 8"));
        System.out.println("Delete essence: " + stringList.delete("Essence 5"));
        System.out.println("Now list size is: " + stringList.size());
        System.out.println("Let's check if our list contains 'Essence 3': " + stringList.contains("Essence 3"));
        System.out.println("Let's check if our list contains 'Essence 17': " + stringList.contains("Essence 17"));
    }

    public static void main(String[] args) {

        System.out.println(" ***** Show my LinkedList operations ***** ");
        stringList = new MyLinkedList<>();
        displayListActions();

        System.out.println(" \n ***** Show my ArrayList operations ***** ");
        stringList = new MyArrayList<>();
        displayListActions();
    }

}
