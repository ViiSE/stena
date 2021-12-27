package com.github.viise.stena.wal;

import com.github.viise.stena.ProtectException;
import com.github.viise.stena.Wall;

import java.util.Map;
import java.util.NavigableMap;

/**
 * Not empty navigableMap protection.
 */
public final class WalNotEmptyNavigableMap implements Wall<NavigableMap<?, ?>> {

    private final Wall<Map<?, ?>> walNotEmptyMap;

    public WalNotEmptyNavigableMap() {
        this.walNotEmptyMap = new WalNotEmptyMap();
    }

    /**
     * Protect navigableMap.
     *
     * @param navMapName Protected navigableMap name.
     * @param navMap     Protected navigableMap.
     * @throws ProtectException If navigableMap is null or empty.
     */
    @Override
    public void protect(final String navMapName, final NavigableMap<?, ?> navMap) throws ProtectException {
        String _navMapName = navMapName == null ? "navigableMap" : navMapName;
        walNotEmptyMap.protect(_navMapName, navMap);
    }

    /**
     * Protect navigableMap. {@code navMapName} is {@code "navigableMap}.
     *
     * @param navMap Protected navigableMap.
     * @throws ProtectException If navigableMap is null or empty.
     */
    @Override
    public void protect(final NavigableMap<?, ?> navMap) throws ProtectException {
        protect("navigableMap", navMap);
    }
}
