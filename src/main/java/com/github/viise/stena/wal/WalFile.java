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

package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.io.File;

/**
 * File protection.
 */
public final class WalFile implements Wall<File> {

    private final Wall<Object> walNotNull;

    public WalFile() {
        this.walNotNull = new WalNotNull();
    }

    /**
     * Protect file.
     *
     * @param fileName Protected file name.
     * @param file        Protected file.
     * @throws ProtectException If file is null and not exists.
     */
    @Override
    public void protect(final String fileName, final File file) throws ProtectException {
        String _fileName = fileName == null ? "file" : fileName;
        walNotNull.protect(_fileName, file);
        try {
            if (!file.exists()) {
                throw new ProtectException(String.format(
                        "%s with pathname '%s' is not exists.",
                        _fileName,
                        file.getAbsolutePath()
                ));
            }
        } catch (SecurityException e) {
            throw new ProtectException(String.format(
                    "%s : %s",
                    _fileName,
                    e.getMessage()), e);
        }
    }

    /**
     * Protect file. {@code fileName} is {@code "file"}.
     *
     * @param file Protected file.
     * @throws ProtectException If file is null and not exists.
     */
    @Override
    public void protect(final File file) throws ProtectException {
        protect("file", file);
    }
}
