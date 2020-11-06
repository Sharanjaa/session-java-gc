package hms.session.gc.domain;

public class Student {

    private String name = "Test ";

    private String address = "Test Address ";

    private int marks;

    public Student(String name, String address, int marks) {
        this.name += name;
        this.address += address;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
