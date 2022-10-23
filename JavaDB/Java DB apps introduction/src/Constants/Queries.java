package Constants;

public enum Queries {
    ;

    public static final String INSERT_MINION_QUERY = "INSERT INTO `minions`(`name`, `age`, `town_id`) VALUES(?, ?, ?);";

    public static final String GET_TOWN_ID_QUERY = "SELECT `id` FROM `towns` WHERE `name` = ?;";

    public static final String INSERT_TOWN_QUERY = "INSERT INTO towns(`name`) VALUES(?);";

    public static final String GET_VILLAIN_NAME_AND_ID_QUERY = "SELECT `id`, `name` FROM `villains` WHERE `name` = ?;";

    public static final String INSERT_VILLAIN_QUERY = "INSERT INTO `villains`(`name`, `evilness_factor`) VALUES(?, ?);";

    public static final String SET_MINION_TO_VILLAIN_QUERY = "INSERT INTO `minions_villains`(`minion_id`, `villain_id`) VALUES(?, ?);";

    public static final String GET_MINION_ID_QUERY = "SELECT `id` FROM `minions` WHERE `name` = ?;";

    public static final String CHANGE_NAMES_OF_TOWNS_WITH_GIVEN_COUNTRY_TO_UPPER_QUERY = "UPDATE `towns`SET `name` = UPPER(`name`) WHERE `country` = ?;";

    public static final String GET_COUNT_OF_CHANGED_TOWNS_QUERY = "SELECT COUNT(`name`) AS 'count' FROM `towns` WHERE `country` = ?;";

    public static final String GET_NAMES_OF_TOWNS_QUERY = "SELECT `name` FROM `towns` WHERE `country` = ?;";

    public static final String GET_MINIONS_COUNT_QUERY = "SELECT COUNT(`minion_id`) AS 'count' FROM `minions_villains` AS mv GROUP BY mv.`villain_id` HAVING mv.`villain_id` = ?;";

    public static final String GET_VILLAIN_WITH_ID_QUERY = "SELECT `name` FROM `villains` WHERE `id` = ?;";

    public static final String DROP_FOREIGN_KEY_QUERY = "ALTER TABLE `minions_villains` " +
            "DROP FOREIGN KEY fk_villains_minions, " +
            "DROP FOREIGN KEY fk_minions_villains;";

    public static final String DELETE_FROM_VILLAINS_QUERY = "DELETE FROM `villains` WHERE `id` = ?;";

    public static final String DELETE_FROM_MINIONS_VILLAINS_QUERY = "DELETE FROM `minions_villains` WHERE `villain_id` = ?;";

    public static final String ADD_CONSTRAINTS_QUERY = "ALTER TABLE `minions_villains` " +
            "ADD CONSTRAINT fk_villains_minions FOREIGN KEY(`minion_id`) REFERENCES `minions`(`id`), " +
            "ADD CONSTRAINT fk_minions_villains FOREIGN KEY(`villain_id`) REFERENCES `villains`(`id`);";

    public static final String SELECT_NEXT_FROM_BEGINNING = "SELECT `name` FROM `minions` ORDER BY `id` LIMIT ?, 1 ;";

    public static final String SELECT_NEXT_FROM_END = "SELECT `name` FROM `minions` ORDER BY `id` DESC LIMIT ?, 1;";

    public static final String INCREASE_MINION_AGE_QUERY = "UPDATE `minions` SET `age` = `age` + 1 WHERE `id` = ?;";

    public static final String MAKE_MINION_NAME_TO_LOWER_CASE_QUERY = "UPDATE `minions` SET `name` = LOWER(`name`) WHERE `id` = ?;";

    public static final String GET_ALL_MINIONS_QUERY = "SELECT * FROM `minions`;";

    public static final String CALL_PROCEDURE_QUERY = "CALL usp_get_older(?);";

    public static final String GET_MINION_NAME_AND_AGE_WHOSE_IS_INCREASED_AGE = "SELECT `name`, `age` FROM `minions` WHERE `id` = ?";
}
