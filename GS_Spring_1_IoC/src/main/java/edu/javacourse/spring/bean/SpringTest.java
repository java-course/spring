package edu.javacourse.spring.bean;

public class SpringTest {

    private Integer number;
    private SpringTestChild child;
    private SpringTestChild otherChild;

    public SpringTestChild getChild() {
        return child;
    }

    public void setChild(SpringTestChild child) {
        this.child = child;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SpringTestChild getOtherChild() {
        return otherChild;
    }

    public void setOtherChild(SpringTestChild otherChild) {
        this.otherChild = otherChild;
    }
}
