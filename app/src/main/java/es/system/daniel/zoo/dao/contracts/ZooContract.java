package es.system.daniel.zoo.dao.contracts;

import android.provider.BaseColumns;

public class ZooContract {
    public static abstract class ZooEntry implements BaseColumns {
        public static final String TABLE_NAME ="zoo";
        public static final String NAME = "name";
        public static final String CITY = "city";
        public static final String COUNTRY = "country";
        public static final String SIZE = "size";
        public static final String YEARLY_INCOME = "yearlyIncome";
    }
}
