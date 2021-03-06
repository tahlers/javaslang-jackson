package javaslang.jackson.datatype.tuples;

import com.fasterxml.jackson.databind.JsonMappingException;
import javaslang.Tuple;
import javaslang.Tuple0;
import javaslang.Tuple2;
import javaslang.Tuple3;
import javaslang.jackson.datatype.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TupleXTest extends BaseTest {

    @Test
    public void test0() throws IOException {
        Tuple0 tuple0 = Tuple0.instance();
        String json = mapper().writer().writeValueAsString(tuple0);
        Assert.assertEquals(mapper().readValue(json, Tuple0.class), tuple0);
        Assert.assertEquals(mapper().readValue(json, Tuple.class), tuple0);
    }

    @Test(expected = JsonMappingException.class)
    public void test9() throws IOException {
        String wrongJson = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
        mapper().readValue(wrongJson, Tuple.class);
    }

    @Test(expected = JsonMappingException.class)
    public void test10() throws IOException {
        String json = "[1, 2, 3]";
        mapper().readValue(json, Tuple2.class);
    }

    @Test(expected = JsonMappingException.class)
    public void test11() throws IOException {
        String json = "[1, 2]";
        mapper().readValue(json, Tuple3.class);
    }
}
