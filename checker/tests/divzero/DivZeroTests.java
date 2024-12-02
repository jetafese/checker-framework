import org.checkerframework.checker.divzero.qual.NonZero;
import org.checkerframework.checker.divzero.qual.MaybeZero;

public class DivZeroTests {
    void testDivision(@MaybeZero int mz, @NonZero int z) {
        @NonZero int a = z * mz;
        @NonZero int b = z / mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int c = mz; // expected error on this line
        @NonZero int d = z;
    }
}
