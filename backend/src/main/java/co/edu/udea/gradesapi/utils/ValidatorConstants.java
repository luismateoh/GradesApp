package co.edu.udea.gradesapi.utils;

public class ValidatorConstants {
    //Validators
    public static final String REGEX_EMAIL =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final int MIN_SIZE_EMAIL = 5;
    public static final int MAX_SIZE_EMAIL = 50;

    public static final int MIN_SIZE_NAME = 2;
    public static final int MAX_SIZE_NAME = 100;

    public static final int MIN_SIZE_PASSWORD = 8;
    public static final int MAX_SIZE_PASSWORD = 16;

    public static final int MIN_SIZE_ADDRESS = 1;
    public static final int MAX_SIZE_ADDRESS = 50;

    public static final int MIN_SIZE_WEB = 6;
    public static final int MAX_SIZE_WEB = 50;

    public static final int MIN_SIZE_ID = 5;
    public static final int MAX_SIZE_ID = 12;

    public static final int MIN_SIZE_LASTNAME = 1;
    public static final int MAX_SIZE_LASTNAME = 25;

    public static final int MAX_SIZE_DESCRIPTION = 100;

    public static final String ID_NUMBER = "^\\d+$";


    //Año de 1900 a 2099
    public static final String REGEX_MODEL =
            "^(19|20)\\d{2}$";


    //Messages
    public static final String BAD_FORMAT_EMAIL_MESSSAGE = "Email bad format";
    public static final String BAD_SIZE_EMAIL_MESSSAGE = "email must be between 5 and 20 characters";
    public static final String BAD_SIZE_PASSWORD_MESSAGE = "password must be between 8 and 15 characters";
    public static final String BAD_SIZE_NAME_MESSSAGE = "name must be between 5 and 20 characters";
    public static final String BAD_SIZE_ID_MESSSAGE = "ID must be between 5 and 12 characters";
    public static final String BAD_SIZE_LASTNAME_MESSSAGE = "Last name must be between 1 and 25 characters";
    public static final String BAD_SIZE_TYPE_MESSSAGE = "Type must be between 2 and 15 characters";
    public static final String BAD_SIZE_MARK_MESSSAGE = "Mark must be between 2 and 15 characters";
    public static final String BAD_SIZE_CAPACITY_MESSSAGE = "Capacity must be between 1 and 2 characters";
    public static final String BAD_SIZE_COLOR_MESSSAGE = "Color must be between 3 and 10 characters";
}
