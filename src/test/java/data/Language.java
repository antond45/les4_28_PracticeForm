package data;

public enum Language {
        RU("Подходит — служба поддержки сайтов. Техническая поддержка, сопровождение, " +
        "доработка и администрирование сайта."),

        EN("Podhodit is a service of website support. Technical support, maintenance, " +
                "revision, and administration of the website.");
        public final String description;

        Language(String description) {
                this.description = description;
        }

}
