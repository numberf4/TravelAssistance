package com.number4.travelassistance.viewModel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapViewModel extends ViewModel {
    private LifecycleOwner lifecycleOwner;

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner;
    }

    public MutableLiveData<Boolean> isPickSearch = new MutableLiveData<Boolean>(false);
    public MutableLiveData<Boolean> isPickDestination = new MutableLiveData<Boolean>(false);
    public MutableLiveData<Boolean> isShowPath = new MutableLiveData<Boolean>(false);
    public MutableLiveData<Boolean> getIsPickSearch() {
        return isPickSearch;
    }
    public MutableLiveData<Boolean> getIsPickDestination() {
        return isPickDestination;
    }

    public void setIsPickDestination(Boolean isPickDestination) {
        this.isPickDestination.postValue(isPickDestination);
    }

    public void setIsShowPath(Boolean isShowPath) {
        this.isShowPath.postValue(isShowPath);
    }

    public MutableLiveData<Boolean> getIsShowPath() {
        return isShowPath;
    }

    public void setIsPickSearch(Boolean isPickSearch) {
        this.isPickSearch.postValue(isPickSearch);
    }

    public void changeStatusIsPick() {
        Boolean value = getIsPickSearch().getValue();
        this.isPickSearch.postValue(!value);
    }

    public void changeStatusIsPickDes() {
        Boolean value2 = getIsPickDestination().getValue();
        this.isPickDestination.postValue(!value2);
    }
}
