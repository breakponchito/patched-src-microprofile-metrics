/*
 **********************************************************************
 * Copyright (c) 2019, 2022 Contributors to the Eclipse Foundation
 *
 * See the NOTICES file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 **********************************************************************/
package org.eclipse.microprofile.metrics.tck.tags;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class CounterFieldTagBean {

    @Inject
    @Metric(name = "counterNameNoTag")
    private Counter counterOne;

    @Inject
    @Metric(name = "counterName", tags = {"number=two", "colour=red"})
    private Counter counterTwo;

    @Inject
    @Metric(name = "counterName", tags = {"number=three", "colour=blue"})
    private Counter counterThree;

    public void incrementOne(long n) {
        counterOne.inc(n);
    }

    public void incrementTwo(long n) {
        counterTwo.inc(n);
    }

    public void incrementThree(long n) {
        counterThree.inc(n);
    }
}
