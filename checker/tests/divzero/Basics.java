import org.checkerframework.checker.divzero.qual.MaybeZero;
import org.checkerframework.checker.divzero.qual.NonZero;

/** Basic test of subtyping. */
public class Basics {
    void testHierarchy(@MaybeZero int mz, @NonZero int nz) {
        @MaybeZero int a = mz;
        @MaybeZero int b = nz;
        // :: error: (assignment.type.incompatible)
        @NonZero int c = mz; // expected error on this line
        @NonZero int d = nz;
    }
}
