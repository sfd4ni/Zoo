package es.system.daniel.zoo.dao.contracts;

import android.provider.BaseColumns;

public class AnimalContract {
    public static abstract class AnimalEntry implements BaseColumns {
        public static final String TABLE_NAME ="animal";
        public static final String SEX = "sex";
        public static final String COUNTRY = "country";
        public static final String CONTINENT = "continent";
        public static final String SPECIES_ID = "species_id";
        public static final String ZOO_ID = "zoo_id";
        public static final String BIRTH_YEAR = "birthYear";
    }
}
