public class Main {

    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("five");
        list.add("seven");
        list.add("two");
        list.add("nine");

        MyList<String> list2 = new MyList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");
        list2.add("five");
        list2.add("seven");
        list2.add("two");
        list2.add("nine");

        System.out.println(list.containsAll(list2));


//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("One");
//        arrayList.add("Hundred");
//        arrayList.add("Two");
//        arrayList.add("Seven");
//        arrayList.add("Three");
//        arrayList.add("Five");
//
//        Iterator<String> iterator = arrayList.iterator();
//        while (iterator.hasNext())
//            System.out.println(iterator.next());


//        MyList<Integer> list2 = new MyList<>();
//        list2.add(2);
//        list2.add(1);
//        list2.add(3);
//        list2.add(10);
//        list2.add(12);
//        list2.add(4);
//        list2.add(6);
//        list2.add(11);


    }
}