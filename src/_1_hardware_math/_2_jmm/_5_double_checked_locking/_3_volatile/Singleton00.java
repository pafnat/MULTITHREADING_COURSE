package _1_hardware_math._2_jmm._5_double_checked_locking._3_volatile;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
//… Всегда видим инициализированное Singleton.getInstance()!=null: Да
//… Всегда видим инициализированное Singleton.getInstance().state==1: Да
// СИНГЛЕТОННОСТЬ (базовые качества):
// - //… Будет создан единственные экземпляр Singleton: Нет
// - //… Все видят один и тот же экземпляр Singleton: Нет
// СИНГЛЕТОННОСТЬ (дополнительные качества):
//… Ленивая инициализация: Да
// - //… Доступ к полю 'instance' обходится без синхронизации: Нет
//… Доступ Доступ к полю 'state' обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле 'instance': Нет
//… Нельзя изменить поле 'state': Нет
public class Singleton00 {
    private int state;
    public Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static volatile Singleton00 instance;
    public static Singleton00 getInstance() {
        if (instance == null) {
            instance = new Singleton00(1);
        }
        return instance;
    }
}
