import org.checkerframework.checker.divzero.qual.IsZero;
import org.checkerframework.checker.divzero.qual.MaybeZero;

/** Basic test of subtyping. */
public class Basics {
    void testHierarchy(@MaybeZero int mz, @IsZero int z) {
        @MaybeZero int a = mz;
        @MaybeZero int b = z;
        // :: error: (assignment)
        @IsZero int c = mz; // expected error on this line
        @IsZero int d = z;
    }
}
