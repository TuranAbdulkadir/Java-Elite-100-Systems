package Markdown_To_HTML_Converter;

public class Main {
    public static void main(String[] args) {
        String md = "# Hello World\nThis is **bold** text and this is *italic*.";
        System.out.println("[MD] Source:\n" + md);
        
        String html = convert(md);
        System.out.println("\n[HTML] Output:\n" + html);
    }
    
    static String convert(String md) {
        String html = md;
        // Convert Headers
        html = html.replaceAll("# (.*)", "<h1>$1</h1>");
        // Convert Bold
        html = html.replaceAll("\\*\\*(.*?)\\*\\*", "<b>$1</b>");
        // Convert Italic
        html = html.replaceAll("\\*(.*?)\\*", "<i>$1</i>");
        return html;
    }
}