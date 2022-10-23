package variables;

import java.util.ArrayList;

public class VariableManager {
    private ArrayList<Bool> bools;
    private ArrayList<Number> numbers;
    private ArrayList<String> strings;

    public VariableManager() {
        this.bools = new ArrayList<>();
        this.numbers = new ArrayList<>();
        this.strings = new ArrayList<>();
    }

    public Variable getVariable(String name) {
        for (Bool i : bools) {
            if(i.getName().equals(name)) return i;
        }

        for (Number i : numbers) {
            if(i.getName().equals(name)) return i;
        }

        for (String i : strings) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public void newVariable(String name, String value) {
    }
}
