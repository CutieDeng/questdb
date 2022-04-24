/*******************************************************************************
 *     ___                  _   ____  ____
 *    / _ \ _   _  ___  ___| |_|  _ \| __ )
 *   | | | | | | |/ _ \/ __| __| | | |  _ \
 *   | |_| | |_| |  __/\__ \ |_| |_| | |_) |
 *    \__\_\\__,_|\___||___/\__|____/|____/
 *
 *  Copyright (c) 2014-2019 Appsicle
 *  Copyright (c) 2019-2022 QuestDB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ******************************************************************************/

package io.questdb.griffin;

import org.junit.Test;

public class DefaultClauseTest extends AbstractGriffinTest{

    /**
     * This is a normal test to check the correctness of the compiler. It's a 'reference' object.
     * @throws Exception The exception may be thrown in this lambda function, which means it won't happen in this test.
     */
    @Test
    public void testWithoutDefault() throws Exception {
        assertMemoryLeak(() -> compiler.compile("create table long_table_name (age int)", sqlExecutionContext));
    }

    /**
     * This is a simple test to use the `default` clause. The expected action is that, the compiler should recognize it as a correct sentence according to the grammar.
     * This test just describe a table creation execution statements : val int default 1.
     * The first step to achieve it is make the compiler correctly recognize or ignore these words just like a dialect.
     * Because it doesn't cause a big problem when we expect a default value but miss it in a database table.
     * After reach it, we can make a more compatible db to execute the sql statements from other dbs.
     * The second step is similar, but truly provide the default value generating functions.
     * @throws Exception If the compiler cannot understand the correctness of it, the sqlException would be thrown.
     */
    @Test
    public void testWithSimpleDefault() throws Exception {
        assertMemoryLeak(() -> compiler.compile("create table default_table (val int default 1)", sqlExecutionContext));
    }

}
