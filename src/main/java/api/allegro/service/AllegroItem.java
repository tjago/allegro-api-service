package api.allegro.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by tjago on 2015-11-22.
 */
public class AllegroItem {

    @JsonIgnore
    private long mId;

    private String mImageUrl;
    private String mPageUrl;
    private String mName;

    @JsonIgnore
    private long mCategoryId;

    @JsonIgnore
    private int sellerId;

    public AllegroItem() {
    }

    public AllegroItem(long mId, String mImageUrl, String mPageUrl, String mName, long mCategoryId, int sellerId) {
        this.mId = mId;
        this.mImageUrl = mImageUrl;
        this.mPageUrl = mPageUrl;
        this.mName = mName;
        this.mCategoryId = mCategoryId;
        this.sellerId = sellerId;
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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "AllegroItem{" +
                "mId=" + mId +
                ", mImageUrl='" + mImageUrl + '\'' +
                ", mPageUrl='" + mPageUrl + '\'' +
                ", mName='" + mName + '\'' +
                ", mCategoryId=" + mCategoryId +
                ", sellerId=" + sellerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllegroItem that = (AllegroItem) o;

        if (mCategoryId != that.mCategoryId) return false;
        return sellerId == that.sellerId;

    }

    @Override
    public int hashCode() {
        int result = (int) (mCategoryId ^ (mCategoryId >>> 32));
        result = 31 * result + sellerId;
        return result;
    }
}
