package SQL_Query_Parser_Mini;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT name, age FROM users WHERE id=5";
        System.out.println("[SQL] Parsing: " + sql);
        
        Pattern p = Pattern.compile("SELECT (.*?) FROM (.*?) WHERE (.*)");
        Matcher m = p.matcher(sql);
        
        if(m.find()) {
            System.out.println("   > Columns: " + m.group(1));
            System.out.println("   > Table: " + m.group(2));
            System.out.println("   > Condition: " + m.group(3));
        } else {
            System.out.println("Invalid SQL syntax.");
        }
    }
}