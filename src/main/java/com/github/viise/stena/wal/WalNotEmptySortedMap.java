package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Map;
import java.util.SortedMap;

/**
 * Not empty sortedMap protection.
 */
public final class WalNotEmptySortedMap implements Wall<SortedMap<?, ?>> {

    private final Wall<Map<?, ?>> walNotEmptyMap;

    public WalNotEmptySortedMap() {
        this.walNotEmptyMap = new WalNotEmptyMap();
    }

    /**
     * Protect sortedMap.
     *
     * @param srtMapName Protected sortedMap name.
     * @param srtMap     Protected sortedMap.
     * @throws ProtectException If sortedMap is null or empty.
     */
    @Override
    public void protect(final String srtMapName, final SortedMap<?, ?> srtMap) throws ProtectException {
        String _srtMapName = srtMapName == null ? "sortedMap" : srtMapName;
        walNotEmptyMap.protect(_srtMapName, srtMap);
    }

    /**
     * Protect sortedMap. {@code srtMapName} is {@code "sortedMap"}.
     *
     * @param srtMap Protected sortedMap.
     * @throws ProtectException If sortedMap is null or empty.
     */
    @Override
    public void protect(final SortedMap<?, ?> srtMap) throws ProtectException {
        protect("sortedMap", srtMap);
    }
}
