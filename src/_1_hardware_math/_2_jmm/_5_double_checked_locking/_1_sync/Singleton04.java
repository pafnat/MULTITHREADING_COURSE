package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

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
public class Singleton04 {
    // разнесли блокировки
    // добавили private mutex: http://c2.com/cgi/wiki?PrivateMutex
    private static final Object staticLock = new Object();
    private static final Object instanceLock = new Object();
    private int state;

    private Singleton04(int state) {
        this.state = state;
    }

    public int getState() {
        synchronized (instanceLock) {
            return state;
        }
    }

    public synchronized void setState(int state) {
        synchronized (instanceLock) {
            this.state = state;
        }
    }

    private static Singleton04 instance;

    public static Singleton04 getInstance() {
        synchronized (staticLock) {
            if (instance == null) {
                instance = new Singleton04(1);
            }
        }
        return instance;
    }
}
