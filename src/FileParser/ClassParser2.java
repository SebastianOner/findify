package FileParser;

import SearchObjects.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassParser2 {
    public static String[] taboo = {"if", "else", "switch", "while", "return", "for", "do", "++", "--", "break;", "continue;", "System."};

    public static void main(String[] args) {
        String reptile = "/**\n" +
                " * The class {@code Date} represents a date.\n" +
                " * \n" +
                " * This class ensures, that the represented date is always a valid date. For\n" +
                " * example, the method {@link Date#toString()} will never return 31/2/2010.\n" +
                " *\n" +
                " */\n" +
                "public class Date {\n" +
                "  /**\n" +
                "   * the day of the date\n" +
                "   */\n" +
                "  private int day;\n" +
                "\n" +
                "  /**\n" +
                "   * the month of the date\n" +
                "   */\n" +
                "  private int month;\n" +
                "\n" +
                "  /**\n" +
                "   * the year of the date\n" +
                "   */\n" +
                "  private int year;\n" +
                "\n" +
                "  /**\n" +
                "   * Constructs a date that represents the current date\n" +
                "   */\n" +
                "  public Date() {\n" +
                "    this.day = Terminal.TODAYS_DAY;\n" +
                "    this.month = Terminal.TODAYS_MONTH;\n" +
                "    this.year = Terminal.TODAYS_YEAR;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Constructs a date with the given values.\n" +
                "   * \n" +
                "   * @param day   the day\n" +
                "   * @param month the month\n" +
                "   * @param year  the year\n" +
                "   */\n" +
                "  public Date(int day, int month, int year) {\n" +
                "    this.day = 1;\n" +
                "    // We choose a month with 31 days so that setter for days won't fail\n" +
                "    this.month = 1;\n" +
                "    // We choose a leapyear so that the day setter won't fail\n" +
                "    this.year = 2020;\n" +
                "    this.setDay(day);\n" +
                "    this.setMonth(month);\n" +
                "    this.setYear(year);\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the day of the date\n" +
                "   * \n" +
                "   * @return the day of the date\n" +
                "   */\n" +
                "  public int getDay() {\n" +
                "    return day;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the month of the date\n" +
                "   * \n" +
                "   * @return the month of the date\n" +
                "   */\n" +
                "  public int getMonth() {\n" +
                "    return month;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the year of the date\n" +
                "   * \n" +
                "   * @return the year of the date\n" +
                "   */\n" +
                "  public int getYear() {\n" +
                "    return year;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the days of this date since 01/01/1970.\n" +
                "   * \n" +
                "   * @return the days since 01/01/1970.\n" +
                "   */\n" +
                "  private int daysSince1970() {\n" +
                "    int days = 0;\n" +
                "\n" +
                "    // all former years\n" +
                "    for (int i = 1970; i < this.year; i++) {\n" +
                "      days += this.daysInYear(i);\n" +
                "    }\n" +
                "\n" +
                "    // all former months in this year\n" +
                "    for (int i = 1; i < this.month; i++) {\n" +
                "      days += this.daysInMonth(i, this.year);\n" +
                "    }\n" +
                "\n" +
                "    // all former days in this month\n" +
                "    days += this.day - 1;\n" +
                "\n" +
                "    return days;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the number of the days in the specified year.\n" +
                "   * \n" +
                "   * @param year the year\n" +
                "   * @return the number of the days in the specified year.\n" +
                "   */\n" +
                "  private int daysInYear(int year) {\n" +
                "    int days = 0;\n" +
                "\n" +
                "    for (int month = 1; month <= 12; month++) {\n" +
                "      days += this.daysInMonth(month, year);\n" +
                "    }\n" +
                "\n" +
                "    return days;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the days between the specified date and the date represented by this\n" +
                "   * instance.\n" +
                "   * \n" +
                "   * @param today the specified date\n" +
                "   * @return the days\n" +
                "   */\n" +
                "  public int getAgeInDaysAt(Date today) {\n" +
                "    return today.daysSince1970() - this.daysSince1970();\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the full years between the specified date and the date represented by\n" +
                "   * this instance.\n" +
                "   * \n" +
                "   * @param today the specified date\n" +
                "   * @return the full years\n" +
                "   */\n" +
                "  public int getAgeInYearsAt(Date today) {\n" +
                "    int age = today.year - this.year;\n" +
                "\n" +
                "    if (today.month > this.month) {\n" +
                "      // birthday was earlier this year\n" +
                "      return age;\n" +
                "    } else if (today.month < this.month) {\n" +
                "      // birthday is in a later month of this year\n" +
                "      return age - 1;\n" +
                "    } else {\n" +
                "      // birthday is in this month\n" +
                "      if (today.day >= this.day) {\n" +
                "        // earlier this month or today\n" +
                "        return age;\n" +
                "      } else {\n" +
                "        // later this month\n" +
                "        return age - 1;\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the number of the days in the specified month in the specified year.\n" +
                "   * For a <code>month</code> value of either 1, 3, 5, 7, 8, 10 or 12 this method\n" +
                "   * returns 31. For a <code>month</code> value of either 4, 6, 9 or 11 this\n" +
                "   * method returns 30. For a <code>month</code> value of 2 (February) the\n" +
                "   * returned value is either 28 or 29, depending on the specified year.\n" +
                "   * \n" +
                "   * @param month the month\n" +
                "   * @param year  the year\n" +
                "   * @return the number of the days in the specified month in the specified year.\n" +
                "   */\n" +
                "  private int daysInMonth(int month, int year) {\n" +
                "    switch (month) {\n" +
                "    case 1:\n" +
                "    case 3:\n" +
                "    case 5:\n" +
                "    case 7:\n" +
                "    case 8:\n" +
                "    case 10:\n" +
                "    case 12:\n" +
                "      return 31;\n" +
                "    case 4:\n" +
                "    case 6:\n" +
                "    case 9:\n" +
                "    case 11:\n" +
                "      return 30;\n" +
                "    case 2:\n" +
                "      return daysinFebruary(year);\n" +
                "    }\n" +
                "\n" +
                "    return -1;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns the number of days in the February of the specified year. This method\n" +
                "   * considers leap years.\n" +
                "   * \n" +
                "   * @param year the year\n" +
                "   * @return the number of days in the February of the specified year.\n" +
                "   */\n" +
                "  private int daysinFebruary(int year) {\n" +
                "    if (year % 4 != 0) {\n" +
                "      return 28;\n" +
                "    }\n" +
                "\n" +
                "    if ((year % 100 == 0) && (year % 400 != 0)) {\n" +
                "      return 28;\n" +
                "    }\n" +
                "\n" +
                "    return 29;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns a string representation of this date: day/month/year.\n" +
                "   * \n" +
                "   * @return a string representation of this date: day/month/year\n" +
                "   */\n" +
                "  public String toString() {\n" +
                "    return this.day + \"/\" + this.month + \"/\" + this.year;\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Sets the day of this date.\n" +
                "   * \n" +
                "   * If the specified day is < 1, then the day is set to 1. If the specified day\n" +
                "   * is greater than the number of days in the month of this date, then it is set\n" +
                "   * to the maximum value of days in the month of this date.\n" +
                "   * \n" +
                "   * @see Date#daysInMonth(int, int)\n" +
                "   * @param day the new day\n" +
                "   */\n" +
                "  public void setDay(int day) {\n" +
                "    if (day < 1) {\n" +
                "      this.day = 1;\n" +
                "    } else if (day > daysInMonth(this.month, this.year)) {\n" +
                "      this.day = daysInMonth(this.month, this.year);\n" +
                "    } else {\n" +
                "      this.day = day;\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Sets the month of this date.\n" +
                "   * \n" +
                "   * If the specified month is < 1, the month is set to 1. If the specified month\n" +
                "   * is > 12, the month is set to 12. If the new month has less days than the\n" +
                "   * current month, it may happen that the day of this date gets invalid. In this\n" +
                "   * case, the day of this date is set to the maximum value of the specified\n" +
                "   * month.\n" +
                "   * \n" +
                "   * @param month the new month\n" +
                "   */\n" +
                "  public void setMonth(int month) {\n" +
                "    if (month < 1) {\n" +
                "      this.month = 1;\n" +
                "    } else if (month > 12) {\n" +
                "      this.month = 12;\n" +
                "    } else {\n" +
                "      this.month = month;\n" +
                "    }\n" +
                "\n" +
                "    /*\n" +
                "     * To avoid that the day of this date gets invalid, execute the setDay() method\n" +
                "     * with the current day\n" +
                "     */\n" +
                "    this.setDay(this.day);\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Sets the year of this date.\n" +
                "   * \n" +
                "   * If the specified year is < 1970, then the year is set to 1970. If the\n" +
                "   * specified year is > 2100, then the year is set to 2100. In case the current\n" +
                "   * month of this date is February it may happen that the day of this date gets\n" +
                "   * invalid (a value of 29 in a leap year). In this case the day is set to 28.\n" +
                "   * \n" +
                "   * @param year the new year\n" +
                "   */\n" +
                "  public void setYear(int year) {\n" +
                "    if (year < 1970) {\n" +
                "      this.year = 1970;\n" +
                "    } else if (year > 2100) {\n" +
                "      this.year = 2100;\n" +
                "    } else {\n" +
                "      this.year = year;\n" +
                "    }\n" +
                "\n" +
                "    /*\n" +
                "     * To avoid that the day of this date gets invalid, execute the setDay() method\n" +
                "     * with the current day\n" +
                "     */\n" +
                "    this.setDay(this.day);\n" +
                "  }\n" +
                "\n" +
                "  /**\n" +
                "   * Returns true, if this instance and the specified {@link Date} equal.\n" +
                "   * \n" +
                "   * @param date the other date\n" +
                "   * @return true, if this instance and the specified {@link Date} equal\n" +
                "   */\n" +
                "  public boolean equals(Date date) {\n" +
                "    if (this == date) {\n" +
                "      return true;\n" +
                "    }\n" +
                "\n" +
                "    if (date == null) {\n" +
                "      return false;\n" +
                "    }\n" +
                "\n" +
                "    return this.day == date.day && this.month == date.month && this.year == date.year;\n" +
                "  }\n" +
                "\n" +
                "}\n";
        List<String> reptileLines = Arrays.asList(reptile.split("\n"));
        String[] a = refineText(reptileLines);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        ClassObject file = fileParser("Path", reptileLines);
        System.out.println("Size: " + file.getAttributes().size());
        System.out.println(file.toString());
    }

    public static ClassObject fileParser(String path, List<String> content) {
        String[] refinedText = refineText(content);
        int number = Integer.parseInt(refinedText[0].substring(0, refinedText[0].indexOf(' ')));
        ClassObject classObject = classHeadParser(refinedText[0]);
        classObject.setLine(number);
        classObject.setMethods(new ArrayList<>());
        classObject.setAttributes(new ArrayList<>());
        for (int i = 1; i < refinedText.length; i++) {
            String line = refinedText[i];
            if (line.contains(";")) {
                classObject.getAttributes().add(fieldParser(line, path));
            }
            if (line.contains("(") && line.contains(")")) {
                classObject.getMethods().add(methodParser(line, path));
            }
        }
        return classObject;

    }

    public static ClassObject classHeadParser(String head) {
        boolean[] checkList = new boolean[3];
        checkList[0] = head.contains("implements ");
        checkList[1] = head.contains("extends ");
        checkList[2] = head.contains("<") && head.contains(">");
        String name = "";
        ClassObject.InheritanceType type;
        ClassObject.ClassType classType;
        if (head.contains("abstract ")) {
            type = ClassObject.InheritanceType.ABSTRACT;
        } else if (head.contains("final ")) {
            type = ClassObject.InheritanceType.FINAL;
        } else {
            type = ClassObject.InheritanceType.DEFAULT;
        }
        if (head.contains("enum ")) {
            classType = ClassObject.ClassType.ENUM;
            name = head.substring(head.indexOf("enum") + 5);
        } else if (head.contains("interface ")) {
            classType = ClassObject.ClassType.INTERFACE;
            name = head.substring(head.indexOf("interface") + 10);
        } else {
            classType = ClassObject.ClassType.DEFAULT;
            name = head.substring(head.indexOf("class") + 6);
        }

        if (checkList[2]) {
            name = name.substring(0, name.indexOf("<"));
        } else {
            name = name.substring(0, name.indexOf(" "));
        }

        return new ClassObject(name, visibilityParser(head), checkList[1], checkList[2],
                checkList[0], type, classType, null);
    }

    /**
     * Creates a shorter, filtered version of the code, so it can be parsed easily.
     *
     * @param content: All the Code in a List with each line as an element
     * @return String[]: Filtered version with only necessary Code with index in front
     */
    public static String[] refineText(List<String> content) {
        for (int i = 0; i < content.size(); i++) {
            content.set(i, content.get(i).replaceAll("\\t", ""));
            content.set(i, content.get(i).replaceAll("  ", ""));
            if (!isLegalField(content.get(i))) {
                content.set(i, "");
            } else {
                if (content.get(i).contains("//")) {
                    String x = content.get(i);
                    content.set(i, x.substring(0, x.indexOf("//")));
                }
            }
        }
        boolean isMethod = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            if (isMethod && content.get(i).contains("}")) {
                isMethod = false;
                continue;
            }
            if (isMethod || content.get(i).startsWith("}"))
                continue;
            if (content.get(i).isEmpty() || content.get(i).isBlank()
                    || content.get(i).contains("import ") || content.get(i).contains("package ") || content.get(i).contains("this.")) {
                continue;
            }
            if (content.get(i).contains(")")) {
                isMethod = true;
            }
            result.append((i + 1) + " " + content.get(i) + "\n");
        }

        return result.toString().split("\n");
    }

    /**
     * @param content: String of the class/method/field
     * @return AccesModifier: Enum of visibility
     */
    public static SearchObject.AccessModifier visibilityParser(String content) {
        if (content.contains("public")) {
            return SearchObject.AccessModifier.PUBLIC;
        } else if (content.contains("private")) {
            return SearchObject.AccessModifier.PRIVATE;
        } else if (content.contains("protected")) {
            return SearchObject.AccessModifier.PROTECTED;
        } else {
            return SearchObject.AccessModifier.DEFAULT;
        }
    }


    public static String[] documentation() {
        return null;
    }

    /**
     * @param fieldString: Insert a single line of a Field (private int p)
     * @param path:        Path of .java
     * @return FieldObject: A FieldObject
     */
    public static FieldObject fieldParser(String fieldString, String path) {
        if (fieldString.contains("=")) {
            fieldString = fieldString.substring(0, fieldString.indexOf("="));
        }
        int number = 0;
        try {
            number = Integer.parseInt(fieldString.substring(0, fieldString.indexOf(' ')));
        } catch (Exception e) {
        }
        String[] stream = fieldString.split(" ");
        String name = stream[stream.length - 1];
        if (name.contains(";"))
            name = name.substring(0, name.length() - 1);
        FieldObject fieldObject = new FieldObject(name, visibilityParser(fieldString), path, 0, stream[stream.length - 2]);
        fieldObject.setLine(number);
        return fieldObject;
    }

    public static boolean isLegalField(String line) {
        for (int i = 0; i < taboo.length; i++) {
            if (line.contains(taboo[i])) {
                return false;
            }
        }
        if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*/") || line.contains("*")) {
            return false;
        }
        return true;
    }

    /**
     * @param method: String of the headerline of a method
     * @param path:   Path of .java
     * @return: MethodObject: A MethodObject with List of Parameters
     */
    public static MethodObject methodParser(String method, String path) {
        int number = Integer.parseInt(method.substring(0, method.indexOf(" ")));
        String[] front = method.substring(0, method.indexOf('(')).split(" ");
        String[] back = method.substring(method.indexOf('(') + 1, method.indexOf(')')).split(", ");
        MethodObject result = null;

        result = new MethodObject(front[front.length - 1], visibilityParser(method), path, 0, method.contains("static"), front[front.length - 2]);
        result.setLine(number);
        if (back[0].isEmpty()) {
            return result;
        }
        List<FieldObject> parameters = new ArrayList<>();
        for (String param : back) {
            parameters.add(fieldParser(param, path));
        }
        parameters.forEach(x -> x.setLine(number));
        result.setParameters(parameters);
        return result;
    }

}
