package example.Main;

public class JsonMessage {
    public JsonMessage(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public JsonMessage() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    String name;
    int age;

    @Override
    public String toString() {
        return "example.Main.JsonMessage{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
