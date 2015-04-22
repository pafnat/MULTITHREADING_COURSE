package _1_hardware_math._0_hardware.cache;

import _1_hardware_math._0_hardware.cache_L1_size.CacheL1SizeDetector;
import _1_hardware_math._0_hardware.cache_L2_size.CacheL2SizeDetector;
import _1_hardware_math._0_hardware.cache_line.CacheLineDetector;

/**
 * Написать утилитарный класс (в варианте A или в обоих вариантах (А и В)), который возвращает следующие характеристики процессора
 — размер кэш-линии
 — количество и размеры кэшей (L1, L2, L3)
 — количество ядер
 — определяет SMP или NUMA архитектура
 A) путем «постановки программных экспериментов». Рекомендуется прочитать статью «Gallery of Processor Cache Effects»[http://igoro.com/archive/gallery-of-processor-cache-effects/] (на лекции #2 разберем примеры из статьи и наметим пути решения задачи)
 B) путем использования JNA для вызовов API операционной системы
 public class HardwareSpy {
 public int cacheLineSize() {...}
 public int cacheL1Size() {...} // -1 если считается, что нет L1
 public int cacheL2Size() {...} // -1 если считается, что нет L2
 public int cacheL3Size() {...} // -1 если считается, что нет L3
 public int coreCount() {...}
 public int isSMP() {...}
 public int isNUMA() {...}
 }
 */

public class HardwareSpy {

    public static void cacheLine() {

        CacheLineDetector.main(null);

    }

    public static void cache_l1_size() {

        CacheL1SizeDetector.main(null);
    }

    public static void cache_l2_size() {

        CacheL2SizeDetector.main(null);

    }
    public static void main(String[] args) {


        cache_l2_size();

    }
}
