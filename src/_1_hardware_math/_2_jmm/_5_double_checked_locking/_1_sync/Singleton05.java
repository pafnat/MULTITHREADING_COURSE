package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
//… Всегда видим инициализированное Singleton.getInstance()!=null: Да
//… Всегда видим инициализированное Singleton.getInstance().state==1: Да
// СИНГЛЕТОННОСТЬ (базовые качества):
//… Будет создан единственные экземпляр Singleton: Да
//… Все видят один и тот же экземпляр Singleton: Да
// СИНГЛЕТОННОСТЬ (дополнительные качества):
//… Ленивая инициализация: Да
// - //… Доступ к полю 'instance' обходится без синхронизации: Нет
// - //… Доступ Доступ к полю 'state' обходится без синхронизации: Нет
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле 'instance': Да
//… Нельзя изменить поле 'state': Да
public class Singleton05<K, V> {
    private static final Lock staticLock = new ReentrantLock();
    private static final ReadWriteLock instanceLock = new ReentrantReadWriteLock();
    private static final Lock instanceReadLock = instanceLock.readLock();
    private static final Lock instanceWriteLock = instanceLock.writeLock();
    private Map<K, V> state;

    private Singleton05() {
        this.state = new HashMap<>();
    }

    public V get(K key) {
        instanceReadLock.lock();
        try {
            return state.get(key);
        } finally {
            instanceReadLock.unlock();
        }
    }

    public synchronized void put(K key, V value) {
        instanceWriteLock.lock();
        try {
            state.put(key, value);
        } finally {
            instanceWriteLock.unlock();
        }
    }

    private static Singleton05 instance;

    public static Singleton05 getInstance() {
        staticLock.lock();
        try {
            if (instance == null) {
                instance = new Singleton05();
            }
            return instance;
        } finally {
            staticLock.unlock();
        }
    }
}
