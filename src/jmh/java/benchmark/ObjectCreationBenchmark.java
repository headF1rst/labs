package benchmark;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
@Fork(1)
public class ObjectCreationBenchmark {

    @Benchmark
    public Object createNewObject() {
        return new Object();
    }

    @Benchmark
    public MyObject createNewMyObject() {
        return new MyObject();
    }

    @Benchmark
    public MyObject reuseMyObject() {
        return myObject;
    }

    private MyObject myObject = new MyObject();

    public static class MyObject {
        private String name = "MyObject";
        private int value = 77;
    }
}
