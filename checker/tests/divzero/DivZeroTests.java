import org.checkerframework.checker.divzero.qual.MaybeZero;
import org.checkerframework.checker.divzero.qual.NonZero;

public class DivZeroTests {
    void testMultiplication(@MaybeZero int mz, @NonZero int nz) {
        @MaybeZero int a = nz * mz;
        @MaybeZero int b = mz * nz;
        @NonZero int c = nz * nz;
        @MaybeZero int d = mz * mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int e = nz * mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int f = mz * nz;
    }

    void testAddition(@MaybeZero int mz, @NonZero int nz) {
        @MaybeZero int a = nz + mz;
        @MaybeZero int b = mz + nz;
        @NonZero int c = nz + nz;
        @MaybeZero int d = mz + mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int e = nz + mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int f = mz + nz;
    }

    void testSubtraction(@MaybeZero int mz, @NonZero int nz) {
        @MaybeZero int a = nz - mz;
        @MaybeZero int b = mz - nz;
        @MaybeZero int c = mz - mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int e = nz + mz;
        // :: error: (assignment.type.incompatible)
        @NonZero int f = mz + nz;
    }

    int divide(@MaybeZero int mz, @NonZero int nz) {
        return mz / nz;
    }

    void testDivision(@MaybeZero int mz, @NonZero int nz) {
        // valid operations for division
        @MaybeZero int a = divide(mz, nz);
        // :: error: (argument.type.incompatible)
        @MaybeZero int b = divide(nz, mz);
        @MaybeZero int c = divide(nz, nz);
    }
}
