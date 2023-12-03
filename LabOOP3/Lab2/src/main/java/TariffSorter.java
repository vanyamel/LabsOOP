package org.example;

import org.example.comparator.TariffNameComparator;
import org.example.comparator.TariffPayrollComparator;
import org.example.model.Tariff;

import java.util.Collections;
import java.util.List;

public class TariffSorter {
    public void sortTariffsByName(List<Tariff> tariffs) {
        Collections.sort(tariffs, new TariffNameComparator());
    }

    public void sortTariffsByPayroll(List<Tariff> tariffs) {
        Collections.sort(tariffs, new TariffPayrollComparator());
    }
}
