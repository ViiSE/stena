/*
 * Copyright 2022 ViiSE
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

package com.github.viise.stena;

/**
 * Object protection.
 * {@code obj} is object to be protected. {@code objName} is the name of {@code obj}. If {@code objName} is null, then
 * specified by implementation. {@code objName} used for exception message.
 * Pay attention: this logic must be implemented in every implementation.
 *
 * @param <O> Object to be protected.
 */
public interface Wall<O> {
    /**
     * @param objName Name of protected object.
     * @param obj     Protected object.
     * @throws ProtectException If object has passed protection.
     */
    void protect(final String objName, final O obj) throws ProtectException;

    /**
     * {@code objName} is specified by implementation.
     *
     * @param obj Protected object.
     * @throws ProtectException If object has passed protection.
     */
    void protect(final O obj) throws ProtectException;
}
