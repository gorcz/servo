/**
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.servo.monitor;

import org.testng.annotations.Test;

import com.netflix.servo.annotations.DataSourceType;

import static org.testng.Assert.assertEquals;

public class DoubleGaugeTest extends AbstractMonitorTest<DoubleGauge> {
    @Override
    public DoubleGauge newInstance(String name) {
        return new DoubleGauge(MonitorConfig.builder(name).build());
    }

    @Test
    public void testSet() throws Exception {
        DoubleGauge gauge = newInstance("test");
        gauge.set(10.0);
        assertEquals(gauge.getValue().doubleValue(), 10.0);
    }

    @Test
    public void testGetConfig() throws Exception {
        DoubleGauge gauge = newInstance("test");
        MonitorConfig expectedConfig = MonitorConfig.builder("test")
                .withTag(DataSourceType.GAUGE).build();
        assertEquals(gauge.getConfig(), expectedConfig);
    }
}
