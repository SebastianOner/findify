package CodeBase;

interface  Polygon {
    void getArea();
    default void getSides() {
        System.out.println("I can get sides of polygon.");
    }
}