package homework;

public class Animal {
	Boolean live;
	Integer age;
	String name;

    public Animal(String name, int age, boolean live) {
        this.name = name;
        this.age = age;
        this.live = live;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean getLive() {
        return this.live;
    }
}
