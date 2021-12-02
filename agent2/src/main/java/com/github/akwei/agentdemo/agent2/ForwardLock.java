/*
 * Copyright (c) 2017, MegaEase
 * All rights reserved.
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

package com.github.akwei.agentdemo.agent2;


import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ForwardLock {
    private static final ThreadLocal<Set<ForwardLock>> MARK = ThreadLocal.withInitial(HashSet::new);

    public <T> Release<T> acquire(Supplier<T> supplier) {
        if (!MARK.get().add(this)) {
            return c -> {
            };
        }
        final T value = supplier.get();
        return c -> {
            c.accept(value);
            MARK.get().remove(ForwardLock.this);
        };
    }

    public interface Release<T> {
        void apply(Consumer<T> c);
    }

}
