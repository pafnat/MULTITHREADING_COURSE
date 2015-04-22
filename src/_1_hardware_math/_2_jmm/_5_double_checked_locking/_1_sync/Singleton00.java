package _1_hardware_math._2_jmm._5_double_checked_locking._1_sync;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
//… Всегда видим инициализированное Singleton.getInstance()!=null: Да
//… Всегда видим инициализированное Singleton.getInstance().getState()==1: Да
// СИНГЛЕТОННОСТЬ (базовые качества):
//… Будет создан единственные экземпляр Singleton: Да
//… Все видят один и тот же экземпляр Singleton: Да
// СИНГЛЕТОННОСТЬ (дополнительные качества):
//… Ленивая инициализация: Да
// - //… Доступ Singleton.getInstance() обходится без синхронизации: Нет
//… Доступ singleton.getState() обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле instance: Да
//… Нельзя изменить поле state: Да
public class Singleton00 {
    private int state;
    private Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static Singleton00 instance;
    public synchronized static Singleton00 getInstance() {
        if (instance == null) {
            instance = new Singleton00(1);
        }
        return instance;
    }
}
