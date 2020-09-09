package cc.oakk.ladder.model.person;

import cc.oakk.ladder.model.result.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonsTest {
    @Test
    public void constructor_ShouldThrow_WhenEmptyList() {
        assertThatIllegalArgumentException().isThrownBy(() ->  new Persons(null));
        assertThatIllegalArgumentException().isThrownBy(() ->  new Persons(new ArrayList<>()));
    }

    @Test
    public void get() {
        Persons persons = new Persons(Stream.of("pobi", "honux", "crong", "jk")
                .map(Person::new)
                .collect(Collectors.toList()));

        assertThat(persons.get(0)).isEqualTo(new Person("pobi"));
        assertThat(persons.get(1)).isEqualTo(new Person("honux"));
        assertThat(persons.get(2)).isEqualTo(new Person("crong"));
        assertThat(persons.get(3)).isEqualTo(new Person("jk"));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    public void size(int size) {
        Persons persons = new Persons(IntStream.range(0, size).boxed()
                .map(v -> new Person("temp"))
                .collect(Collectors.toList()));
        assertThat(persons.size()).isEqualTo(size);
    }
}
