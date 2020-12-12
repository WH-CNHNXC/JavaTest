package cn.xlmdz.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<Integer> mLikedNumber;

    public MutableLiveData<Integer> getLikedNumber() {
        if (mLikedNumber == null) {
            mLikedNumber = new MutableLiveData<Integer>();
            mLikedNumber.setValue(0);
        }
        return mLikedNumber;
    }

    public void addLikedNumber(int n) {
        mLikedNumber.setValue(mLikedNumber.getValue() + n);
    }
}
