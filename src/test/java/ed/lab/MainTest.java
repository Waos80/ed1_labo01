package ed.lab;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MainTest {

    @Test
    void testSortedArrayGenerator() {
        final var sortedArrayGenerator = Main.getSortedArrayGenerator();
        assertThat(sortedArrayGenerator).isNotNull();

        final String[] array = sortedArrayGenerator.generate(10);

        assertThat(array)
                .isNotNull()
                .hasSize(10);

        for (int i = 1; i < array.length; i++) {
            assertThat(array[i]).isNotNull();

            assertThat(array[i])
                    .isNotNull()
                    .isGreaterThanOrEqualTo(array[i - 1]);
        }
    }

    @Test
    void testInvertedArrayGenerator() {
        final var invertedArrayGenerator = Main.getInvertedArrayGenerator();
        assertThat(invertedArrayGenerator).isNotNull();

        final String[] array = invertedArrayGenerator.generate(10);

        assertThat(array)
                .isNotNull()
                .hasSize(10);

        for (int i = 1; i < array.length; i++) {
            assertThat(array[i]).isNotNull();

            assertThat(array[i])
                    .isNotNull()
                    .isLessThanOrEqualTo(array[i - 1]);
        }
    }

    @Test
    void testRandomGenerator() {
        final var randomArrayGenerator = Main.getRandomArrayGenerator();
        assertThat(randomArrayGenerator).isNotNull();

        final String[] array = randomArrayGenerator.generate(10);

        assertThat(array)
                .isNotNull()
                .hasSize(10);

        for (String str : array) {
            assertThat(str).isNotNull();
        }
    }

    @Test
    void testHighPivotQuickSort() {
        final var highPivotQuickSort = Main.getHighPivotQuickSort();
        assertThat(highPivotQuickSort).isNotNull();

        final var randomArrayGenerator = Main.getRandomArrayGenerator();
        assertThat(randomArrayGenerator).isNotNull();

        final String[] str = randomArrayGenerator.generate(10);
        assertThat(str)
                .isNotNull()
                .hasSize(10);

        highPivotQuickSort.sort(str);

        for (int i = 1; i < str.length; i++) {
            assertThat(str[i])
                    .isNotNull()
                    .isGreaterThanOrEqualTo(str[i - 1]);
        }
    }

    @Test
    void testLowPivotQuickSort() {
        final var lowPivotQuickSort = Main.getLowPivotQuickSort();
        assertThat(lowPivotQuickSort).isNotNull();

        final var randomArrayGenerator = Main.getRandomArrayGenerator();
        assertThat(randomArrayGenerator).isNotNull();

        final String[] array = randomArrayGenerator.generate(10);
        assertThat(array)
                .isNotNull()
                .hasSize(10);

        lowPivotQuickSort.sort(array);

        for (int i = 1; i < array.length; i++) {
            assertThat(array[i])
                    .isNotNull()
                    .isGreaterThanOrEqualTo(array[i - 1]);
        }
    }

    @Test
    void testRandomPivotQuickSort() {
        final var randomPivotQuickSort = Main.getRandomPivotQuickSort();
        assertThat(randomPivotQuickSort).isNotNull();

        final var randomArrayGenerator = Main.getRandomArrayGenerator();
        assertThat(randomArrayGenerator).isNotNull();

        final String[] array = randomArrayGenerator.generate(10);
        assertThat(array)
                .isNotNull()
                .hasSize(10);

        randomPivotQuickSort.sort(array);

        for (int i = 1; i < array.length; i++) {
            assertThat(array[i])
                    .isNotNull()
                    .isGreaterThanOrEqualTo(array[i - 1]);
        }
    }

}