package test;

public class DictionaryEntry {
    private String key;
    private String value;

    public DictionaryEntry(String k, String v) {
        key = k;
        value = v;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
