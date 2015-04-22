package _1_hardware_math._2_jmm._5_double_checked_locking._4_data_race;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
//… Всегда видим инициализированное Singleton.getInstance()!=null: Да
//… Всегда видим инициализированное Singleton.getInstance().state==1: Да
// СИНГЛЕТОННОСТЬ (базовые качества):
// - //… Будет создан единственные экземпляр Singleton: Нет
// - //… Все видят один и тот же экземпляр Singleton: Нет
// СИНГЛЕТОННОСТЬ (дополнительные качества):
//… Ленивая инициализация: Да
//… Доступ к полю 'instance' обходится без синхронизации: Да
//… Доступ Доступ к полю 'state' обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле 'instance': Да
//… Нельзя изменить поле 'state': Да
public class Singleton00 {
    private final int state; // важно, что final
    private Singleton00(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static Singleton00 instance;
    public static Singleton00 getInstance() {
        Singleton00 tmp = instance;
        if (tmp == null) {
            tmp = new Singleton00(1);
            instance = tmp;
        }
        return tmp;
    }
}
