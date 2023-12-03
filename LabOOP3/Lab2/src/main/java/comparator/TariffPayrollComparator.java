package org.example.comparator;

import org.example.model.Tariff;

import java.util.Comparator;

public class TariffPayrollComparator implements Comparator<Tariff> {
    @Override
    public int compare(Tariff t1, Tariff t2) {
        return Double.compare(t1.getPayroll(), t2.getPayroll());
    }
}
