package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

/**
 * 角标的定位规则
 * Created by hackware on 2016/7/19.
 */
class BadgeRule {
    private BadgeAnchor mAnchor;
    private int mOffset;

    public BadgeRule(BadgeAnchor anchor, int offset) {
        mAnchor = anchor;
        mOffset = offset;
    }

    BadgeAnchor getAnchor() {
        return mAnchor;
    }

    public void setAnchor(BadgeAnchor anchor) {
        mAnchor = anchor;
    }

    int getOffset() {
        return mOffset;
    }

    public void setOffset(int offset) {
        mOffset = offset;
    }
}
