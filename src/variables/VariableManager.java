package variables;

import java.util.ArrayList;

import main.lib;

public class VariableManager {
    private ArrayList<Bool> bools;
    private ArrayList<Number> numbers;
    private ArrayList<vString> strings;

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

        for (vString i : strings) {
            if(i.getName().equals(name)) return i;
        }

        return null;
    }

    public void newVariable(String name, String value) {
        if (getVariable(name) != null) return;

        if (lib.isNumber(value)) {
            this.numbers.add(new Number(name, Double.parseDouble(value)));
        } else if (lib.isNumber(value)) {
            this.bools.add(new Bool(name, Boolean.parseBoolean(value)));
        } else {
            this.strings.add(new vString(name, value));
        }
    }
}
