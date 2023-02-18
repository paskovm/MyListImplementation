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

        var iterator = list.iterator();
        iterator.forEachRemaining(str -> System.out.println(str.concat("-hundred")));

        MyList<String> list2 = new MyList<>();
        list2.add("one");
        list2.add("two");
        list2.add("three");

        System.out.println(list.addAll(list2));
        System.out.println(list);

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