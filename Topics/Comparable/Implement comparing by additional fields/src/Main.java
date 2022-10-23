class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        int comparisonResult = 0;
        if (this.getSize() == otherArticle.getSize()) {
            comparisonResult = this.getTitle().compareTo(otherArticle.getTitle());
        } else if (this.getSize() < otherArticle.getSize()) {
            comparisonResult = -1;
        } else {
            comparisonResult = 1;
        }
        return comparisonResult;
    }
}