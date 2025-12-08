package org.skypro.skyshop.model.search;

public class SearchResult {

    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable s) {
        return new SearchResult(
                s.getId().toString(),
                s.getName(),
                s.getContentType()
        );
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContentType() { return contentType; }

}