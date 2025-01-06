package ru.vsu.cs.vereschagin.lab6;

public enum BookCategory {
    FICTION {
        @Override
        public String getDescription() {
            return "Художественная литература";
        }
    },
    NON_FICTION {
        @Override
        public String getDescription() {
            return "Документальная литература";
        }
    },
    SCIENCE {
        @Override
        public String getDescription() {
            return "Научная литература";
        }
    },
    HISTORY {
        @Override
        public String getDescription() {
            return "Историческая литература";
        }
    },
    BIOGRAPHY {
        @Override
        public String getDescription() {
            return "Биография";
        }
    };

    public abstract String getDescription();
}
