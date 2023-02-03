class Cat {

    String name;
    int age;
    static int count = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
        if (count > 5) System.out.println("You have too many cats");
    }

    public static int getNumberOfCats() {
        return count;
    }
}