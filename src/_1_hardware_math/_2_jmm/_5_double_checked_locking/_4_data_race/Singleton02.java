package _1_hardware_math._2_jmm._5_double_checked_locking._4_data_race;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
// - //… Всегда видим инициализированное Singleton.getInstance()!=null: Нет
// - //… Всегда видим инициализированное Singleton.getInstance().state==1: Да
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
public class Singleton02 {
    private int state; // важно, что НЕ final
    private Singleton02(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static Singleton02 instance;
    public static Singleton02 getInstance() {
        Singleton02 tmp = instance;
        if (tmp == null) {
            tmp = new Singleton02(1);
            instance = tmp;
        }
        return tmp;
    }
}
