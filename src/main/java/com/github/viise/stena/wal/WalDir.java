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
 * Directory protection.
 */
public final class WalDir implements Wall<File> {

    private final Wall<File> walFile;

    public WalDir() {
        this.walFile = new WalFile();
    }

    /**
     * Protect directory.
     *
     * @param dirValName Protected directory name.
     * @param dir        Protected directory.
     * @throws ProtectException If directory is null and not exists, or file is not a directory.
     */
    @Override
    public void protect(final String dirValName, final File dir) throws ProtectException {
        String _dirValName = dirValName == null ? "directory" : dirValName;
        walFile.protect(_dirValName, dir);
        if (!dir.isDirectory()) {
            throw new ProtectException(String.format(
                    "%s is not a directory : '%s'.",
                    "directory".equals(_dirValName) ? "file" : _dirValName,
                    dir.getAbsolutePath()
            ));
        }
    }

    /**
     * Protect directory. {@code dirValName} is {@code "directory"}.
     *
     * @param file Protected directory.
     * @throws ProtectException If directory is null and not exists, or file is not a directory.
     */
    @Override
    public void protect(final File file) throws ProtectException {
        protect("directory", file);
    }
}
