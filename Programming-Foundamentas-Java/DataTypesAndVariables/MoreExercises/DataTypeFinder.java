package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String dataType = line;
            if (dataType.length() == 0) {
                line = scanner.nextLine();
                continue;
            }

            if (getIsIntegerType(dataType)) {
                System.out.printf("%s is integer type%n", dataType);
            } else if (getIsFloatingPointType(dataType)) {
                System.out.printf("%s is floating point type%n", dataType);
            } else if (getIsCharacterType(dataType)) {
                System.out.printf("%s is character type%n", dataType);
            }else if (getIsBooleanType(dataType)){
                System.out.printf("%s is boolean type%n",dataType);
            }else{
                System.out.printf("%s is string type%n",dataType);
            }


            line = scanner.nextLine();
        }
    }

    private static boolean getIsBooleanType(String dataType) {
        dataType = dataType.toLowerCase();
        return dataType.equals("true") || dataType.equals("false");

    }

    private static boolean getIsCharacterType(String dataType) {
        return dataType.length() == 1;
    }

    private static boolean getIsFloatingPointType(String dataType) {


        if (dataType.length() <= 2) {
            return false;
        }
        boolean isDecimal = false;
        for (int i = 0; i < dataType.length() - 2; i++) {
            boolean isDigitTheLastCharacter = dataType.charAt(dataType.length() - 1) >= 48 && dataType.charAt(dataType.length() - 1) <= 57;
            if (dataType.charAt(0) == 45) {
                if ((dataType.charAt(1) >= 48 && dataType.charAt(1) <= 57) && isDigitTheLastCharacter) {
                    if (!((dataType.charAt(i + 1) >= 48 && dataType.charAt(i + 1) <= 57) || dataType.charAt(i + 1) == 46)) {
                        return false;
                    } else {
                        if (dataType.charAt(i + 1) == 46) {
                            if (isDecimal) {
                                return false;
                            }

                            isDecimal = true;
                        }
                    }
                } else {
                    return false;
                }
            } else if (dataType.charAt(0) >= 48 && dataType.charAt(0) <= 57) {
                if (isDigitTheLastCharacter) {
                    if (!(dataType.charAt(i + 1) >= 48 && dataType.charAt(i + 1) <= 57 || dataType.charAt(i + 1) == 46)) {
                        return false;
                    } else {
                        if (dataType.charAt(i + 1) == 46) {
                            if (isDecimal) {
                                return false;
                            }

                            isDecimal = true;
                        }
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean getIsIntegerType(String dataType) {
        boolean isOneDigit = dataType.charAt(0) >= 48 && dataType.charAt(0) <= 57;
        for (int i = 0; i < dataType.length() - 1; i++) {
            boolean isDigit = dataType.charAt(i + 1) >= 48 && dataType.charAt(i + 1) <= 57;
            if (dataType.charAt(0) == 45) {
                if (!(isDigit)) {
                    return false;
                }
            } else if (isOneDigit) {
                if (!isDigit) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (dataType.length() == 1) {
            if (!isOneDigit) {
                return false;
            }
        }
        return true;
    }
}
