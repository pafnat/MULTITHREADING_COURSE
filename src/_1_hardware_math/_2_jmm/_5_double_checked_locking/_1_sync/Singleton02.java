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
//… Доступ Доступ к полю 'state' обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле 'instance': Да
//… Нельзя изменить поле 'state': Да
public class Singleton02 {
    // final не требуется для корректной синхронизации
    // так как чтение state идет через monitor_exit -> monitor_enter
    public final int state;
    private Singleton02(int state) {this.state = state;}

    private static Singleton02 instance;
    public synchronized static Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02(1);
        }
        return instance;
    }
}
