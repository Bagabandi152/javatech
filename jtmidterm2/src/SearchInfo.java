public class SearchInfo {
    String  fileName;
    String searchVal;
    Integer count;

    public SearchInfo(String fileName, String searchVal, Integer count) {
        this.fileName = fileName;
        this.searchVal = searchVal;
        this.count = count;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSearchVal() {
        return searchVal;
    }

    public void setSearchVal(String searchVal) {
        this.searchVal = searchVal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
