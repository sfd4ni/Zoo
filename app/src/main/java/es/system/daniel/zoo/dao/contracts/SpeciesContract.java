package es.system.daniel.zoo.dao.contracts;

import android.provider.BaseColumns;

public class SpeciesContract  {

    public static abstract class SpeciesEntry implements BaseColumns {
        public static final String TABLE_NAME ="species";
        public static final String VULGAR_NAME = "vulgarName";
        public static final String SCIENTIFIC_NAME = "scientificName";
        public static final String FAMILY = "family";
        public static final String ENDANGERED = "endangered";
    }
}
