/*
 * Copyright 2021 ViiSE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.viise.stena;

/**
 * Throws, if object has passed protection.
 *
 * @see Wall
 */
public class ProtectException extends Exception {

    /**
     * Ctor.
     *
     * @param message exception message.
     */
    public ProtectException(String message) {
        super(message);
    }

    /**
     * Ctor.
     *
     * @param message exception message.
     * @param t       Throwable.
     */
    public ProtectException(String message, Throwable t) {
        super(message, t);
    }
}
