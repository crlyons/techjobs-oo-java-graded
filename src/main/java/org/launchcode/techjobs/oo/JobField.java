package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    //declare each of the common fields.
    private int id;
    private static int nextId = 1;
    private String value;

    //Code the constructors.
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //Use Generate to create the appropriate getters and setters.
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    //Add in the custom methods.
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return value;
    }
    // make this class abstract.
}
