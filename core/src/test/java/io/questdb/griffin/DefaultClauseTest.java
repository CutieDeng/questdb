package io.questdb.griffin;

import org.junit.Test;

import static io.questdb.griffin.AbstractGriffinTest.compiler;
import static io.questdb.griffin.AbstractGriffinTest.sqlExecutionContext;
import static io.questdb.test.tools.TestUtils.assertMemoryLeak;

public class DefaultClauseTest extends AbstractGriffinTest{

    @Test
    public void testWithoutDefault() throws Exception {
        assertMemoryLeak(() -> compiler.compile("create table long_table_name (age int)", sqlExecutionContext));
    }

    @Test
    public void testWithSimpleDefault() throws Exception {
        assertMemoryLeak(() -> compiler.compile("create table default_table (val int default 1)", sqlExecutionContext));
    }

}
