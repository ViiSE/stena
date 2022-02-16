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

import java.util.Collection;
import java.util.List;

/**
 * Not empty list protection.
 */
public final class WalNotEmptyList<T> implements Wall<List<T>> {

    private final Wall<Collection<T>> walNotEmptyCollection;

    public WalNotEmptyList() {
        this.walNotEmptyCollection = new WalNotEmptyCollection<>();
    }

    /**
     * Protect list.
     *
     * @param listName Protected list name.
     * @param list     Protected list.
     * @throws ProtectException If list is null or empty.
     */
    @Override
    public void protect(final String listName, final List<T> list) throws ProtectException {
        String _listName = listName == null ? "list" : listName;
        walNotEmptyCollection.protect(_listName, list);
    }

    /**
     * Protect list. {@code listName} is {@code "list"}.
     *
     * @param list Protected list.
     * @throws ProtectException If list is null or empty.
     */
    @Override
    public void protect(final List<T> list) throws ProtectException {
        protect("list", list);
    }
}
