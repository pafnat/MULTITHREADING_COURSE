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
public class Singleton03 {
    private int state;
    private Singleton03(int state) {this.state = state;}

    public synchronized int getState() {
        return state;
    }

    public synchronized void setState(int state) {
        this.state = state;
    }

    private static Singleton03 instance;
    public synchronized static Singleton03 getInstance() {
        if (instance == null) {
            instance = new Singleton03(1);
        }
        return instance;
    }
}
