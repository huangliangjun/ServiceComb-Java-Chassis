/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.foundation.metrics;

import org.junit.Assert;
import org.junit.Test;

import io.servicecomb.foundation.metrics.performance.PerfStatSuccFail;

public class TestMetrics {

  @Test
  public void testOnCycle() throws Exception {
    PerfStatSuccFail oPerfStatSuccFail = Metrics.getOrCreateLocalPerfStat("test", 1);
    Metrics.onCycle();
    Assert.assertEquals(0, Metrics.getMsTick());
    Assert.assertEquals(1, Metrics.getMonitorPerfStat().size());
    Assert.assertEquals("test", oPerfStatSuccFail.getName());
    Assert.assertEquals(2, oPerfStatSuccFail.getPerfStatDataList().size());
  }
}
