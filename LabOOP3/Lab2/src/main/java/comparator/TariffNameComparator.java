package org.example.comparator;
import org.example.model.Tariff;

import java.util.Comparator;
public class TariffNameComparator implements Comparator<Tariff> {
    @Override
    public int compare(Tariff t1, Tariff t2) {
        return t1.getName().compareToIgnoreCase(t2.getName());
    }
}
