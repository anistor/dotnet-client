/* test jni api version */

package org.infinispan.client.hotrod.impl;

import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.infinispan.client.hotrod.exceptions.HotRodClientException;
import org.infinispan.client.hotrod.exceptions.RemoteCacheManagerNotStartedException;
import org.infinispan.client.hotrod.Flag;
import org.infinispan.client.hotrod.MetadataValue;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.ServerStatistics;
import org.infinispan.client.hotrod.VersionedValue;
import org.infinispan.commons.marshall.Marshaller;

public class RemoteCacheImpl<K, V> extends RemoteCacheUnsupported<K, V> {
    private Marshaller marshaller;
    private RemoteCacheManager remoteCacheManager;

    private cli.Infinispan.HotRod.Wrappers.RemoteCache jniRemoteCache;

    public RemoteCacheImpl(RemoteCacheManager manager, cli.Infinispan.HotRod.Wrappers.RemoteCache jniRemoteCache) {
        this.marshaller = manager.getMarshaller();
        this.remoteCacheManager = manager;
        this.jniRemoteCache = jniRemoteCache;
    }

    @Override
        public String getName() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.GetName();
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public String getVersion() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.GetVersion();
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public String getProtocolVersion() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.GetProtocolVersion();
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public void start() {
        // Nothing to do
    }

    @Override
        public void stop() {
        // Nothing to do
    }

    @Override
        public V put(K k, V v) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Put(marshal(k), marshal(v)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V put(K k, V v, long lifespan, TimeUnit lifespanTimeUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Put(marshal(k), marshal(v),
                                                    convert(lifespan), convert(lifespanTimeUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V put(K k, V v, long lifespan, TimeUnit lifespanTimeUnit, long maxIdle, TimeUnit maxIdleUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Put(marshal(k), marshal(v),
                                                    convert(lifespan), convert(lifespanTimeUnit),
                                                    convert(maxIdle), convert(maxIdleUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V get(K k) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Get(marshal(k)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean containsKey(K k) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.ContainsKey(marshal(k));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean containsValue(V v) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.ContainsValue(marshal(v));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V remove(K k) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Remove(marshal(k)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean removeWithVersion(K k, long version) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.RemoveWithVersion(marshal(k), convert(version));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V replace(K k, V v) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Replace(marshal(k), marshal(v)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V replace(K k, V v, long lifespan, TimeUnit lifespanTimeUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Replace(marshal(k), marshal(v),
                                                        convert(lifespan), convert(lifespanTimeUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V replace(K k, V v, long lifespan, TimeUnit lifespanTimeUnit, long maxIdle, TimeUnit maxIdleUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.Replace(marshal(k), marshal(v),
                                                        convert(lifespan), convert(lifespanTimeUnit),
                                                        convert(maxIdle), convert(maxIdleUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean replaceWithVersion(K k, V v, long version) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.ReplaceWithVersion(marshal(k), marshal(v),
                                                     convert(version));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }


    @Override
        public boolean replaceWithVersion(K k, V v, long version, int lifespanSeconds) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.ReplaceWithVersion(marshal(k), marshal(v),
                                                     convert(version),
                                                     convert(lifespanSeconds));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean replaceWithVersion(K k, V v, long version, int lifespanSeconds, int maxIdleTimeSeconds) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.ReplaceWithVersion(marshal(k), marshal(v),
                                                     convert(version),
                                                     convert(lifespanSeconds),
                                                     convert(maxIdleTimeSeconds));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V putIfAbsent(K k, V v) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.PutIfAbsent(marshal(k), marshal(v)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V putIfAbsent(K k, V v, long lifespan, TimeUnit lifespanTimeUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.PutIfAbsent(marshal(k), marshal(v),
                                                            convert(lifespan), convert(lifespanTimeUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public V putIfAbsent(K k, V v, long lifespan, TimeUnit lifespanTimeUnit, long maxIdle, TimeUnit maxIdleUnit) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return (V) unmarshal(jniRemoteCache.PutIfAbsent(marshal(k), marshal(v),
                                                            convert(lifespan), convert(lifespanTimeUnit),
                                                            convert(maxIdle), convert(maxIdleUnit)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public void putAll(Map<? extends K, ? extends V> map) {
        putAll(map, 0, TimeUnit.MILLISECONDS, 0, TimeUnit.MILLISECONDS);
    }

    @Override
        public void putAll(Map<? extends K, ? extends V> map, long lifespan, TimeUnit lifespanTimeUnit) {
        putAll(map, lifespan, lifespanTimeUnit, 0, TimeUnit.MILLISECONDS);
    }

    @Override
        public void putAll(Map<? extends K, ? extends V> map, long lifespan, TimeUnit lifespanTimeUnit, long maxIdle, TimeUnit maxIdleUnit) {
        if (!remoteCacheManager.isStarted()) {
            throw new RemoteCacheManagerNotStartedException(
                                                            "Cannot perform operations on a cache associated with an unstarted RemoteCacheManager. "
                                                            + "Use RemoteCacheManager.start before using the remote cache.");
        }
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue(), lifespan, lifespanTimeUnit, maxIdle, maxIdleUnit);
        }
    }

    @Override
        public void clear() {
        try {
            if (false) workaroundCLICheckedExceptions();
            jniRemoteCache.Clear();
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public boolean isEmpty() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return jniRemoteCache.IsEmpty();
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public VersionedValue<V> getVersioned(K k) {
        try {
            if (false) workaroundCLICheckedExceptions();
            cli.Infinispan.HotRod.Wrappers.VersionedValue vv = jniRemoteCache.GetVersioned(marshal(k));
            if (vv == null) {
                return null;
            }
            return new VersionedValueImpl<V>(vv.GetVersion(),
                                             (V) unmarshal(vv.GetValue()));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public MetadataValue<V> getWithMetadata(K k) {
        try {
            if (false) workaroundCLICheckedExceptions();
            cli.Infinispan.HotRod.Wrappers.MetadataValue mv = jniRemoteCache.GetWithMetadata(marshal(k));
            if (mv == null) {
                return null;
            }
            return new MetadataValueImpl<V>(mv.GetCreated(),
                                            mv.GetLifespan(),
                                            mv.GetLastUsed(),
                                            mv.GetMaxIdle(),
                                            mv.GetVersion(),
                                            (V) unmarshal(mv.GetValue()));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public Set<K> keySet() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return toKSet(jniRemoteCache.KeySet());
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public Map<K, V> getBulk() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return toKVMap(jniRemoteCache.GetBulk());
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public Map<K, V> getBulk(int size) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return toKVMap(jniRemoteCache.GetBulk(size));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    

    }

    @Override
        public RemoteCache<K, V> withFlags(Flag... flags) {
        try {
            if (false) workaroundCLICheckedExceptions();
            return new RemoteCacheImpl<K, V>(remoteCacheManager, jniRemoteCache.WithFlags(convert(flags)));
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public int size() {
        try {
            if (false) workaroundCLICheckedExceptions();
            return toInt(jniRemoteCache.Size());
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    @Override
        public ServerStatistics stats() {
        try {
            if (false) workaroundCLICheckedExceptions();
            String[][] statsMap = jniRemoteCache.Stats();

            ServerStatisticsImpl stats = new ServerStatisticsImpl();
            for (int i = 0; i < statsMap.length; i++) {
                stats.addStats(statsMap[i][0], statsMap[i][1]);
            }

            return stats;
        } catch (cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException ex) {
            throw new RemoteCacheManagerNotStartedException(ex.get_Message());
        } catch (cli.Infinispan.HotRod.Exceptions.HotRodClientException ex) {
            throw new HotRodClientException(ex.get_Message(), cause(ex.get_Message()));
        }
    
    }

    private byte[] marshal(Object obj) {
        try {
            return marshaller.objectToByteBuffer(obj);
        } catch (Exception ex) {
            throw new IllegalArgumentException(String.format("Failed to marshall %s", obj), ex);
        }
    }

    private Object unmarshal(byte[] buf) {
        if (buf == null) {
            return null;
        }
        try {
            return marshaller.objectFromByteBuffer(buf);
        } catch (Exception ex) {
            throw new IllegalArgumentException(String.format("Failed to unmarshall %s", Arrays.toString(buf)), ex);
        }
    }

    private cli.Infinispan.HotRod.TimeUnit convert(TimeUnit timeUnit) {
        switch(timeUnit) {
        case NANOSECONDS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.NANOSECONDS);
        case MICROSECONDS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.MICROSECONDS);
        case MILLISECONDS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.MILLISECONDS);
        case SECONDS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.SECONDS);
        case MINUTES:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.MINUTES);
        case HOURS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.HOURS);
        case DAYS:
            return cli.Infinispan.HotRod.TimeUnit.wrap(cli.Infinispan.HotRod.TimeUnit.DAYS);
        default:
            throw new IllegalArgumentException(String.format("Cannot map timeunit %s", timeUnit));
        }
    }

    private cli.Infinispan.HotRod.Flags convert(Flag... flags) {
        int result = 0;
        for (Flag flag : flags) {
            result = result | flag.getFlagInt();
        }
        return cli.Infinispan.HotRod.Flags.wrap(result);
    }

    private cli.System.UInt64 convert(long val) {
        if (val < 0) val = 0;
        return cli.System.UInt64.Parse(Long.toString(val));
    }

    private int toInt(cli.System.UInt64 val) {
        return Integer.parseInt(val.ToString());
    }

    private Set<K> toKSet(byte[][] data) {
        if (data == null) {
            return null;
        }
        Set<K> result = new HashSet<K>();
        for (int i = 0; i < data.length; i++) {
            result.add((K) unmarshal(data[i]));
        }
        return result;
    }

    private Map<K, V> toKVMap(byte[][][] data) {
        if (data == null) {
            return null;
        }
        Map<K, V> result = new HashMap<K, V>();
        for (int i = 0; i < data.length; i++) {
            result.put((K) unmarshal(data[i][0]),
                       (V) unmarshal(data[i][1]));
        }
        return result;
    }

    private Throwable cause(String message) {
        if ((message != null) && (message.contains("timeout"))) {
            return new SocketTimeoutException();
        }
        return null;
    }

    private void workaroundCLICheckedExceptions() throws
        cli.Infinispan.HotRod.Exceptions.HotRodClientException,
        cli.Infinispan.HotRod.Exceptions.RemoteCacheManagerNotStartedException {
        // Workaround. cli exceptions are not checked and don't extend RuntimeException.
    }
}
