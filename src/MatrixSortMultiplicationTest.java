import org.junit.Test;


public class MatrixSortMultiplicationTest {

    @Test(expected=NullPointerException.class)
    public void testAIsZero() throws IllegalConstructorArguments, NullPointerException {
        System.out.println("A is Null test started");
        Double a[][] = null;
        Double b[][] = {{1d,1d},{1d,1d}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("A is Null test finished");
    }

    @Test(expected=NullPointerException.class)
    public void testBIsZero() throws IllegalConstructorArguments, NullPointerException {
        System.out.println("B is Null test started");
        Double a[][] = {{1d,1d},{1d,1d}};
        Double b[][] = null;
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("B is Null test finished");
    }

    @Test(expected=NullPointerException.class)
    public void testAAndBIsZero() throws IllegalConstructorArguments, NullPointerException {
        System.out.println("Both is Null test started");
        Double a[][] = null;
        Double b[][] = null;
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Both is Null test finished");
    }

    @Test(expected=IllegalConstructorArguments.class)
    public void testAAndBIsNotMatch()throws IllegalConstructorArguments, NullPointerException {
        System.out.println("Dimensions not match test started");
        Double a[][] = {{1d,1d},{1d,1d}};
        Double b[][] = {{1d,1d},{1d,1d},{1d,1d}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Dimensions not match test finished");
    }

    @Test
    public void testIntInitialization() throws IllegalConstructorArguments, NullPointerException{
        System.out.println("Int values initialization test started");
        Integer a[][] = {{1,1},{1,1}};
        Integer b[][] = {{1,1},{1,1}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Int values initialization test finished");
    }

    @Test
    public void testLongInitialization() throws IllegalConstructorArguments, NullPointerException {
        System.out.println("Long values initialization test started");
        Long a[][] = {{1l,1l},{1l,1l}};
        Long b[][] = {{1l,1l},{1l,1l}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Long values initialization test finished");
    }

    @Test
    public void testFloatInitialization() throws IllegalConstructorArguments, NullPointerException{
        System.out.println("Float values initialization test started");
        Float a[][] = {{1f,1f},{1f,1f}};
        Float b[][] = {{1f,1f},{1f,1f}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Float values initialization test finished");
    }

    @Test
    public void testDoubleInitialization()throws IllegalConstructorArguments, NullPointerException{
        System.out.println("Double values initialization test started");
        Double a[][] = {{1d,1d},{1d,1d}};
        Double b[][] = {{1d,1d},{1d,1d}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        System.out.println("Double values initialization test finished");
    }

    @Test
    public void testCalculation()throws IllegalConstructorArguments, NullPointerException{
        System.out.println("Calculation test started");
        Double a[][] = {{1d,2d},{3d,4d},{5d,6d}};
        Double b[][] = {{1d,2d},{3d,4d}};
        MatrixThreadMultiplication c = new MatrixThreadMultiplication(a,b);
        c.getResult();
        System.out.println(c);
        System.out.println("Calculation test finished");
    }
}