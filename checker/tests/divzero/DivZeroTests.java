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

    @MaybeZero
    int divideMZ(@MaybeZero int mz, @NonZero int nz) {
        return mz / nz;
    }

    @NonZero
    int divideNZ(@NonZero int mz, @NonZero int nz) {
        return mz / nz;
    }

    void testDivision(@MaybeZero int mz, @NonZero int nz) {
        // valid operations for division
        @MaybeZero int a = divideMZ(mz, nz);
        @NonZero int d = divideNZ(nz, nz);
        // :: error: (argument.type.incompatible)
        @MaybeZero int b = divideMZ(nz, mz);
        @MaybeZero int c = divideMZ(nz, nz);
    }
}
