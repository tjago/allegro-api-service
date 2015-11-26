package api.allegro.service;

/**
 * Created by tjago on 2015-11-22.
 */
public class AllegroItem {

    private long mId;
    private String mImageUrl;
    private String mPageUrl;
    private String mName;
    private long mCategoryId;

    public AllegroItem() {
    }

    public AllegroItem(long mId, String mImageUrl, String mPageUrl, String mName, long mCategoryId) {
        this.mId = mId;
        this.mImageUrl = mImageUrl;
        this.mPageUrl = mPageUrl;
        this.mName = mName;
        this.mCategoryId = mCategoryId;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmPageUrl() {
        return mPageUrl;
    }

    public void setmPageUrl(String mPageUrl) {
        this.mPageUrl = mPageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public long getmCategoryId() {
        return mCategoryId;
    }

    public void setmCategoryId(long mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    @Override
    public String toString() {
        return "AllegroItem{" +
                "mId=" + mId +
                ", mImageUrl='" + mImageUrl + '\'' +
                ", mPageUrl='" + mPageUrl + '\'' +
                ", mName='" + mName + '\'' +
                ", mCategoryId=" + mCategoryId +
                '}';
    }
}
