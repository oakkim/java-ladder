package cc.oakk.ladder.model.person;


import cc.oakk.ladder.util.ValidationUtils;

import java.util.List;
import java.util.Objects;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = ValidationUtils.throwIfEmptyList(persons);
    }

    public Person get(int index) {
        ValidationUtils.throwIfOutOfListSize(persons, index);
        return persons.get(index);
    }

    public int size() {
        return persons.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons1 = (Persons) o;
        return Objects.equals(persons, persons1.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persons);
    }
}
