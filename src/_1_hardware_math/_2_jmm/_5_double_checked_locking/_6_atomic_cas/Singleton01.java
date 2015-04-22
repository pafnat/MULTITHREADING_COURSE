package _1_hardware_math._2_jmm._5_double_checked_locking._6_atomic_cas;

import java.util.concurrent.atomic.AtomicReference;

// ПОТОКОЗАЩИЩЕННАЯ ИНИЦИАЛИЗАЦИЯ (thread-safe publishing):
//… Всегда видим инициализированное Singleton.getInstance()!=null: Да
//… Всегда видим инициализированное Singleton.getInstance().x==1: Да
// СИНГЛЕТОННОСТЬ (базовые качества):
// - //… Будет создан единственные экземпляр Singleton: Нет
// - //… Все видят один и тот же экземпляр Singleton: Нет
// СИНГЛЕТОННОСТЬ (дополнительные качества):
//… Ленивая инициализация: Да
// - //… Доступ к полю 'instance' обходится без синхронизации: Нет
//… Доступ Доступ к полю 'x' обходится без синхронизации: Да
// НЕИЗМЕННОСТЬ (immutability):
//… Нельзя изменить поле 'instance': Да
//… Нельзя изменить поле 'x': Да
public class Singleton01 {
    private int state;
    private Singleton01(int state) {this.state = state;}
    public int getState() {return this.state;}

    private static AtomicReference<Singleton01> instance = new AtomicReference<>();
    public static Singleton01 getInstance() {
        // полный аналог volatile
        if (instance.get() == null) {
            instance.set(new Singleton01(1));
        }
        return instance.get();
    }
}
